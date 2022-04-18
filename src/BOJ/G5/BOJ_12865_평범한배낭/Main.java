package BOJ.G5.BOJ_12865_평범한배낭;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] weights = new int[N+1];
		int[] values = new int[N+1];
		int ans = Integer.MIN_VALUE;
		
		for (int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			weights[i] = Integer.parseInt(st.nextToken());
			values[i] = Integer.parseInt(st.nextToken());
		}
		//sack[i][j] -> 물건 한 종류 추가될때, j에 해당하는 무게까지 넣었을 때 최대 가치
		int[][] sack = new int[N+1][K+1];
		for (int i=1;i<N+1;i++) {
			for (int j=1;j<K+1;j++) {
				if (j-weights[i]>=0)
					sack[i][j] = Math.max(sack[i-1][j-weights[i]]+values[i], sack[i-1][j]);
				else 
					sack[i][j] = sack[i-1][j];
			}
		}
		
		System.out.println(sack[N][K]);

	}

}
