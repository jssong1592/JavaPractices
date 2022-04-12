package BOJ.S3.BOJ_1929_소수구하기;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		
		for (int i=M;i<=N;i++) {
			if (checkPrime(i))
				sb.append(i).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static boolean checkPrime(int n) {
		if (n==1) return false;
		if (n==2) return true;
		if (n%2==0) return false;
		for (int i=3;i<=Math.sqrt(n);i+=2) {
			if (n%i==0) return false;
		}
		return true;
	}

}
