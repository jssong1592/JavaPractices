package BOJ.G5.BOJ_7576_토마토;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] matrix = new int[N][M];
		
		Queue<int[]> queue = new LinkedList<>();
		
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<M;j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
				if (matrix[i][j]==1) {
					queue.offer(new int[]{i,j});
					
				}
			}
		}
		
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int x = cur[0];
			int y = cur[1];
			
			for (int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx>=0&&nx<N&&ny>=0&&ny<M&&matrix[nx][ny]==0) {
					
					matrix[nx][ny] = matrix[x][y]+1;
					queue.offer(new int[] {nx,ny});
				}
			}
		}
		
		int maxDay = -1;
		boolean flag = true;
		
		for (int i=0;i<N;i++) {
			if (!flag) break;
			for (int j=0;j<M;j++) {
				if (matrix[i][j]==0) {
					flag = false;
					break;
				} else if (matrix[i][j]>maxDay) {
					maxDay = matrix[i][j];
				}
			}
		}
		
		if (!flag) System.out.println(-1);
		else System.out.println(maxDay-1);
	}

}
