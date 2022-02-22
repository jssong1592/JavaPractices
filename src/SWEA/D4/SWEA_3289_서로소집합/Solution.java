package SWEA.D4.SWEA_3289_서로소집합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] parent;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			parent = new int[n+1];
			for (int i=0;i<n+1;i++) {
				parent[i] = i;
			}
			
			StringBuilder sb = new StringBuilder();
			
			for (int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				
				int cmd = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				
				
				switch (cmd) {
				case 0:
					union(a,b);
					break;
				case 1: 
					
					if (findSet(a)==findSet(b)) sb.append("1");
					else sb.append("0");
					break;
				}
			}
			
			System.out.printf("#%d %s\n",tc,sb.toString());
		}

	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot==bRoot) return false;
		parent[bRoot] = aRoot;
		return true;
		
	}
	
	static int findSet(int a) {
		if (parent[a]==a) return a;
		parent[a] = findSet(parent[a]);
		
		return parent[a];
	}

}
