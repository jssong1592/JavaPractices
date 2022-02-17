package BOJ.G2.BOJ_3109_빵집;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static char[][] map;
	static int result = 0;
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for (int i=0;i<R;i++) {
			String line = br.readLine();
			for (int j=0;j<C;j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		//각 행의 첫 열에서 파이프 놓기 실행 
		for (int i=0;i<R;i++) {
			flag = false;
			putPipe(i,0);
		}
		
		System.out.println(result);
	}
	
	static void putPipe(int row, int col) {
		//끝에 도달해서 돌아가는 과정이라면 그대로 리턴
		if (flag) return;
		
		if (row>=0&&row<R) {
			//빌딩이 있거나, 다른 파이프가 이미 놓여져 있으면 돌아가기
			if (map[row][col]!='.') return;
			
			//파이프를 놓을 수 있다면 현재 자리에 파이프 놓기
			map[row][col] = 'P';
			
			//파이프가 끝열에 도달하면 결과에 1을 더하고, 재귀로 돌아갈 때 아무것도 안하고 돌아가도록 플래그 세우기
			if (col >= C-1) {
				result++;
				
				flag = true;
				return;
			}
			
			//다음 열로 이동
			//오른쪽 위로 이동
			putPipe(row-1,col+1);
			//오른쪽으로
			putPipe(row,col+1);
			//오른쪽 아래로
			putPipe(row+1,col+1);
			
		
		}
		
	}

}
