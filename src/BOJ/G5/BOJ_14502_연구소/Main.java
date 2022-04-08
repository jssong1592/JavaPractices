package BOJ.G5.BOJ_14502_연구소;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int N,M;
	static ArrayList<Point> candidate;
	static ArrayList<Point> virusList;
	static Point[] arr;
	static int maxSafe;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static class Point {
		int x,y;
		public Point (int x,int y) {
			this.x=x;
			this.y=y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		candidate = new ArrayList<>();
		virusList = new ArrayList<>();
		arr = new Point[3];
		maxSafe = 0;
		
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j]==0) candidate.add(new Point(i,j));
				else if (map[i][j]==2) virusList.add(new Point(i,j));
			}
		}
		
		combination(0,0);
		
		System.out.println(maxSafe-3);
	}
	
	static void combination(int cnt, int start) {
		if (cnt==3) {
			process();
			return;
		}
		for (int i=start;i<candidate.size();i++) {
			arr[cnt] = candidate.get(i);
			combination(cnt+1,i+1);
		}
	}
	
	static void process() {
		int safe = candidate.size();
		for (Point p:arr) {
			map[p.x][p.y] = 1;
		}
		boolean[][] visited = new boolean[N][M];
		Queue<Point> q = new LinkedList<>();
		
		for (Point v:virusList) {
			visited[v.x][v.y] = true;
			q.offer(v);
		}
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			int x = p.x;
			int y = p.y;
			
			for (int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx>=0&&nx<N&&ny>=0&&ny<M && !visited[nx][ny] && map[nx][ny]==0) {
					visited[nx][ny] = true;
					safe--;
					q.offer(new Point(nx,ny));
				}
			}
		}
		
		maxSafe = Math.max(maxSafe, safe);
		
		for (Point p:arr) {
			map[p.x][p.y] = 0;
		}
	}

}
