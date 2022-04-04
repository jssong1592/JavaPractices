package BOJ.G4.BOJ_4485_≥Ïªˆø ¿‘¿∫æ÷∞°¡©¥Ÿ¡ˆ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = "";
		int cnt = 0;
		while (!(line=br.readLine()).equals("0")) {
			int N = Integer.parseInt(line);
			int [][] map = new int[N][N];
			int [][] result = new int[N][N];
			
			for (int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					result[i][j] = Integer.MAX_VALUE;
				}
				
			}
			
			PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1[2], o2[2]));
			
			result[0][0] = map[0][0];
			
			pq.offer(new int[] {0,0,result[0][0]});
			
			int[] dx = {-1,1,0,0};
			int[] dy = {0,0,-1,1};
			
			while (!pq.isEmpty()) {
				int[] cur = pq.poll();
				int x = cur[0];
				int y = cur[1];
				int dist = cur[2];
				
				if (result[x][y]<dist) continue;
				
				for (int i=0;i<4;i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];

					if (nx>=0&&nx<N&&ny>=0&&ny<N) {
						if (map[nx][ny] + dist < result[nx][ny]) {
							result[nx][ny] = map[nx][ny] + dist;
//							for (int l=0;l<N;l++) {
//								System.out.println(Arrays.toString(result[l]));								
//							}
//							System.out.println();
							pq.offer(new int[] {nx,ny,map[nx][ny]+dist});
						}
					}
				}
			}
			
//			System.out.println(Arrays.deepToString(result));
			
			System.out.printf("Problem %d: %d\n",++cnt,result[N-1][N-1]);
		}

	}

}
