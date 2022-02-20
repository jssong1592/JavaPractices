package BOJ.G4.BOJ_1987_���ĺ�;

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
		
		
		//���� ��ġ���� dfs����
		dfs(0,0,0);
		
		System.out.println(maxResult);
		
	}
	
	static void dfs(int row, int col,int step) {
		//���� ����
		if (chars[map[row][col]]) {
			maxResult = Math.max(maxResult, step);
			return;
		}
		//4���� ���⿡ ���Ͽ� dfs Ž��
		chars[map[row][col]] = true;
		
		for (int i=0;i<4;i++) {
			int nx = row + dx[i];
			int ny = col + dy[i];
			// �� ��ġ�� �迭 ������ �ְ�, �湮�� ����� ����, �ѹ��� ���� ���� ���ĺ��� ��
			if (nx>=0&&nx<R&&ny>=0&&ny<C) {
				dfs(nx,ny,step+1);
				

			}
		}
		//�ٸ� ��η� �������� �� ���� �����ϵ��� �湮 ��� ����
		chars[map[row][col]] = false;
		
	}

}
