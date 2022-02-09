package SWEA.D3.SWEA_9229_ÇÑºóÀÌ¿ÍSpotMart;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=0;tc<T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			
			
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
			
			int max = 0;
			int total = 0;
			
			for (int i=0;i<N-1;i++) {
				for (int j=i+1;j<N;j++) {
					total = arr[i] + arr[j];
					if (total > max&&total <= M) max = total;
				}
			}
			
			
			System.out.printf("#%d ",tc+1);
			if (max==0) System.out.print(-1);
			else System.out.print(max);
			System.out.println();
			
			
		}
		
	}

}