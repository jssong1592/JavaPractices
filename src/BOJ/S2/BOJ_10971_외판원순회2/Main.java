package BOJ.S2.BOJ_10971_외판원순회2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] graph;
	static int minResult;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		graph = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
			
		}
		
		minResult = Integer.MAX_VALUE;
		
		for (int node=0;node<N;node++) {
			boolean[] visited = new boolean[N];
			visited[node] = true;
			dfs(node, node, visited, 1, 0);
		}
		
		System.out.println(minResult);

	}
	
	static void dfs(int start, int node, boolean[] visited, int cnt, int cost) {
		if (cnt==N) {
			if (graph[node][start]!=0) 
				minResult = Math.min(minResult, cost+graph[node][start]);
			return;
		}
		
		for (int i=0;i<N;i++) {
			if (!visited[i]&&graph[node][i]!=0) {
				visited[i] = true;
				dfs(start,i,visited,cnt+1,cost+graph[node][i]);
				visited[i] = false;
			}
		}
	}

}
