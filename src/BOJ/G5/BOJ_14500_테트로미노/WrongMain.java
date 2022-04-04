package BOJ.G5.BOJ_14500_테트로미노;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WrongMain {
	static int[][] map;
	static int maxResult = 0;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int N,M;
	
	static void dfs(int cnt, int x, int y, int sum,boolean[][] visited) {
	
//		System.out.println(cnt+" "+x+" "+y);
		if (cnt==4) {
//			System.out.println(sum);
			maxResult = Math.max(maxResult, sum);
			return;
		}
		visited[x][y] = true;
		for (int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0>nx||nx>=N||0>ny||ny>=M||visited[nx][ny]) continue;
			visited[nx][ny] = true;
			dfs(cnt+1,nx,ny,sum+map[nx][ny],visited);
		
		}
		visited[x][y] = false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i=0;i<N;i++) {
			for (int j=0;j<M;j++) {
//				System.out.println("i:"+i+" j:"+j);
				
				dfs(1,i,j,map[i][j],visited);
				
			}
		}
		
		System.out.println(maxResult);
	}

}
