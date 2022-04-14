package BOJ.S2.BOJ_4948_베르트랑공준;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		boolean[] isPrime = new boolean[2*123456+1];
		isPrime[2] = true;
		
		for (int i=3;i<2*123456+1;i++) {
			isPrime[i] = checkPrime(i);
		}
		
		while (true) {
			int n = sc.nextInt();
			if (n==0) break;
			int cnt = 0;
			for (int i=n+1;i<=2*n;i++) {
				if (isPrime[i]) cnt++;
			}
			System.out.println(cnt);
		}

	}
	
	static boolean checkPrime(int n) {
		if (n==1) return false;
		if (n%2==0) return false;
		for (int i=3;i<=Math.sqrt(n);i+=2) {
			if (n%i==0) return false;
		}
		return true;
		
	}

}
