package SWEA.D4.SWEA_7465_창용마을무리의개수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	static int[] parent;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			parent = new int[N+1];
			for (int i=0;i<N+1;i++) {
				parent[i] = i;
			}
			
			HashSet<Integer> group = new HashSet<>();
			
			for (int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine()," ");
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				union(a,b);
				
			}
			
			
			
			for (int i=1;i<N+1;i++) {
				group.add(findSet(i));
			}
			
			System.out.printf("#%d %d\n",tc,group.size());
		}
	

	}
	
	static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot!=bRoot) {
			parent[bRoot] = aRoot;
		}
	}
	
	static int findSet(int a) {
		if (parent[a]==a) return a;
		parent[a] = findSet(parent[a]);
		return parent[a];
	}
}
