package BOJ.G4.BOJ_17135_캐슬디펜스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,D, maxTotal;
	static int[][] map;
	static Point[] archerPos;
	static ArrayList<Enemy> enemyList;
	
	static class Point {
		int x,y;
		
		public Point(int x,int y) {
			this.x=x;
			this.y=y;
		}
	}
	
	static class Enemy extends Point {
		int distance;
		boolean isInMap, isOut;
		
		public Enemy(int x, int y) {
			super(x, y);
			distance = 0;
			isInMap = true;
			isOut = false;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		enemyList = new ArrayList<>();
		archerPos = new Point[3];
		maxTotal = 0;
		map = new int[N][M];
		
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j]==1) enemyList.add(new Enemy(i,j));
			}
		}
		
		combination(0,0);
		
		System.out.println(maxTotal);
	}
	
	static void combination(int cnt, int start) {
		if (cnt==3) {
			
			process();
			return;
		}
		
		for (int i=start;i<M;i++) {
			archerPos[cnt] = new Point(N,i);
			combination(cnt+1,i+1);
		}
	}

	static void process() {
		int enemyLeft = enemyList.size();
		ArrayList<Enemy> newList = new ArrayList<>();
		for (Enemy e:enemyList) {
			newList.add(new Enemy(e.x,e.y));
		}
		boolean flag = true;
		while (flag) {
			//타겟 지정하여 활쏘기
			ArrayList<Enemy> hitList = new ArrayList<>();
			for (Point archer:archerPos) {
				
				PriorityQueue<Enemy> pq = new PriorityQueue<>((o1,o2)->{
					if (o1.distance==o2.distance) {
						return o1.y-o2.y;
					} 
					return o1.distance-o2.distance;
				}); 
				
				for (Enemy e:newList) {
					e.distance = Math.abs(archer.x-e.x) + Math.abs(archer.y-e.y);
					if (e.distance <= D&&e.isInMap) {
						pq.offer(e);
					}
				}
				
				if (!pq.isEmpty()) {
					Enemy target = pq.poll();
					hitList.add(target);
				}
			}
			
			for (Enemy hit:hitList) {
				for (Enemy e:newList) {
					if (hit.x==e.x&&hit.y==e.y) {
						if (e.isInMap) enemyLeft--;
						e.isInMap = false;
					}
				}
			}
			
			
			//아래로 한칸씩 이동, 맵 범위를 벗어나면 제외처리
			flag = false;
			for (Enemy e:newList) {
				e.x = e.x + 1;
				if (e.x>=N) {
					e.isInMap = false;
				}
				if (e.isInMap) flag = true;
			}
			
			if (enemyLeft==0) flag = false;
			
//			System.out.println();
		}
		
		int total = enemyList.size() - enemyLeft;
//		System.out.println(total);
		maxTotal = Math.max(maxTotal, total);
		
	}
}
