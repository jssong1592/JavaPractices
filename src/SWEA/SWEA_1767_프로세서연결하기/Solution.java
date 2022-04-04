package SWEA.SWEA_1767_프로세서연결하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[][] map;
	static int maxCore;
	static int minLength;
	static ArrayList<Point> pointList;
	
	//이동용
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static class Point {
		int x,y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc=1;tc<=T;tc++) {
			//데이터 받아오기
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			pointList = new ArrayList<Point>();
			
			for (int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j]==1) {
						pointList.add(new Point(i,j));
					}
				}
			}
			
			maxCore = 0;
			minLength = Integer.MAX_VALUE;
			
			dfs(0,0,0);
			
			if (minLength==Integer.MAX_VALUE) minLength = 0;
			System.out.printf("#%d %d\n",tc,minLength);
			
		}
		
	}
	
	static void dfs(int no, int connectedCore, int totalLength) {
		if (no==pointList.size()) {
			if (connectedCore > maxCore) {
				maxCore = connectedCore;
				minLength = totalLength;
			} else if (connectedCore == maxCore) {
				minLength = Math.min(minLength, totalLength);
			}
			return;
		}
		
		Point p = pointList.get(no);
		
		int x = p.x;
		int y = p.y;
		
		if (x==0||x==N-1||y==0||y==N-1) {
			dfs(no+1, connectedCore+1, totalLength);
			return;
		}
		
		dfs(no+1,connectedCore,totalLength);
		
		for (int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			boolean flag = false;
			while (nx>=0&&nx<N&&ny>=0&&ny<N) {
				if (map[nx][ny]!=0) break;
				
				if (nx==0||nx==N-1||ny==0||ny==N-1)
					flag = true;
				
				nx += dx[i];
				ny += dy[i];
			}
			
			if (flag) {
				int cnt = 0;
				nx = x + dx[i];
				ny = y + dy[i];
				while (nx>=0&&nx<N&&ny>=0&&ny<N) {
					map[nx][ny] = 2;
					cnt++;
					nx += dx[i];
					ny += dy[i];
				}
				
				dfs(no+1,connectedCore+1,totalLength+cnt);
				
				nx = x + dx[i];
				ny = y + dy[i];
				while (nx>=0&&nx<N&&ny>=0&&ny<N) {
					map[nx][ny] = 0;
					nx += dx[i];
					ny += dy[i];
				}
			}
		}
	}
}
