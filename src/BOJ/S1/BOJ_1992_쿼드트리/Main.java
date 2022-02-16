package BOJ.S1.BOJ_1992_����Ʈ��;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		//N*N �迭 map�� �Է� ������ ����
		for (int i=0;i<N;i++) {
			String s = br.readLine();
			for (int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
			}
		}
		
		System.out.println(quad(N,0,0));
	}
	
	static String quad(int N, int startX, int startY) {
		// ũ�Ⱑ 1�̸� �ش� ��ǥ�� ���� �״�� ��Ʈ������ ��ȯ�Ͽ� ��ȯ
		if (N==1) return String.valueOf(map[startX][startY]);
		
		// ũ�Ⱑ 1���� ũ�� 4�и����� ���� (xxxx) ������ ��ȯ�ϵ��� StringBuilder�� ���ڿ� ����
		StringBuilder sb = new StringBuilder();
		
		// �� 4�и��� map������ ��ġ�� ���μ��� �ε����� N/2�� ���ϸ鼭 �����ϰ�, ũ�⸦ 2�� ����
		sb.append("(")
		.append(quad(N/2,startX,startY))
		.append(quad(N/2,startX,startY+N/2))
		.append(quad(N/2,startX+N/2,startY))
		.append(quad(N/2,startX+N/2,startY+N/2))
		.append(")");
		
		String s = sb.toString();
		
		// ������ �����ϸ� ����
		if (s.equals("(1111)")) s = "1";
		else if (s.equals("(0000)")) s = "0";
		
		return s;
	}
}
