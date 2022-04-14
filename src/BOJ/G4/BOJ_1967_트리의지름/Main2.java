package BOJ.G4.BOJ_1967_트리의지름;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2 {
	
	static int maxDist = 0;
	static int farthestNode = 1;
	static boolean[] visited;
	static ArrayList<int[]>[] graph;
	
	static void dfs(int node, int dist) {
		visited[node] = true;
		
		if (maxDist<dist) {
			maxDist = dist;
			farthestNode = node;
		}
		
		for (int[] child:graph[node]) {
			if (!visited[child[0]]) {
				dfs(child[0],dist+child[1]);
			}
			
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N+1];
		
		for (int i=0;i<N+1;i++) graph[i] = new ArrayList<int[]>();
		
		for (int i=0;i<N-1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			graph[parent].add(new int[] {child,weight});
			graph[child].add(new int[] {parent,weight});
		}
		
		
		visited = new boolean[N+1];
		dfs(1,0);
		
//		System.out.println(farthestNode);
//		System.out.println(maxDist);
		
		maxDist = 0;
		visited = new boolean[N+1];
		
		dfs(farthestNode,0);
		
		System.out.println(maxDist);
	}

}
