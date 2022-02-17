package BOJ.G4.BOJ_1987_���ĺ�;

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
		
		//��Ҵ� ���ĺ��� ����� ��
		chars = new HashSet<>();
		
		//������ ��ġ ����
		chars.add(map[0][0]);
		visited[0][0] = true;
		
		//���� ��ġ���� dfs����
		dfs(0,0,1);
		
		System.out.println(maxResult);
		
	}
	
	static void dfs(int row, int col,int step) {
		//4���� ���⿡ ���Ͽ� dfs Ž��
		for (int i=0;i<4;i++) {
			int nx = row + dx[i];
			int ny = col + dy[i];
			// �� ��ġ�� �迭 ������ �ְ�, �湮�� ����� ����, �ѹ��� ���� ���� ���ĺ��� ��
			if (nx>=0&&nx<R&&ny>=0&&ny<C&&!visited[nx][ny]&&!chars.contains(map[nx][ny])) {
				// ������ ��ġ�� ���ĺ��� �¿� �߰��ϰ�, �湮 ���
				chars.add(map[nx][ny]);
				visited[nx][ny] = true;
				
				//���� 1�� ���ϰ�, ������ ��ġ�� �̵��Ͽ� dfs �ݺ�
				dfs(nx,ny,step+1);
				
				//������ ��ġ������ Ž���� ������ �� ��ġ�� �湮��� �ʱ�ȭ
				chars.remove(map[nx][ny]);
				visited[nx][ny] = false;

			}
		}
		
		//��� ������ ���ư��� ������ ��(�� �� �ִ� ��ŭ ���� ��) ������ ĭ �� Ȯ��
		if (step>maxResult) {
			maxResult = step;
		}
		
	}

}
