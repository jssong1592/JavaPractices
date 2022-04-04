package SWEA.D3.SWEA_2805_농작물수확하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] farm = new int[N][N];
			
			for (int i=0;i<N;i++) {
				String[] s = br.readLine().split("");
				for (int j=0;j<N;j++) {
					farm[i][j] = Integer.parseInt(s[j]);
				}
			}
			
			int sum = 0;
			for (int i=0;i<N/2;i++) {
				for (int j=N/2-i;j<(N/2-i)+(2*i+1);j++) {
					
					sum += farm[i][j];
				}
			}
			
			for (int i=N/2;i<N;i++) {
				for (int j=i-N/2;j<(i-N/2)+(2*(N-1-i)+1);j++) {
					
					sum += farm[i][j];
				}
			}
			
			System.out.printf("#%d %d%n",tc,sum);
		}

	}

}
