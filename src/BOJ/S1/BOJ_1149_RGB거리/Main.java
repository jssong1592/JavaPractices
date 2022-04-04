package BOJ.S1.BOJ_1149_RGB거리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] cost = new int[N][3];
		
		for (int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int G = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			cost[i][0] = R;
			cost[i][1] = G;
			cost[i][2] = B;
		}
		
		//dp 테이블 -> 마지막(N)번쨰 집이 R,G,B로 칠해졌을 때의 각각 최소 비용
		int[][] dp = new int[N][3];
		
		dp[0][0] = cost[0][0];
		dp[0][1] = cost[0][1];
		dp[0][2] = cost[0][2];
		
		for (int i=1;i<N;i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2];
		}
		
		int minCost = Integer.MAX_VALUE;
		
		for (int i=0;i<3;i++) {
			if (minCost > dp[N-1][i]) {
				minCost = dp[N-1][i];
			}
		}
		
		System.out.println(minCost);
		
	}

}
