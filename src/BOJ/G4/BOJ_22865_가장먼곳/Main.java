package BOJ.G4.BOJ_22865_가장먼곳;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<int[]>[] adjList;
	static int N;
	static int[] friends;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		friends = new int[] {A,B,C};
		
		adjList = new ArrayList[N+1];
		for (int i=0;i<N+1;i++) adjList[i] = new ArrayList<int[]>();
		
		int M = Integer.parseInt(br.readLine());
		
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			adjList[from].add(new int[] {to,dist});
			adjList[to].add(new int[] {from,dist});
		}
		
		
		int maxDist = -1;
		int maxIdx = N+1;
		for (int i=0;i<3;i++) {
			int curDist = dijkstra(friends[i]);
			if (curDist>maxDist) {
				maxDist = curDist;
				maxIdx = i;
			}
		}
		
		System.out.println(maxIdx);
	}
	
	static int dijkstra(int start) {
		boolean[] visited = new boolean[N+1];
		int[] distance = new int[N+1];
		Arrays.fill(distance, 1_000_000_001);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int minIdx  = -1;
		int minDist = Integer.MAX_VALUE;
		
		visited[start] = true;
		distance[start] = 0;
		pq.offer(start);
		while (!pq.isEmpty()) {
			int node = pq.poll();
			
			for (int[] next:adjList[node]) {
				if (!visited[next[0]]&&distance[next[0]]>distance[node]+next[1]) {
					visited[next[0]] = true;
					distance[next[0]] = distance[node]+next[1];
					if (distance[next[0]]<minDist) {
						//
					}
					pq.offer(next[0]);
				}
				
			}
		}
		
		
		return minDist;
	}

}
