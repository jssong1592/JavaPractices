package BOJ.G4.BOJ_11657_타임머신;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static Edge[] edgeList;
	
	static class Edge {
		int from, to, weight;
		
		public Edge(int from,int to, int weight) {
			
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		edgeList = new Edge[M];
		
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(from,to,weight);
		}
		
		//벨만 포드 알고리즘 사용 -> ***모든 노드에 대해 모든 간선 확인(O(VE))
		long[] result = new long[N+1];
		Arrays.fill(result,Integer.MAX_VALUE);
		result[1] = 0;
		boolean flag = true;
		// 시작은 1번 노드
		for (int i=1;i<N+1;i++) {
			for (int j=0;j<M;j++) {
				int from = edgeList[j].from;
				int to = edgeList[j].to;
				int weight = edgeList[j].weight;
				
				if (result[from]!=Integer.MAX_VALUE && result[to]>result[from]+weight) {
					result[to] = result[from] + weight;
					
					if (i==N) flag = false;
				}
			}
		}
		
		
		
		StringBuilder sb = new StringBuilder();
		
		if (!flag) sb = new StringBuilder("-1\n");
		else {
			for (int i=2;i<N+1;i++) {

				if (result[i]==Integer.MAX_VALUE) {
					sb.append("-1\n");
				} else {
					sb.append(result[i]+"\n");
				}
			}
		}
		
		
		
		System.out.println(sb);
		
	}

}
