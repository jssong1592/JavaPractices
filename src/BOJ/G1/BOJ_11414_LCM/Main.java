package BOJ.G1.BOJ_11414_LCM;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int ans = 0;
		int maxGCD = Integer.MIN_VALUE;
		int minLCM = Integer.MAX_VALUE;
		int range = Math.max(A, B);
		for (int N=2;N<=range;N++) {
			int temp = gcd(gcd(A,B),N);
			int lcm = (A+N)*(B+N)/temp;
			if (lcm<minLCM) {
				ans = N;
				minLCM = lcm;
			}
		}
		System.out.println(ans);
	}
	
	static int gcd(int a,int b) {
		if (b==0) return a;
		return gcd(b,a%b);
	}

}
