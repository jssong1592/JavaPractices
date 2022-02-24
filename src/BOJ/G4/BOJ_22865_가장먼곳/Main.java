package BOJ.G4.BOJ_22865_가장먼곳;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Pair>[] adjList;
	static int N;
	static int[] friends;
	
	static class Pair implements Comparable<Pair> {
		int node, distance;
		
		public Pair(int node, int distance) {
			this.node = node;
			this.distance = distance;
		}
		
		@Override
		public int compareTo(Pair o) {
			if (this.distance == o.distance) return this.node - o.node;
			return this.distance-o.distance;
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		friends = new int[] {A,B,C};
		
		adjList = new ArrayList[N+1];
		for (int i=0;i<N+1;i++) adjList[i] = new ArrayList<Pair>();
		
		int M = Integer.parseInt(br.readLine());
		
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			adjList[from].add(new Pair(to,dist));
			adjList[to].add(new Pair(from,dist));
		}
		
		
		// 각 친구에 대하여 1~N번 땅까지 총 3번 다익스트라를 돌려서 땅마다 최소값 갱신 
		int[] result = new int[N+1];
		Arrays.fill(result, Integer.MAX_VALUE);
		for (int i=0;i<3;i++) {
			int[] distance = dijkstra(friends[i]);
//			System.out.println(Arrays.toString(distance));
			for (int j=1;j<N+1;j++) {
				result[j] = Math.min(result[j], distance[j]);
			}
		}
		
//		System.out.println(Arrays.toString(result));
		
		// 최소값으로 갱신된 땅들 중에서 최대값을 가진 땅을 탐색 -> 가장 먼 땅
		int maxDist = -1;
		int maxIdx = N+1;
		for (int i=1;i<N+1;i++) {
			if (maxDist<result[i]) {
				maxIdx = i;
				maxDist = result[i];
			}
		}
		
		System.out.println(maxIdx);
	}
	
	static int[] dijkstra(int start) {
		int[] distance = new int[N+1];
		Arrays.fill(distance, 1_000_000_000);
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		
		distance[start] = 0;
		pq.offer(new Pair(start,0));
		while (!pq.isEmpty()) {
			Pair curNode = pq.poll();
			// curNode의 distance는 시작 노드로부터의 거리가 누적된 상태
			// curNode의 최단거리가 이미 갱신되어 있다면 컨티뉴
			if (distance[curNode.node]<curNode.distance) continue;
			
			// 갱신할 수 있다면, curNode에 인접한 nextNode들에 대하여 curNode를 거쳐 nextNode로 가는 경로를 갱신할 수 있는지 판별
			// nextNode의 최단거리가 갱신되면, 우선순위 큐에 해당 노드와 누적된 거리 정보를 담아 offer
			for (Pair nextNode:adjList[curNode.node]) {
				if (distance[nextNode.node]>distance[curNode.node]+nextNode.distance) {
					distance[nextNode.node] = distance[curNode.node]+nextNode.distance;
					pq.offer(new Pair(nextNode.node,distance[nextNode.node]));
				}
			}
			
		}
		
		
		return distance;
	}

}
