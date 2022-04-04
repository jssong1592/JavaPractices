package BOJ.G3.BOJ_1918_후위표기식;

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
			//괄호 시작되면 그거에 맞는 닫는 괄호때까지 인덱스를 탐색하여 서브스트링을 만들어서 재귀 
			if (s.charAt(i)=='(') {
				Stack<Character> layerStack = new Stack<>();
				layerStack.push(s.charAt(i));
				int j = i+1;
				while (!layerStack.isEmpty()) {
					if (s.charAt(j)=='(') layerStack.push('(');
					else if (s.charAt(j)==')') layerStack.pop();
					j++;
				}
				
				//서브스트링에서 만들어진 후위식을 붙이고 난 후 서브스트링 길이만큼 인덱스 이동
				sb.append(makePostFix(s.substring(i+1,j-1)));
	
				i = j-1;
				
			} else if (s.charAt(i)==')') {
				break;
			//피연산자는 바로 결과 문자열에 붙이기
			} else if (!isOperator(s.charAt(i))) {
				sb.append(s.charAt(i));
			//연산자일 경우, 연산자 스택에서 현재 연산자보다 우선순위가 높거나 같은 연산자를 모두 pop하고 결과 문자열에 붙임
			} else {
				while (!stack.isEmpty()&&isPrior(s.charAt(i),stack.peek())) {
					sb.append(stack.pop());
				}	
				stack.push(s.charAt(i));
			}
			//다음 인덱스로
			i++;
		}
		
		//마지막 피연산자까지 탐색했으면 꼬다리 연산자를 마지막에 붙이기
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
