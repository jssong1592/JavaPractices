package BOJ.G3.BOJ_1918_����ǥ���;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static String line;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		line = br.readLine();
		
		String result = makePostFix(line);
		
		System.out.println(result);
	}
	
	static String makePostFix(String s) {
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		int i = 0;
		while (i<s.length()) {
			//��ȣ ���۵Ǹ� �װſ� �´� �ݴ� ��ȣ������ �ε����� Ž���Ͽ� ���꽺Ʈ���� ���� ��� 
			if (s.charAt(i)=='(') {
				Stack<Character> layerStack = new Stack<>();
				layerStack.push(s.charAt(i));
				int j = i+1;
				while (!layerStack.isEmpty()) {
					if (s.charAt(j)=='(') layerStack.push('(');
					else if (s.charAt(j)==')') layerStack.pop();
					j++;
				}
				
				//���꽺Ʈ������ ������� �������� ���̰� �� �� ���꽺Ʈ�� ���̸�ŭ �ε��� �̵�
				sb.append(makePostFix(s.substring(i+1,j-1)));
	
				i = j-1;
				
			} else if (s.charAt(i)==')') {
				break;
			//�ǿ����ڴ� �ٷ� ��� ���ڿ��� ���̱�
			} else if (!isOperator(s.charAt(i))) {
				sb.append(s.charAt(i));
			//�������� ���, ������ ���ÿ��� ���� �����ں��� �켱������ ���ų� ���� �����ڸ� ��� pop�ϰ� ��� ���ڿ��� ����
			} else {
				while (!stack.isEmpty()&&isPrior(s.charAt(i),stack.peek())) {
					sb.append(stack.pop());
				}	
				stack.push(s.charAt(i));
			}
			//���� �ε�����
			i++;
		}
		
		//������ �ǿ����ڱ��� Ž�������� ���ٸ� �����ڸ� �������� ���̱�
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		return sb.toString();
	}
	
	static boolean isOperator(char ch) {
		boolean flag = false;
		switch (ch) {
		case '+':
		case '-':
		case '*':
		case '/':
			flag = true;
			break;
		}
		return flag;
	}
	
	static boolean isPrior(char ch1,char ch2) {
		if ((ch1=='+'||ch1=='-')) return true;
		else if ((ch1=='*'||ch1=='/')&&(ch2=='*'||ch2=='/')) return true;
		return false;
	}

}
