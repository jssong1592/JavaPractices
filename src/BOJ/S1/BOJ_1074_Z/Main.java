package BOJ.S1.BOJ_1074_Z;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		Stack<Integer> stack = new Stack<>(); //4�и� ���� ��ǥ ������ arrayList
		
		int length = (1<<N); //2�� N�������� ����
		
		while (length>1) {
			length = length/2;
			if (r<length) { //ã���� �ϴ� ���� ������ ���ݺ��� ������
				if (c<length) stack.push(0);
				else { //ã���� �ϴ� ���� ������ ���ݺ��� ũ��
					stack.push(1);
					c = c-length; //���� ��� ��ġ ����
				}
			} else { //ã���� �ϴ� ���� ������ ���ݺ��� ũ��
				if (c<length) {
					stack.push(2);
				}
				else {
					stack.push(3);
					c = c-length; //���� ��� ��ġ ����
				}
				r = r-length; //���� ��� ��ġ ����
			}
		}
		
		int ans = 0;
		int area = 1;
		while (!stack.isEmpty()) {
			ans += stack.pop() * area;
			area *= 4;
		}
		

		System.out.println(ans);
	}

}
