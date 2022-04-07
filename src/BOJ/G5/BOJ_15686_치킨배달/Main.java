package BOJ.G5.BOJ_15686_치킨배달;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N,M,minTotal;
	static int[][] map;
	static boolean[] chickenSelected;
	static ArrayList<Point> allChicken;
	
	static class Point {
		int x,y;
		
		public Point(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		allChicken = new ArrayList<Point>();
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j]==2) {
					allChicken.add(new Point(i,j));
				}
			}
		}
		
		chickenSelected = new boolean[allChicken.size()];
		minTotal = Integer.MAX_VALUE;
		
		subset(0,0);
		
		System.out.println(minTotal);
		
	}
	
	static void subset(int cnt, int no) {
		if (cnt==M||no==allChicken.size()) {
			return;
		}
		
		chickenSelected[no] = true;
		calcDist();
		subset(cnt+1,no+1);
		chickenSelected[no] = false;
		subset(cnt,no+1);
		calcDist();
	}
	
	static void calcDist() {
		int[][] dist = new int[N][N];
		ArrayList<Point> chickenList = new ArrayList<>();
		for (int i=0;i<allChicken.size();i++) {
			if (chickenSelected[i]) chickenList.add(allChicken.get(i));
		}
		if (chickenList.isEmpty()) return;
		
		int totalDist = 0;
		
		for (Point p:chickenList) {
			for (int i=0;i<N;i++) {
				for (int j=0;j<N;j++) {
					if (map[i][j]==1) {
						int distance = Math.abs(p.x-i) + Math.abs(p.y-j);
						if (dist[i][j]==0) {
							dist[i][j] = distance;
							totalDist += distance;
						} else if (dist[i][j]>distance) {
							totalDist -= dist[i][j];
							dist[i][j] = distance;
							totalDist += distance;
						}
					}
				}
			}
		}
		
		minTotal = Math.min(minTotal, totalDist);
	}
	
}
