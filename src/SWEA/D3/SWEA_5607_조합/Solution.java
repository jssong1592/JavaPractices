package SWEA.D3.SWEA_5607_조합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int mod = 1234567891;
	static long[] factorial;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		factorial = new long[1000001];
		factorial[0] = 1;
		
		for (int i=1;i<1000001;i++) {
			factorial[i] = (factorial[i-1]*i)%mod;
		}
		
		
		int T = Integer.parseInt(br.readLine());
		for (int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			//NcR mod 1234567891
			
			//NcR = N!*1/(N-R)! * 1/R!
			//-> (N! % mod * (N-R)!^(mod-2) % mod * R!^(mod-2) % mod) % mod
			
			
			
			long bottom = (factorial[R] * factorial[N-R]) % mod;
			bottom = power(bottom, mod-2);
			
			System.out.printf("#%d %d\n",tc,(factorial[N]*bottom)%mod);
		}
	}
	
	static long power(long a, long p) {
		if (p==0) return 1;
		if (p==1) return a;
		
		if (p%2==0) {
			long temp = power(a, p/2);
			return (temp * temp) % mod;
		}
		
		long temp = power(a,p-1) % mod;
		return (temp*a)%mod;
		
	}

}
