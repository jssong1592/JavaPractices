package BOJ.G2.BOJ_1368_물대기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] matrix;
	static int[] root;
	static int[] selfCost;
	static boolean[] visited;
	
	static class Edge {
		int start, end, cost;
		public Edge(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
		
		@Override
		public String toString() {
			
			return "Edge "+start+" "+end+" "+cost;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		matrix = new int[N+1][N+1];
		root = new int[N+1];
		visited = new boolean[N+1];
		for (int i=0;i<N+1;i++) {
			root[i] = i;
		}
		
		ArrayList<Edge> edgeList = new ArrayList<>();
		
		for (int i=1;i<=N;i++) {
			int cost = Integer.parseInt(br.readLine());
			edgeList.add(new Edge(0,i,cost));
		}
		
		for (int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=1;j<=N;j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i=1;i<=N-1;i++) {
			for (int j=i+1;j<=N;j++) {
				edgeList.add(new Edge(i,j,matrix[i][j]));
			}
		}
		
		edgeList.sort((o1,o2)->Integer.compare(o1.cost, o2.cost));
//		System.out.println(edgeList);
		
		int totalCost = 0;
		int cnt = 0;
		for (Edge e:edgeList) {
			if (union(e.start,e.end)) {
				cnt++;
				totalCost += e.cost;
			}
			if (cnt==N) break;
		}
		
//		System.out.println(Arrays.toString(root));
		
		System.out.println(totalCost);
	}
	
	static int findSet(int a) {
		if (root[a]==a) return a;
		root[a] = findSet(root[a]);
		return root[a];
	}
	
	static boolean union(int a,int b) {
		if (a==b) return true;
		int rootA = findSet(a);
		int rootB = findSet(b);
		if (rootA==rootB) return false;
		if (rootA<rootB) {
			root[rootB] = rootA;
		} else {
			root[rootA] = rootB;
		}
		return true;
	}
}
