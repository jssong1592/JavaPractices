package BOJ.S1.BOJ_9205_맥주마시면서걸어가기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Point> pointList;
	static boolean flag;
	static boolean[] visited;
	
	static class Point {
		int x, y;
		public Point (int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		
		
		for (int tc=0;tc<T;tc++) {
			pointList = new ArrayList<>();
			int n = Integer.parseInt(br.readLine());
			visited = new boolean[n+2];
			flag = false;
			
			for (int i=0;i<n+2;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				pointList.add(new Point(x,y));
			}
			
			Queue<Point> q = new LinkedList<>();
			q.offer(pointList.get(0));
			visited[0] = true;
			
			while (!q.isEmpty()) {
				Point curPoint = q.poll();
				int x = curPoint.x;
				int y = curPoint.y;
				
				for (int i=0;i<n+2;i++) {
					Point nextPoint = pointList.get(i);
					if (Math.abs(x-nextPoint.x)+Math.abs(y-nextPoint.y)<=1000&&!visited[i]) {
						visited[i] = true;
						if (i==n+1) {
							flag = true;
							q.clear();
							break;
						}
						q.offer(pointList.get(i));
					}
				}
				
			}
			
			if (flag) System.out.println("happy");
			else System.out.println("sad");
			
		}

	}

}
