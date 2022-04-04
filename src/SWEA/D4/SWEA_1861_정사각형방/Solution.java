package SWEA.D4.SWEA_1861_정사각형방;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[][] map;
	static int[] result;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int curStep;
	static int maxStep;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			result = new int[N*N+1];
						
			for (int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for (int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			maxStep = -1;
			for (int i=0;i<N;i++) {
				for (int j=0;j<N;j++) {
					curStep = -1;
					dfs(i,j,1);
					result[map[i][j]] = curStep;
					maxStep = Math.max(maxStep, curStep);
				}
			}
			
			for (int i=1;i<N*N+1;i++) {
				if (result[i]==maxStep) {
					sb.append("#"+tc+" "+i+" "+maxStep+"\n");
					break;
				}
			}
			
		}
		
		System.out.println(sb);

	}
	
	static void dfs(int i, int j, int step) {
		curStep = Math.max(curStep, step);
		for (int x=0;x<4;x++) {
			int nx = i + dx[x];
			int ny = j + dy[x];
			
			if (nx>=0&&nx<N&&ny>=0&&ny<N) {
				if (map[nx][ny]==map[i][j]+1) {
					dfs(nx,ny,step+1);
				}
			}
		}
	}

}
