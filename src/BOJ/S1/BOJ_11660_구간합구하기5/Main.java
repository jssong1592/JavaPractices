package BOJ.S1.BOJ_11660_구간합구하기5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] matrix = new int[N+1][N+1];
		for (int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=1;j<=N;j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i=1;i<=N;i++) {
			for (int j=1;j<=N;j++) {
				matrix[i][j] += matrix[i][j-1];
			}
		}
		
		for (int i=1;i<=N;i++) {
			for (int j=1;j<=N;j++) {
				matrix[i][j] += matrix[i-1][j];
			}
		}
		
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			System.out.println(matrix[x2][y2]-matrix[x1-1][y2]-matrix[x2][y1-1]+matrix[x1-1][y1-1]);
		}
	}

}
