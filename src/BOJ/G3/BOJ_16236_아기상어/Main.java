package BOJ.G3.BOJ_16236_아기상어;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		//공간 정보 저장, 상어 상태 초기화
		map = new int[N][N];
		int startX = -1, startY = -1;
		int size = 2;
		
		for (int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					startX = i;
					startY = j;
				}
			}
		}
		
		//bfs를 통해 먹을 수 있는 물고기 후보 탐색
		int time = 0;
		int eatCnt = size;
		while (true) {
			PriorityQueue<Fish> fishList = bfs(startX,startY,size);
			//먹을 수 있는 물고기가 없으면 반복문 끝
			if (fishList.isEmpty()) break;
			else {
				Fish fish = fishList.poll();
				//이동까지 걸린 시간을 더하고, 상어 위치 갱신
				time += fish.distance;
				map[startX][startY] = 0;
				map[fish.x][fish.y] = 9;
				
				startX = fish.x;
				startY = fish.y;
				
				//물고기를 먹고, 성장할 수 있으면 성장
				eatCnt--;
				if (eatCnt==0) {
					size++;
					eatCnt = size;
				}
				
			}
		}
		
		System.out.println(time);

	}
	
	static class Fish implements Comparable<Fish> {
		int x,y,distance,size;
		
		public Fish(int x, int y,int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}

		@Override
		public int compareTo(Fish o) {
			if (this.distance != o.distance) return this.distance - o.distance;
			else if (this.x != o.x) return this.x - o.x;
			else return this.y - o.y;
		}
		
	}
	
	static PriorityQueue<Fish> bfs(int startX, int startY, int size) {
		boolean[][] visited = new boolean[N][N];
		int[][] dist = new int[N][N];
		
		
		Queue<int[]> queue = new LinkedList<>();
		PriorityQueue<Fish> fishList = new PriorityQueue<>();
		
		visited[startX][startY] = true;
		queue.offer(new int[] {startX,startY});
		
		//bfs
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			
			
			//탐색한 위치에 물고기가 있고, 상어 사이즈보다 작은 사이즈라면 우선 순위 큐에 후보로 넣기 
			if (map[now[0]][now[1]]>0&&map[now[0]][now[1]]<9&&map[now[0]][now[1]]<size) {
				fishList.offer(new Fish(now[0],now[1],dist[now[0]][now[1]]));
			}
			
			for (int i=0;i<4;i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				
				//범위를 벗어나거나, 방문한 곳이거나, 상어 사이즈보다 물고기 사이즈가 크면 스킵
				if (nx<0||nx>=N||ny<0||ny>=N||visited[nx][ny]||map[nx][ny]>size) continue;
				visited[nx][ny] = true;
				queue.offer(new int[] {nx,ny});
				dist[nx][ny] = dist[now[0]][now[1]] + 1;
			}
		}
		
//		for (Fish fish:fishList) {
//			System.out.println("x:"+fish.x+" y:"+fish.y+" dist:"+fish.distance+" size:"+fish.size);
//		}
//		System.out.println();
		
		//bfs가 끝나면 물고기 후보 리턴
		return fishList;
	}
}
