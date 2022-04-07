package SWEA.SWEA_1953_탈주범검거;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N, M, R, C, L;
	static int[][] map;
	static boolean[][] visited;

	static class Point {
		int x, y, type, time, dir;

		public Point(int x, int y, int type, int time, int dir) {
			this.x = x;
			this.y = y;
			this.type = type;
			this.time = time;
			this.dir = dir;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			visited = new boolean[N][M];
			int ans = 1;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			Queue<Point> queue = new LinkedList<>();

			switch (map[R][C]) {
			case 1:
				queue.offer(new Point(R,C,map[R][C],1,0));
				queue.offer(new Point(R,C,map[R][C],1,1));
				queue.offer(new Point(R,C,map[R][C],1,2));
				queue.offer(new Point(R,C,map[R][C],1,3));
				break;
			case 2:
				queue.offer(new Point(R,C,map[R][C],1,0));
				queue.offer(new Point(R,C,map[R][C],1,1));
				break;
			case 3:
				queue.offer(new Point(R,C,map[R][C],1,2));
				queue.offer(new Point(R,C,map[R][C],1,3));
				break;
			case 4:
				queue.offer(new Point(R,C,map[R][C],1,0));
				queue.offer(new Point(R,C,map[R][C],1,3));
				break;
			case 5:
				queue.offer(new Point(R,C,map[R][C],1,1));
				queue.offer(new Point(R,C,map[R][C],1,3));
				break;
			case 6:
				queue.offer(new Point(R,C,map[R][C],1,1));
				queue.offer(new Point(R,C,map[R][C],1,2));
				break;
			case 7:
				queue.offer(new Point(R,C,map[R][C],1,0));
				queue.offer(new Point(R,C,map[R][C],1,2));
				break;
			default:
				break;
			}
			visited[R][C] = true;

			while (!queue.isEmpty()) {
				Point point = queue.poll();
				int x = point.x;
				int y = point.y;
				int type = point.type;
				int time = point.time;
				int dir = point.dir;

				

				int[] dx = findDx(type);
				int[] dy = findDy(type);

			
					int nx = x + dx[dir];
					int ny = y + dy[dir];
					//범위 안에 있고, 아직 탐색하지 않은 곳이고,
					if (isIn(nx, ny) && !visited[nx][ny]
							// 파이프가 있고, 파이프가 연결된 곳일 때
							&& map[nx][ny] > 0 && isReachable(dir,type,map[nx][ny])) {
						visited[nx][ny] = true;
//						if (nx==1&&ny==3) {
//							System.out.println(dir+" "+type+" "+map[nx][ny]);
//							for (int k=0;k<N;k++) { 
//								System.out.println(Arrays.toString(visited[k]));
//							}
//							System.out.println();
//						}
						if (time<L) ans++;
						queue.offer(new Point(nx,ny,map[nx][ny],time+1,dir));
						switch (map[nx][ny]) {
						case 1:
							queue.offer(new Point(nx,ny,map[nx][ny],time+1,0));
							queue.offer(new Point(nx,ny,map[nx][ny],time+1,1));
							queue.offer(new Point(nx,ny,map[nx][ny],time+1,2));
							queue.offer(new Point(nx,ny,map[nx][ny],time+1,3));
							break;
						case 2:
							queue.offer(new Point(nx,ny,map[nx][ny],time+1,0));
							queue.offer(new Point(nx,ny,map[nx][ny],time+1,1));
							break;
						case 3:
							queue.offer(new Point(nx,ny,map[nx][ny],time+1,2));
							queue.offer(new Point(nx,ny,map[nx][ny],time+1,3));
							break;
						case 4:
							queue.offer(new Point(nx,ny,map[nx][ny],time+1,0));
							queue.offer(new Point(nx,ny,map[nx][ny],time+1,3));
							break;
						case 5:
							queue.offer(new Point(nx,ny,map[nx][ny],time+1,1));
							queue.offer(new Point(nx,ny,map[nx][ny],time+1,3));
							break;
						case 6:
							queue.offer(new Point(nx,ny,map[nx][ny],time+1,1));
							queue.offer(new Point(nx,ny,map[nx][ny],time+1,2));
							break;
						case 7:
							queue.offer(new Point(nx,ny,map[nx][ny],time+1,0));
							queue.offer(new Point(nx,ny,map[nx][ny],time+1,2));
							break;
						default:
							break;
						}
					
				}

			}
//
//			for (int i=0;i<N;i++) { 
//				System.out.println(Arrays.toString(visited[i]));
//			}
			
			System.out.printf("#%d %d\n",tc,ans);

		}
	}

	static boolean isIn(int x, int y) {
		return (x >= 0 && x < N && y >= 0 && y < M);
	}

	static boolean isReachable(int dir, int type, int nextType) {
		switch (dir) {
		case 0:
			if (nextType==1||nextType==2||nextType==5||nextType==6) {
				if (type==1||type==2||type==4||type==7) return true;
			}
			return false;
		case 1:
			if (nextType==1||nextType==2||nextType==4||nextType==7) {
				if (type==1||type==2||type==5||type==6) return true;
			}
			return false;
		case 2:
			if (nextType==1||nextType==3||nextType==4||nextType==5) {
				if (type==1||type==3||type==6||type==7) return true;				
			}
			return false;
		case 3:
			if (nextType==1||nextType==3||nextType==6||nextType==7) {
				if (type==1||type==3||type==4||type==5)return true;
			}
			return false;
		default:
			return false;
		}
	}

	static int[] findDx(int type) {
		switch (type) {
		case 1:
			return new int[] { -1, 1, 0, 0 };
		case 2:
			return new int[] { -1, 1, 0, 0 };
		case 3:
			return new int[] { 0, 0, 0, 0 };
		case 4:
			return new int[] { -1, 0, 0, 0 };
		case 5:
			return new int[] { 0, 1, 0, 0 };
		case 6:
			return new int[] { 0, 1, 0, 0 };
		case 7:
			return new int[] { -1, 0, 0, 0 };
		default:
			return null;
		}
	}

	static int[] findDy(int type) {
		switch (type) {
		case 1:
			return new int[] { 0, 0, -1, 1 };
		case 2:
			return new int[] { 0, 0, 0, 0 };
		case 3:
			return new int[] { 0, 0, -1, 1 };
		case 4:
			return new int[] { 0, 0, 0, 1 };
		case 5:
			return new int[] { 0, 0, 0, 1 };
		case 6:
			return new int[] { 0, 0, -1, 0 };
		case 7:
			return new int[] { 0, 0, -1, 0 };
		default:
			return null;
		}
	}

}
