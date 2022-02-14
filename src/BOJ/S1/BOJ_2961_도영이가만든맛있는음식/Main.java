package BOJ.S1.BOJ_2961_�����̰�������ִ�����;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] food = new int[N][];
		
		for (int i=0;i<N;i++) { // ��� ���� ����
			StringTokenizer st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			food[i] = new int[] {S,B};
		}
		
		int result = Integer.MAX_VALUE;
		
		//��� ������ ��� �κ����տ� ���Ͽ� Ž���ϱ�
		for (int i=1;i<(1<<N);i++) { //��Ʈ����ŷ���� �κ����� �Ǻ��ϱ�(������ ���ܴϱ� 0 ���� 1����)
			int sour = 1;
			int bitter = 0;
			for (int j=0;j<N;j++) { //i�� 0~N-1��° ��Ʈ�� �����ִ��� 1�� j��ŭ ��Ʈ����Ʈ�ϸ鼭 �Ǻ� 
				if (((1<<j)&i)!=0) { //0�� �ȳ����� ��Ʈ�� ��������. ���� ���õ� �ε��� ����Ͽ� ����
					sour *= food[j][0];
					bitter += food[j][1];
					
				}
			}
			result = Math.min(result, Math.abs(sour-bitter));
		}
		
		System.out.println(result);
		
	}

}
