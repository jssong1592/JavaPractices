package JOL.JOL_2577_회전초밥고;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] table = new int[N+k];
		for (int i=0;i<N;i++) {
			table[i] = Integer.parseInt(br.readLine());
		}
		for (int i=N;i<N+k;i++) {
			table[i] = table[i-N];
		}
		

		int[] ate = new int[d+1];
		
		int maxCnt = -1;
		int cnt = 0;
		int coupon = 0;
		
		for (int i=0;i<N+k;i++) {
			if (i>=k) {
				if (--ate[table[i-k]]==0) cnt--;
				if (table[i-k]==c) coupon--;
			}
			if (++ate[table[i]]==1) cnt++;
			if (table[i]==c) coupon++;

			if (i>=k) {
				maxCnt = Math.max(maxCnt, coupon==0?cnt+1:cnt);
			}
			
		}
		
		System.out.println(maxCnt);
	}

}


