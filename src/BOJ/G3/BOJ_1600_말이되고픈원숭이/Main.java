package BOJ.G3.BOJ_1600_���̵ǰ��¿�����;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int[][][] visited;
	static int w,h;
	
	static class Point {
		int x,y,k;
		
		public Point(int x,int y, int k) {
			this.x = x;
			this.y = y;
			this.k = k;	
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		map = new int[h][w];
		//k�� �������� �����ϴ� k�� ������ �湮�� �ɸ� Ƚ���� ���� ����
		visited = new int[h][w][k+1];
		
		for (int i=0;i<h;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<w;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		System.out.println(Arrays.deepToString(map));
		
		int ans = bfs(k);
		
		
		System.out.println(ans);

		
	}

	static boolean isIn(int nx, int ny) {
		if (nx>=0&&nx<h&&ny>=0&&ny<w) {
			return true;
		}
		return false;
	}
	
	static int bfs(int k) {
		Queue<Point> q = new LinkedList<>();
		int[] monkeyDx = {-1,1,0,0};
		int[] monkeyDy = {0,0,-1,1};
		
		int[] horseDx = {-2,-2,-1,-1,1,1,2,2};
		int[] horseDy = {-1,1,-2,2,-2,2,-1,1};
		
		q.offer(new Point(0,0,k));
		visited[0][0][k] = 0;
		while (!q.isEmpty()) {
			
			
			Point cur = q.poll();
			if (cur.x==h-1&&cur.y==w-1) {
				return visited[cur.x][cur.y][cur.k];
			}
			
			//�� ������ ������ ��� k ����
			for (int i=0;i<4;i++) {
				
				int nx = cur.x + monkeyDx[i];
				int ny = cur.y + monkeyDy[i];
				
				if (isIn(nx,ny)&&map[nx][ny]==0&&visited[nx][ny][cur.k]==0) {
					q.offer(new Point(nx,ny,(cur.k)));
					visited[nx][ny][cur.k] = visited[cur.x][cur.y][cur.k] + 1;
				}
			}
			
			//������ ������ ���
			if (cur.k>0) {
				for (int i=0;i<8;i++) {
					int nx = cur.x + horseDx[i];
					int ny = cur.y + horseDy[i];
					
					//������ ������ �湮Ƚ�� ����
					if (isIn(nx,ny)&&map[nx][ny]==0&&visited[nx][ny][cur.k-1]==0) {
						//���� ����ϱ� ���� k����
						q.offer(new Point(nx,ny,(cur.k)-1));
						visited[nx][ny][cur.k-1] = visited[cur.x][cur.y][cur.k] + 1;
					}
				}
			}
		}
		
		
		
		return -1;
	}
}
