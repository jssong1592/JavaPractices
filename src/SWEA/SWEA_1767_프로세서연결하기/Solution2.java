package SWEA.SWEA_1767_프로세서연결하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution2 {
	static int N;
	static int[][] map;
	static ArrayList<Core> coreList;
	static int maxCore;
	static int minLength;
	
	//순열용
	static boolean[] isSelected;
	static Core[] perm;
	
	//이동용
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static class Core {
		int x,y;
		int[] moves;
		
		public Core(int x, int y) {
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
			
			//코어 리스트 초기화
			coreList = new ArrayList<Core>();
			
			
			for (int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j]==1) {
						coreList.add(new Core(i,j));
					}
				}
			}
			
			
			perm = new Core[coreList.size()];
			isSelected = new boolean[coreList.size()];
			
			//정답 초기화
			maxCore = Integer.MIN_VALUE;
			minLength = Integer.MAX_VALUE;
			
			//코어리스트에 대해 순열을 만들어서 가장 가까운쪽을 우선으로 전선 연결하게 함
			permutation(0);
			
			//정답 표기
			System.out.printf("#%d %d\n",tc,minLength);
		}

	}
	
	static void permutation(int cnt) {
		if (cnt==coreList.size()) {
			makeConnection();
			return;
		}
		for (int i=0;i<coreList.size();i++) {
			if (!isSelected[i]) {
				perm[cnt] = coreList.get(i); 
				isSelected[i] = true;
				permutation(cnt+1);
				isSelected[i] = false;
			}
		}
	}
	
	static void makeConnection() {
		//visited 배열 초기화하고, 코어들 위치 방문처리
		visited = new boolean[N][N];
		for (Core p:coreList) {
			visited[p.x][p.y] = true;
		}
		

		int totalMove = 0;
		int totalCore = 0;
		
		for (Core p:perm) {
			int move = findRoute(p);
			//연결 가능한 곳이 없으면 -1 리턴
			//있다면 연결된 코어 + 1, 전선길이 합산
			if (move!=-1) {
				totalMove += move;
				totalCore++;
			}
		}
		
		if (totalCore > maxCore) {
			maxCore = totalCore;
			minLength = totalMove;
		} else if (totalCore == maxCore&&totalMove<minLength) {
			minLength = totalMove;
		}
	}
	
	static int findRoute(Core p) {
		int x = p.x;
		int y = p.y;
		//벽에 닿아있으면 연결 필요없으니 0 리턴
		if (x==0||x==N-1||y==0||y==N-1) return 0;
		
		// 4방향에 대하여 거리 계산
		int[] moves = new int[4];
		
		for (int i=0;i<4;i++) {
			int move = 0;
			int nx = x + dx[i];
			int ny = y + dy[i];
			while (nx>=0&&nx<N&&ny>=0&&ny<N) {
				if (visited[nx][ny]) {
					move = Integer.MAX_VALUE;
					break;
				}
				move++;
				nx += dx[i];
				ny += dy[i];
			}
			moves[i] = move;
		}
		
		//4방향 중 거리가 최소인 방향을 구하고, 그 방향으로 방문처리
		int dir = -1;
		int minMove = Integer.MAX_VALUE;
		
		for (int i=0;i<4;i++) {
			if (moves[i]<minMove) {
				dir = i;
				minMove = moves[i];
			}
		}
		
		//연결할 곳이 있다면
		if (dir>=0) {
			while (x>=0&&x<N&&y>=0&&y<N) {
				visited[x][y] = true;
				x += dx[dir];
				y += dy[dir];
			}
		}
		//연결 가능한 곳이 없으면
		else {
			minMove = -1;
		}
		
		
		
		return minMove;
	}
	
}
