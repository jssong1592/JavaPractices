package BOJ.G4.BOJ_2638_치즈;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,time,cheese;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		cheese = 0;
		
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j]==1) cheese++;
			}
		}
		
		fillAir();
		int time = 0;
		while (cheese>0) {
			markCheese();
			
			removeCheese();
			
			flowAir();
			
			time++;
		}
		
		System.out.println(time);
	}
	
//	static void showMap() {
//		for (int i=0;i<N;i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
//		System.out.println();
//	}
	
	static void fillAir() {
		Queue<int[]> q = new LinkedList<>();
		
		q.offer(new int[] {0,0});
		map[0][0] = 2;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			
			for (int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (isInMap(nx,ny)&&map[nx][ny]==0) {
					map[nx][ny] = 2;
					q.offer(new int[] {nx,ny});
				}
			}
		}
	}
	
	static boolean isInMap(int x,int y) {
		return x>=0&&x<N&&y>=0&&y<M;
	}
	
	static void markCheese() {
		for (int i=0;i<N;i++) {
			for (int j=0;j<M;j++) {
				if (map[i][j]==1) {
					int cnt = 0;
					for (int k=0;k<4;k++) {
						int ni = i + dx[k];
						int nj = j + dy[k];
						if (map[ni][nj]==2) cnt++;
						if (cnt==2) break;
					}
					if (cnt==2) {
						map[i][j] = 3;
					}
				}
			}
		}
	}
	
	static void removeCheese() {
		for (int i=0;i<N;i++) {
			for (int j=0;j<M;j++) {
				if (map[i][j]==3) {
					map[i][j]=2;
					cheese--;
				}
			}
		}
	}
	
	static void flowAir() {
		for (int i=0;i<N;i++) {
			for (int j=0;j<M;j++) {
				if (map[i][j]==2) {
					for (int k=0;k<4;k++) {
						int ni = i + dx[k];
						int nj = j + dy[k];
						if (isInMap(ni,nj)&&map[ni][nj]==0) {
							dfs(i,j);
						}
					}
					
				}
			}
		}
	}
	
	static void dfs(int x,int y) {
		map[x][y] = 2;
		for (int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (isInMap(nx,ny)&&map[nx][ny]==0) {
				dfs(nx,ny);
			}
		}
	}
}
