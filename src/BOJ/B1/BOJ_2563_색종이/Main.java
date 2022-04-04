package BOJ.B1.BOJ_2563_색종이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		int[][] map = new int[100][100];
		int total = 0;
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for (int j=x;j<x+10;j++) {
				for (int k=y;k<y+10;k++) {
					map[j][k] = 1;
				}
			}
			
		}
		
		for (int j=0;j<100;j++) {
			for (int k=0;k<100;k++) {
				total += map[j][k];
			}
		}
		
		System.out.println(total);

	}

}
