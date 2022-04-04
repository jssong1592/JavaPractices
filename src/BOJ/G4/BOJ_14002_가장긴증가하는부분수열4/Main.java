package BOJ.G4.BOJ_14002_가장긴증가하는부분수열4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
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
		
		int maxCnt = 0;
		
		for (int i=1;i<N+1;i++) {
			
			for (int j=0;j<i;j++) {
				if (arr[i]>arr[j]) {
					dp[i] = Math.max(dp[j]+1, dp[i]);
					if (maxCnt<dp[i]) maxCnt = dp[i];
				}
			}
		}
		
		int cnt = maxCnt;
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i=N;i>0;i--) {
			if (cnt==dp[i]) {
				stack.push(arr[i]);
				cnt--;
			}
		}
		
		System.out.println(maxCnt);
//		System.out.println(Arrays.toString(dp));

		while (!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
		
		
		

	}
	

}
