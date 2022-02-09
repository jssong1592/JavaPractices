package BOJ.G5.BOJ_2493_ž;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		Stack<int[]> stack = new Stack<>();
		for (int i=0;i<N;i++) {
			int T = Integer.parseInt(st.nextToken());
			
			if(stack.isEmpty()) sb.append("0 ");
			
			else {
				while(!stack.isEmpty()&&stack.peek()[1]<T) //������ ��ų�, ���� ž ���̰� ������ �� �� �κ� ž ���̺��� ���� ������ ��� pop
					stack.pop();
				
				if (stack.isEmpty()) sb.append("0 "); // �� pop�ϰ� ������ ��������� 0
				else sb.append(stack.peek()[0]+" "); // ������ �� ���������(��ȣ�� ���� ž�� ������ �� �� �κп� ����) ž�� ��ȣ ���
			}
			
			stack.push(new int[] {i+1,T}); // �ڱ� �ڽ��� push
		}
		System.out.println(sb);
	}

}
