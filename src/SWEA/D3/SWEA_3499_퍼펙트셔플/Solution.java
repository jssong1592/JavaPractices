package SWEA.D3.SWEA_3499_∆€∆Â∆Æº≈«√;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc=0;tc<T;tc++) {
			
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String[] arr1 = new String[N/2 + N%2];
			String[] arr2 = new String[N/2];
			
			for (int i=0;i<arr1.length;i++) {
				arr1[i] = st.nextToken();
			}
			
			for (int i=0;i<arr2.length;i++) {
				arr2[i] = st.nextToken();
			}
			
			StringBuilder sb = new StringBuilder("#"+(tc+1)+" ");
			for (int i=0;i<N/2;i++) {
				sb.append(arr1[i]+" "+arr2[i]+" ");
			}
			if (N%2==1) sb.append(arr1[arr1.length-1]);
			
			System.out.println(sb);
		}

	}

}
