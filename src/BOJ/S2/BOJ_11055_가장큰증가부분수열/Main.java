package BOJ.S2.BOJ_11055_가장큰증가부분수열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		int[] dp = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=1;i<N+1;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1] = arr[1];
		
		for (int i=1;i<N+1;i++) {
			for (int j=0;j<i;j++) {
				if (arr[i]>arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + arr[i]);
					
				}
			}
		}
		
		int ans = 0;
		for (int i=1;i<N+1;i++) {
			if (ans<dp[i]) ans = dp[i];
		}
		
//		System.out.println(Arrays.toString(dp));
		System.out.println(ans);
	}

}
