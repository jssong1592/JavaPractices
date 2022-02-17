package BOJ.G4.BOJ_1987_알파벳;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int R, C, maxResult;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static HashSet<Character> chars;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		
		for (int i=0;i<R;i++) {
			String line = br.readLine();
			for (int j=0;j<C;j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		//밟았던 알파벳을 기록할 셋
		chars = new HashSet<>();
		
		//시작할 위치 설정
		chars.add(map[0][0]);
		visited[0][0] = true;
		
		//시작 위치에서 dfs시작
		dfs(0,0,1);
		
		System.out.println(maxResult);
		
	}
	
	static void dfs(int row, int col,int step) {
		//4가지 방향에 대하여 dfs 탐색
		for (int i=0;i<4;i++) {
			int nx = row + dx[i];
			int ny = col + dy[i];
			// 갈 위치가 배열 범위에 있고, 방문한 기록이 없고, 한번도 밟지 않은 알파벳일 때
			if (nx>=0&&nx<R&&ny>=0&&ny<C&&!visited[nx][ny]&&!chars.contains(map[nx][ny])) {
				// 가야할 위치의 알파벳을 셋에 추가하고, 방문 기록
				chars.add(map[nx][ny]);
				visited[nx][ny] = true;
				
				//스텝 1개 더하고, 가야할 위치로 이동하여 dfs 반복
				dfs(nx,ny,step+1);
				
				//가야할 위치에서의 탐색이 끝나면 그 위치의 방문기록 초기화
				chars.remove(map[nx][ny]);
				visited[nx][ny] = false;

			}
		}
		
		//재귀 끝나고 돌아가기 시작할 때(갈 수 있는 만큼 갔을 때) 지나온 칸 수 확인
		if (step>maxResult) {
			maxResult = step;
		}
		
	}

}
