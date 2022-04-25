package BOJ.S2.BOJ_2004_조합0의개수;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextInt();
		long m = sc.nextInt();
		long k = n-m;
		
		long ten = Math.min(calcTwo(n)-calcTwo(m)-calcTwo(k), calcFive(n)-calcFive(m)-calcFive(k));
		
		
		if (ten<0) System.out.println(0);
		else System.out.println(ten);
	}
	
	static long calcTwo(long n) {
		long cnt = 0;
		for (long i=2;i<=n;i*=2) {
			cnt+= (n/i);
		}
		
		return cnt;
	}
	
	static long calcFive(long n) {
		long cnt = 0;
		for (long i=5;i<=n;i*=5) {
			cnt+= (n/i);
		}
		
		return cnt;
	}
}
