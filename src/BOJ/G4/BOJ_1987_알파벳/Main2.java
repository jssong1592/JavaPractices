package BOJ.G4.BOJ_1987_알파벳;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	static int R, C, maxResult;
	static char[][] map;
	static boolean[] chars = new boolean[100];
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for (int i=0;i<R;i++) {
			String line = br.readLine();
			for (int j=0;j<C;j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		
		//시작 위치에서 dfs시작
		dfs(0,0,0);
		
		System.out.println(maxResult);
		
	}
	
	static void dfs(int row, int col,int step) {
		//종료 조건
		if (chars[map[row][col]]) {
			maxResult = Math.max(maxResult, step);
			return;
		}
		//4가지 방향에 대하여 dfs 탐색
		chars[map[row][col]] = true;
		
		for (int i=0;i<4;i++) {
			int nx = row + dx[i];
			int ny = col + dy[i];
			// 갈 위치가 배열 범위에 있고, 방문한 기록이 없고, 한번도 밟지 않은 알파벳일 때
			if (nx>=0&&nx<R&&ny>=0&&ny<C) {
				dfs(nx,ny,step+1);
				

			}
		}
		//다른 경로로 접근했을 때 접근 가능하도록 방문 기록 해제
		chars[map[row][col]] = false;
		
	}

}
