package JOL.JOL_1082_»≠ø∞ø°º≠≈ª√‚;

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
	static int[][] visited;
	static Queue<Point> q = new LinkedList<>();

	
	static class Point {
		int x,y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static boolean isIn(int nx, int ny) {
		if (nx>=0&&nx<R&&ny>=0&&ny<C) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		
		visited = new int[R][C];
		
		Point start = null , end = null;
		
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == 'S') {
					start = new Point(i,j);
				} else if (map[i][j] == 'D') {
					end = new Point(i,j);
				} else if (map[i][j]=='*') {
					q.offer(new Point(i,j));
					
				}
			}
		}


		bfs(start, end);
		
		int ans = 0;
		if (visited[end.x][end.y]==0) {
			ans = -1;
		} else {
			ans = visited[end.x][end.y];
		}
		
		if (ans==-1) {
			System.out.println("impossible");
		} else {
			System.out.println(ans);
		}
	}

	static void bfs(Point start, Point end) {
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		q.offer(start);
		
		while (!q.isEmpty()) {
			Point cur = q.poll();
			char a = map[cur.x][cur.y]; 
			
			if(a=='S') {
				for (int i=0;i<4;i++) {
					int nx = cur.x + dx[i];
					int ny = cur.y + dy[i];
					
					if (isIn(nx,ny)&&(map[nx][ny]=='.'||map[nx][ny]=='D'&&visited[nx][ny]==0)) {
						visited[nx][ny] = visited[cur.x][cur.y] + 1;
						map[nx][ny] = 'S';
						q.offer(new Point(nx,ny));
					}
				}
			} else if (a=='*') {
				for (int i=0;i<4;i++) {
					int nx = cur.x + dx[i];
					int ny = cur.y + dy[i];
					
					if (isIn(nx,ny)&&(map[nx][ny]=='.'||map[nx][ny]=='.'&&visited[nx][ny]==0)) {
						visited[nx][ny] = -1;
						map[nx][ny] = '*';
						q.offer(new Point(nx,ny));
					}
				}
			}
			
			for(int i=0;i<R;i++) {
				System.out.println(Arrays.toString(visited[i]));
			}
			System.out.println();
		}

	}
	

}
