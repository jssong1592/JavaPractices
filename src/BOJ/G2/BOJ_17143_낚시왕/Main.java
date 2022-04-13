package BOJ.G2.BOJ_17143_낚시왕;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int R,C,M,total;
	static int[][] map;
	static HashMap<Integer,Shark> sharkMap;
	//상하우좌
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	
	static class Shark {
		int x,y, speed,dir,size;
		
		public Shark(int x, int y,int speed, int dir, int size) {
			this.x=x;
			this.y=y;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}
		
		@Override
		public String toString() {
			
			return "Shark speed:"+speed+" dir:"+dir+" size:"+size;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sharkMap = new HashMap<>();
		map = new int[R][C];
		total = 0;
		
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			
			map[x-1][y-1] = size;
			sharkMap.put(size,new Shark(x-1,y-1,speed,dir-1,size));
		}
		
//		for (int i=0;i<R;i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
//		System.out.println();

		
		for (int col=0;col<C;col++) {
			//잡을 상어 위치 구하기
			for (int row=0;row<R;row++) {
				if (map[row][col]>0) {
					sharkMap.remove(map[row][col]);
					total+=map[row][col];
					map[row][col] = 0;
					break;
				}
			}
			
			
			//남은 상어들 이동시키기
			for (int no:sharkMap.keySet()) {
				moveShark(sharkMap.get(no));
			}
			
			//이동 시킨 내용 적용시키기
			map = new int[R][C];
			HashSet<Integer> killSet = new HashSet<>();
			for (int no:sharkMap.keySet()) {
				Shark s = sharkMap.get(no);
				if (map[s.x][s.y]==0) 
					map[s.x][s.y] = no;
				else {
					if (map[s.x][s.y]>s.size) {
						killSet.add(no);
						
					}
					else {
						killSet.add(map[s.x][s.y]);
						map[s.x][s.y] = no;
					}
				}
			}
			
			for (int no:killSet) {
				sharkMap.remove(no);
			}
			
//			for (int i=0;i<R;i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			System.out.println();
			
		}
		
		System.out.println(total);
	}
	
	static void moveShark(Shark s) {
		int nx = s.x;
		int ny = s.y;
		
		int stepX = s.speed;
		int stepY = s.speed;
		
		if (dx[s.dir]!=0) {
			while (stepX>0) {
				if (nx + dx[s.dir]<0||nx + dx[s.dir]>=R) {
					if (s.dir==0) s.dir = 1;
					else if (s.dir==1) s.dir = 0;
					else if (s.dir==2) s.dir = 3;
					else if (s.dir==3) s.dir = 2;
				}
				nx += dx[s.dir];
				stepX--;
			}
		}
		
		else if (dy[s.dir]!=0) {
			while (stepY>0) {
				if (ny + dy[s.dir]<0||ny + dy[s.dir]>=C) {
					if (s.dir==0) s.dir = 1;
					else if (s.dir==1) s.dir = 0;
					else if (s.dir==2) s.dir = 3;
					else if (s.dir==3) s.dir = 2;
				}
				ny += dy[s.dir];
				stepY--;
			}
		}
		
		s.x = nx;
		s.y = ny;
	}

}
