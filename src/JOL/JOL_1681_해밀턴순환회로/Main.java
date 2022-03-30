package JOL.JOL_1681_해밀턴순환회로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] adjMatrix;
	static int minResult;
	static int start;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		
		adjMatrix = new int[N][N];
		
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j=0;j<N;j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		start = 0;
		minResult = Integer.MAX_VALUE;
		
		boolean[] visited = new boolean[N];
		visited[0] = true;
		
		findRoute(0,0,0,visited);
		
		System.out.println(minResult);
	}
	
	static void findRoute(int node, int cnt, int sum, boolean[] visited) {
		if (cnt==N-1) {
			if (adjMatrix[node][start]>0) {
				minResult = Math.min(minResult, sum+adjMatrix[node][start]);
			}
			return;
		}
		
		if (sum>minResult) return;
		
		for (int i=0;i<N;i++) {
			if (i!=start&&adjMatrix[node][i]>0&&!visited[i]) {
				visited[i] = true;
				findRoute(i,cnt+1,sum+adjMatrix[node][i],visited);
				visited[i] = false;
			}
		}
	}

}


