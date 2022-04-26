package BOJ.G5.BOJ_1351_무한수열;

import java.util.Scanner;

public class Main {
	static long P,Q;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		long N = sc.nextLong();
		P = sc.nextLong();
		Q = sc.nextLong();
		
		System.out.println(process(N));
	}
	
	static long process(long n) {
		if (n==0) return 1;
		return process(n/P) + process(n/Q);
	}

}
