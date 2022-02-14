package BOJ.G4.BOJ_1967_트리의지름;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int maxDist = 0;
	static boolean[] visited;
	static ArrayList<int[]>[] graph;
	
	static void dfs(int node, int dist) {
		
		maxDist = Math.max(maxDist, dist);
		
		for (int[] child:graph[node]) {
			if (!visited[child[0]]) {
				visited[child[0]] = true;
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
		
		ArrayList<Integer> leaf = new ArrayList<>();
		for (int i=1;i<=N;i++) {
			if (graph[i].size()==1) leaf.add(i);
		}
		
		
		for (int i=0;i<leaf.size();i++) {
			int start = leaf.get(i);
			
			visited = new boolean[N+1];
			
			visited[start] = true;
			
			dfs(start,0);
			
			
		}
		
		System.out.println(maxDist);
		
	}

}
