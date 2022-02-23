package BOJ.G4.BOJ_11404_플로이드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[][] adjMatrix = new int[n+1][n+1];
		for (int i=1;i<n+1;i++) {
			for (int j=1;j<n+1;j++) {
				if (i==j) adjMatrix[i][j] = 0;
				else adjMatrix[i][j] = 1000000000;
			}
		}
		
		for (int i=0;i<m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			adjMatrix[a][b] = Math.min(adjMatrix[a][b],c);
			
		}
		
		//모든 노드에 대하여, 노드 a,b를 잇는 기존 경로가 한 노드 k를 거쳐서 가는 경로보다 짧은지 확인-> dist[a][b] = min(dist[a][b], dist[a][k]+dist[k][b])
		for (int k=1;k<n+1;k++) {
			for (int a=1;a<n+1;a++) {
				for (int b=1;b<n+1;b++) {
					adjMatrix[a][b] = Math.min(adjMatrix[a][b], adjMatrix[a][k]+adjMatrix[k][b]);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i=1;i<n+1;i++) {
			for (int j=1;j<n+1;j++) {
				if (adjMatrix[i][j]>=1000000000) sb.append(0);
				else sb.append(adjMatrix[i][j]);
				
				sb.append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
