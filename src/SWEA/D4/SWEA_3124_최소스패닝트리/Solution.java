package SWEA.D4.SWEA_3124_최소스패닝트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			ArrayList<int[]>[] adjList = new ArrayList[V+1];
			for (int i=0;i<V+1;i++) {
				adjList[i] = new ArrayList<int[]>();
			}
			
			boolean[] visited = new boolean[V+1];
			
			int[] minEdge = new int[V+1];
			
			for (int i=0;i<V+1;i++) {
				minEdge[i] = Integer.MAX_VALUE;
			}
			
			PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)-> {
				int[] a = (int[]) o1;
				int[] b = (int[]) o2;
				
				return a[1]-b[1];
			}); 
			
			for (int i=0;i<E;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				adjList[a].add(new int[]{b,c});
				adjList[b].add(new int[]{a,c});
			}
			
			int cnt = 0;
			long result = 0;
			pq.offer(new int[] {1,0}); 
			
			
			while (!pq.isEmpty()) {
				int[] edge = pq.poll();
				
				if (visited[edge[0]]) continue;
				visited[edge[0]] = true;
				
				result += edge[1];
				
				for (int[] next:adjList[edge[0]]) {
					if (!visited[next[0]]) {
						pq.offer(next);
					}
				}
				
				if (++cnt==V) break;
				
			}
			
			System.out.printf("#%d %d\n",tc,result);
			
		}
	}
}
