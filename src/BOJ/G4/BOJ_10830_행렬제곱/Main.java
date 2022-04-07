package BOJ.G4.BOJ_10830_행렬제곱;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		int[][] matrix = new int[N][N];
		
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<N;j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] result = process(matrix, B);
		
		for (int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				result[i][j] %= 1000;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				sb.append(result[i][j]);
				if (j<N-1) sb.append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static int[][] process(int[][] matrix, long B) {
		if (B==1) return matrix;
		int[][] temp = process(matrix,B/2);
		
		if (B%2==1) {
			return product(product(temp,temp),matrix);
		}
		else 
			return product(temp,temp);
	}
	
	static int[][] product(int[][] matrix1, int[][] matrix2) {
		int[][] result = new int[N][N];
		
		for (int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				result[i][j] = sum(i,j,matrix1,matrix2);
			}
		}
		
		return result;
	}
	
	static int sum(int i,int j, int[][] matrix1, int[][] matrix2) {
		int total = 0;
		for (int k=0;k<N;k++) {
			total += matrix1[i][k] * matrix2[k][j];
		}
		return total % 1000;
	}
}
