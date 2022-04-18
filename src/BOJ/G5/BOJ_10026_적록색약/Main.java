package BOJ.G5.BOJ_10026_적록색약;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N,ans;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};	
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		//정상
		char[][] map1 = new char[N][N];
		//색약
		char[][] map2 = new char[N][N];
		for (int i=0;i<N;i++) {
			String line = br.readLine();
			for (int j=0;j<N;j++) {
				map1[i][j] = line.charAt(j);
				map2[i][j] = line.charAt(j);
				if (map2[i][j]=='G') map2[i][j]='R';
			}
		}
		
		StringBuilder sb = new StringBuilder();
		ans = 0;
		visited = new boolean[N][N];
		for (int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				if(dfs(map1,i,j)) ans++;
			}
		}
		
		sb.append(ans).append(" ");
		
		ans = 0;
		visited = new boolean[N][N];
		for (int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				if(dfs(map2,i,j)) ans++;
			}
		}
		
		sb.append(ans);
		
		System.out.println(sb.toString());
	}
	
	static boolean dfs(char[][] map, int x, int y) {
		if (visited[x][y]) return false;
		visited[x][y] = true;
		
		for (int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if (isInMap(nx,ny)&&map[x][y]==map[nx][ny]) {
				dfs(map,nx,ny);
			}
		}
		return true;
	}
	
	static boolean isInMap(int x, int y) {
		return x>=0&&x<N&&y>=0&&y<N;
	}

}
