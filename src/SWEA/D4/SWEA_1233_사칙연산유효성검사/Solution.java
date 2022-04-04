package SWEA.D4.SWEA_1233_사칙연산유효성검사;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static StringBuilder sb;
	static String[] nodes;
	static int[][] child;
	
	static void dfsByInOrder(int node) {
		if (node==0) return;
		
		dfsByInOrder(child[node][0]);
		
		sb.append(nodes[node]);
		
		dfsByInOrder(child[node][1]);
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc=1;tc<=10;tc++) {
			int N = Integer.parseInt(br.readLine());
			
			nodes = new String[N+1];
			child = new int[N+1][2];
			sb = new StringBuilder();
		
			for (int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				
				int num = Integer.parseInt(st.nextToken());
				String node = st.nextToken();
				
				nodes[num] = node;
				
				int temp = 0;
				while(st.hasMoreTokens()) {
					int childNum = Integer.parseInt(st.nextToken());
					child[num][temp++] = childNum; 
				}
			}
			
			dfsByInOrder(1);

			int ans = 1;
			for (int i=0;i<sb.length();i++) {
				if (i%2==0&&(sb.charAt(i)=='+'||sb.charAt(i)=='-'||sb.charAt(i)=='*'||sb.charAt(i)=='/')) {
					ans = 0;
					break;
				}
			}
			System.out.printf("#%d %d%n",tc,ans);
			
			
		}

	}

}
