package SWEA.D4.SWEA_1251_하나로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static int[] xList;
	static int[] yList;
	static int[] parent;
	static double E;
	
	static class Tunnel implements Comparable<Tunnel> {
		int from, to; 
		long distance;
		
		public Tunnel(int from, int to) {
			
			this.from = from;
			this.to = to;
			this.distance = (long) Math.pow(xList[from]-xList[to],2) + (long) Math.pow(yList[from]-yList[to],2);
		}
		
		@Override
		public int compareTo(Tunnel o) {
			if (this.distance<=o.distance) return -1;
			else return 1;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			
			xList = new int[N];
			yList = new int[N];
			PriorityQueue<Tunnel> pq = new PriorityQueue<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i=0;i<N;i++) {
				xList[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i=0;i<N;i++) {
				yList[i] = Integer.parseInt(st.nextToken());
			}
			
			E = Double.parseDouble(br.readLine());
			
			//섬 조합에 따라 터널 객체 만들어서 거리 적은 순서대로 들어가도록 우선순위 큐에 삽입
			for (int i=0;i<N-1;i++) {
				for (int j=i+1;j<N;j++) {
					pq.offer(new Tunnel(i,j));
				}
			}
			
			//크루스칼 알고리즘 사용
			parent = new int[N+1];
			for (int i=0;i<N+1;i++) {
				parent[i] = i;
			}
			
			int cnt = 0;
			double cost = 0;
			while (true) {
				Tunnel t = pq.poll();
				if (union(t.from,t.to)) {
					cost += t.distance;
					cnt++;
					if (cnt==N-1) break;
				}
			}
			
			System.out.printf("#%d %.0f\n",tc,cost*E);
		}

	}
	
	static boolean union(int a,int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot==bRoot) return false;
		else parent[bRoot] = aRoot;
		return true;
	}
	
	static int findSet(int a) {
		if (parent[a]==a) return a;
		parent[a] = findSet(parent[a]);
		return parent[a];
	}

}
