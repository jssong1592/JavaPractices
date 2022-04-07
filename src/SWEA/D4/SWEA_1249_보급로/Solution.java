package SWEA.D4.SWEA_1249_보급로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	
	static class Point implements Comparable<Point> {
		int x,y,weight;
		public Point (int x,int y,int weight) {
			this.x=x;
			this.y=y;
			this.weight=weight;
		}
		
		@Override
		public int compareTo(Point o) {
			
			return Integer.compare(this.weight, o.weight);
		}
	}
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			int[][] dist = new int[N][N];
			
			for (int i=0;i<N;i++) {
				String line = br.readLine();
				Arrays.fill(dist[i], Integer.MAX_VALUE);
				for (int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(line.substring(j, j+1));
				}
			}
			
			PriorityQueue<Point> pq = new PriorityQueue<>();
			
			dist[0][0] = 0;
			pq.offer(new Point(0,0,0));
			
			while (!pq.isEmpty()) {
				Point curPoint = pq.poll();
				int x = curPoint.x;
				int y = curPoint.y;
				int weight = curPoint.weight;
				
				if (dist[x][y]<weight) continue;
				
				for (int i=0;i<4;i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if (nx>=0&&nx<N&&ny>=0&&ny<N) {
						if (dist[nx][ny] > weight + map[nx][ny]) {
							dist[nx][ny] = weight + map[nx][ny];
							pq.offer(new Point(nx,ny,dist[nx][ny]));
						}
					}
				}
			}
			
			System.out.printf("#%d %d\n",tc,dist[N-1][N-1]);
			
			
		}

	}

}
