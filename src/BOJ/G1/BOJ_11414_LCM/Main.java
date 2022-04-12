package BOJ.G1.BOJ_11414_LCM;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int ans = 1;
		
		int diff = Math.abs(A-B);
		if (diff==0) ans = 1;
		else {
			int minLCM = Integer.MAX_VALUE;
			for (int i=1;i<=Math.sqrt(diff);i++) {
				if (diff%i==0) {
					int temp = Math.max(i, diff/i);
					for (int n=temp;n>0;n--) {
						if ((A+n) % temp == 0 && (B+n) % temp == 0) {
							ans = n;
						}
					}
				}
			}
		}
		
		System.out.println(ans);
	}
	
	static int lcm(int x, int y) {
		return x*y/gcd(x,y);
	}
	
	static int gcd(int i, int j) {
		if (j==0) return i;
		return gcd(j,i%j);
	}

}
