package SWEA.D5.SWEA_3238_이항계수구하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	int[][] cache;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			long n = Long.parseLong(st.nextToken());
			long r = Long.parseLong(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			long[] factorial = new long[p+1];
			factorial[0] = 1;
			for (int i=1;i<p+1;i++) {
				factorial[i] = (factorial[i-1] * i) % p;
			}
			
			long ans = 1;
			
			while (n>0||r>0) {
				int x = (int)(n % p);
				int y = (int)(r % p);
				
				if (y>x) {
					ans = 0;
					break;
				}
				
				ans = (ans * factorial[x]) % p;
				for (int i=0;i<p-2;i++) {
					ans = (ans*factorial[x-y]*factorial[y]) % p;
				}
				n /= p;
				r /= p;
			}
			
			System.out.printf("#%d %d\n",tc,ans);
		}

	}

}
