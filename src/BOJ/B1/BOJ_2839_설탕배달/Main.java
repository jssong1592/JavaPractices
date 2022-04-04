package BOJ.B1.BOJ_2839_설탕배달;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int a = N/5;
		int b = N%5;
		
		while (b%3!=0) {
			if (a==0) break;
			a--;
			b+=5;
		}
		
		if (b%3==0) System.out.println(a+(b/3));
		else System.out.println(-1);
	}	
}
	