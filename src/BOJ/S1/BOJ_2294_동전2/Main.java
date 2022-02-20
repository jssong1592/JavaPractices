package BOJ.S1.BOJ_2294_µ¿Àü2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] resultList = new int[10001];
		
		Arrays.fill(resultList, -1);
		
		int[] coins = new int[n];
		
		for (int i=0;i<n;i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(coins);
		
		for (int i=n-1;i>=0;i--) {
			int c = coins[i];
			int cnt = 1;
			for (int j=c;j<10001;j+=c) {
				if (resultList[j]==-1) resultList[j] = cnt;
				else resultList[j] = resultList[j]>cnt?cnt:resultList[j];
				cnt++;
			}
		}
		
		for (int i=0;i<10001;i++) {
			if (resultList[i]!=-1) {
				for (int coin:coins) {
					if (i+coin<10001) {
						if (resultList[i+coin]==-1) resultList[i+coin] = resultList[i] + 1;
						else resultList[i+coin] = Math.min(resultList[i+coin], resultList[i]+1);
					}
				}
			}
		}
		
		System.out.println(resultList[k]);
		
		
	}

}
