package BOJ.S3.BOJ_9613_GCD합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		for (int tc=1;tc<=t;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			for (int i=0;i<n;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			long total = 0;
			
			for (int i=0;i<n-1;i++) {
				for (int j=i+1;j<n;j++) {
					total += gcd(arr[i],arr[j]);
				}
			}
			System.out.println(total);
		}

	}
	
	static int gcd(int i, int j) {
		if (j==0) return i;
		return gcd(j,i%j);
	}

}
