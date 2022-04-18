package BOJ.G5.BOJ_9084_동전;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			int[] coins = new int[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i=1;i<N+1;i++) {
				coins[i] = Integer.parseInt(st.nextToken());
			}
			int M = Integer.parseInt(br.readLine());
			
			int[] money = new int[M+1];
			money[0] = 1;
			for (int i=1;i<N+1;i++) {
				 for (int j=coins[i];j<M+1;j++) {
					 money[j] += money[j-coins[i]];
				 }
			}
			
			
			System.out.println(money[M]);
		}

	}

}
