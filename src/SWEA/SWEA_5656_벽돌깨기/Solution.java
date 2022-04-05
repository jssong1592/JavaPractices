package SWEA.SWEA_5656_벽돌깨기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, W, H, minBrick;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static class Brick {
		int x,y,range;
		
		public Brick(int x, int y, int range) {
			this.x = x;
			this.y = y;
			this.range = range;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[H][W];
			for (int i=0;i<H;i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0;j<W;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			minBrick = Integer.MAX_VALUE;
			
			for (int i=0;i<W;i++) {
				dfs(i,map,1);
			}
			
			System.out.printf("#%d %d\n",tc,minBrick);
		}

	}
	
	static void dfs(int col, int[][] map, int ball) {
		if (ball>N) {
			int brick = 0;
			for (int i=0;i<H;i++) {
				for (int j=0;j<W;j++) {
					if (map[i][j]>0) brick++;
				}
			}
			
			minBrick = Math.min(minBrick, brick);
			return;
		}
		
		//해당 컬럼에 구슬 떨어트려 map 갱신
		int[][] newMap = dropBall(col, map);
		

		//다음 컬럼을 골라 다음 구슬 떨어트리기
		for (int i=0;i<W;i++) {
			dfs(i,newMap,ball+1);
		}
	}
	
	static int[][] dropBall(int col, int[][] map) {
		Queue<Brick> queue = new LinkedList<>();
		
		int[][] newMap = new int[H][W];
		for (int i=0;i<H;i++) {
			for (int j=0;j<W;j++) {
				newMap[i][j] = map[i][j];
			}
		}
		
		int i = 0;
		Brick brick = null;
		//맨 윗줄부터 벽돌 찾기
		while (i<H) {
			if (newMap[i][col]>0) {
				brick = new Brick(i,col,newMap[i][col]);
				break;
			}
			i++;
		}
		
		//아무 벽돌도 못 깼다면 map 그대로 리턴
		if (brick==null) return newMap;
		//깰 벽돌 찾았다면 큐에 넣기
		queue.offer(brick);
		
		while (!queue.isEmpty()) {
			Brick b = queue.poll();
			int x = b.x;
			int y = b.y;
			int range = b.range;
			
			//해당 벽돌 포함 범위 깨서 없애기
			newMap[x][y] = 0;

			//영향받는 4방향 범위에 있는 2 이상 벽돌들을 큐에 넣어서 반응하게 하기
			
			for (int p=0;p<4;p++) {
				int nx = x + dx[p];
				int ny = y + dy[p];
				
				int cnt = 1;
				while (cnt<range) {
					
					if (nx>=0&&nx<H&&ny>=0&&ny<W) {
						
						if (newMap[nx][ny]>1) {
							
							queue.offer(new Brick(nx,ny,newMap[nx][ny]));						
						}
						//영향받은 벽돌들 없애기						
						
						newMap[nx][ny] = 0;
						
					}
					nx += dx[p];
					ny += dy[p];
					cnt++;
				}
			}
		}
		
		//반응이 다 끝나면 떠있는 벽돌들 밑으로 떨어트리기
		for (int c=0;c<W;c++) {
			for (int r=H-1;r>0;r--) {
				if (newMap[r][c]==0) {
					for (int k=r-1;k>=0;k--) {
						if (newMap[k][c]!=0) {
							newMap[r][c] = newMap[k][c];
							newMap[k][c] = 0;
							break;
						}
					}
				}
			}
		}

		return newMap;
	}
}
