package BOJ.G2.BOJ_3109_����;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
		
		//�� ���� ù ������ ������ ���� ���� 
		for (int i=0;i<R;i++) {
			flag = false;
			putPipe(i,0);
		}
		
		System.out.println(result);
	}
	
	static void putPipe(int row, int col) {
		//���� �����ؼ� ���ư��� �����̶�� �״�� ����
		if (flag) return;
		
		if (row>=0&&row<R) {
			//������ �ְų�, �ٸ� �������� �̹� ������ ������ ���ư���
			if (map[row][col]!='.') return;
			
			//�������� ���� �� �ִٸ� ���� �ڸ��� ������ ����
			map[row][col] = 'P';
			
			//�������� ������ �����ϸ� ����� 1�� ���ϰ�, ��ͷ� ���ư� �� �ƹ��͵� ���ϰ� ���ư����� �÷��� �����
			if (col >= C-1) {
				result++;
				
				flag = true;
				return;
			}
			
			//���� ���� �̵�
			//������ ���� �̵�
			putPipe(row-1,col+1);
			//����������
			putPipe(row,col+1);
			//������ �Ʒ���
			putPipe(row+1,col+1);
			
		
		}
		
	}

}
