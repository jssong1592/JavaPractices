package BOJ.G5.BOJ_1753_최단경로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V;
	static int E;
	static ArrayList<int[]>[] adjList;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[V+1];
		
		for (int i=0;i<V+1;i++) adjList[i] = new ArrayList<int[]>();
		
		int start = Integer.parseInt(br.readLine());
		
		for (int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adjList[u].add(new int[] {v,w});
		}

		int[] distance = dijkstra(start);
		
		StringBuilder sb = new StringBuilder();
		
		for (int i=1;i<V+1;i++) {
			if (distance[i]==Integer.MAX_VALUE) sb.append("INF");
			else sb.append(distance[i]);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static int[] dijkstra(int start) {
		int[] distance = new int[V+1];
		
		Arrays.fill(distance,Integer.MAX_VALUE);
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)-> Integer.compare(o1[1], o2[1]));
		
		distance[start] = 0;
		
		pq.offer(new int[] {start,distance[start]});
		
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int node = cur[0];
			int weight = cur[1];
			
			if (distance[node]<weight) continue;
			
			for (int[] next:adjList[node]) {
				if (distance[next[0]]>distance[node]+next[1]) {
					distance[next[0]] = distance[node]+next[1];
					pq.offer(new int[] {next[0],distance[next[0]]});
				}
			}
		}
		
		return distance;
		
	}

}
