package BOJ.G1.BOJ_11401_이항계수3;

import java.util.Scanner;

public class Main {
	static int mod = 1000000007;
	static long[] factorial;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		factorial = new long[4000001];
		factorial[0] = 1;
		
		for (int i=1;i<4000001;i++) {
			factorial[i] = (factorial[i-1]*i) % mod;
		}
		
		//NcR = N!*1/(N-R)! * 1/R!
		//-> (N! % mod * (N-R)!^(mod-2) % mod * R!^(mod-2) % mod) % mod
		
		long bottom = (factorial[k] * factorial[n-k]) % mod;
		bottom = power(bottom, mod-2);
		
		System.out.println((factorial[n]*bottom)%mod);
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
