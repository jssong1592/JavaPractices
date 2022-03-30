package JOL.JOL_1082_화염에서탈출;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R;
	static int C;
	static char[][] map;
	static int[][] time;
	static boolean[][] visited;
	static int startX, startY, endX, endY;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		time = new int[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == 'S') {
					startX = i;
					startY = j;
				} else if (map[i][j] == 'D') {
					endX = i;
					endY = j;
				}
			}
		}

//		System.out.println(startX);
//		System.out.println(endX);

		int ans = bfs(new int[] { startX, startY });
		if (ans==-1) {
			System.out.println("impossible");
		} else {
			System.out.println(ans);
		}
	}

	static int bfs(int[] start) {
		Queue<int[]> q = new LinkedList<>();
		Queue<int[]> newQ = new LinkedList<>();
	
		Queue<int[]> fire = new LinkedList<>();
		Queue<int[]> newFire = new LinkedList<>();
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		visited[start[0]][start[1]] = true;
		q.offer(start);

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '*') {
					fire.offer(new int[] { i, j });
				}
			}
		}
		
		
		boolean flag = false;
		int time = 0;
		loop : while (!flag) {

			while (!q.isEmpty()) {
				int[] loc = q.poll();

				int x = loc[0];
				int y = loc[1];
				if (map[x][y]=='*') continue;
				// 이동
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];

					if (nx >= 0 && nx < R && ny >= 0 && ny < C && (map[nx][ny] == '.' || map[nx][ny] == 'D')) {
						
						//요새에 도착하면 loop stop
						if (map[nx][ny] == 'D') {
							flag = true;
							time++;
							break loop;
						}
						map[nx][ny] = 'S';
						newQ.offer(new int[] {nx,ny});
					}
				}
			}

			while (!newQ.isEmpty()) {
				q.offer(newQ.poll());
			}


			// 불 옮기기
			while (!fire.isEmpty()) {
				
				int[] f = fire.poll();
				int fX = f[0];
				int fY = f[1];
				for (int i = 0; i < 4; i++) {
					int nx = fX + dx[i];
					int ny = fY + dy[i];

					if (nx >= 0 && nx < R && ny >= 0 && ny < C && (map[nx][ny] == '.' || map[nx][ny] == 'S')) {
						map[nx][ny] = '*';
						newFire.offer(new int[] {nx,ny});
					}
				}
			}

			while (!newFire.isEmpty()) {
				fire.offer(newFire.poll());
			}
			
//			for (int i = 0; i < R; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			System.out.println();
//
			time++;
//			System.out.println(time);
			
			//불에 타죽었는지 확인, 살아있으면 루프 돌리기
			flag = true;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == 'S') {
						flag = false;
					}
				}
			}

		}
		
		//살아서 도착했으면 지도상에 S 남아있음. 없으면 flag=true ==> 불타죽음
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'S') {
					flag = false;
				}
			}
		}
		
		if (flag) time = -1;
		
		return time;

	}

}
