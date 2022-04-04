package BOJ.S3.BOJ_1463_1로만들기;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] f = new int[1000001];
		f[0] = 0;
		f[1] = 0;
		for (int i=2;i<1000001;i++) {
			f[i] = f[i-1] + 1;
			if (i%3==0) {
				f[i] = Math.min(f[i/3] + 1, f[i]);
			}
			if (i%2==0) {
				f[i] = Math.min(f[i/2] + 1, f[i]);
			}
		}
		
		System.out.println(f[N]);
	}
	
}
