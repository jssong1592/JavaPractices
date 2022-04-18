package BOJ.G3.BOJ_1644_소수의연속합;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		ArrayList<Integer> primes = new ArrayList<>();
		primes.add(2);
		for (int i=3;i<N+1;i+=2) {
			if(checkPrime(i)) primes.add(i);
		}
		
//		System.out.println(primes);
		int ans = 0;
		int i = 0;
		int j = 1;
		while (i<primes.size()) {
			int sum = getSum(primes,i,j);
			if (sum==N) {
				ans++;
				i++;
				j = i+1;
			} else if (sum<N) {
				j++;
				if (j>primes.size()) {
					i++;
					j = i+1;
				}
			} else if (sum>N) {
				i++;
				j = i+1;
			}
		}
		
		System.out.println(ans);
	}
	
	static boolean checkPrime(int n) {
		for (int i=3;i<=Math.sqrt(n);i+=2) {
			if (n%i==0) return false;
		}
		return true;
	}
	
	static int getSum(ArrayList<Integer> primes, int i, int j) {
		int sum = 0;
		for (int idx=i;idx<j;idx++) {
			sum += primes.get(idx);
		}
		
		return sum;
	}
}
