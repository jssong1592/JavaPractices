package BOJ.S2.BOJ_2504_괄호의값;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		Stack<Character> stack = new Stack<>();
		Stack<Boolean> isLayered = new Stack<>();
		
		
		int ans = 0;
		int layer = 1;
		
		for (int i=0;i<str.length();i++) {
			if (str.charAt(i)=='['||str.charAt(i)=='(') {
				stack.push(str.charAt(i));
				
				if (isLayered.isEmpty()) isLayered.push(true);
				else {
					if (isLayered.peek()) {
						isLayered.pop();
						isLayered.push(false);
					}
					isLayered.push(true);
				}
				
				layer = (str.charAt(i)=='(')?layer*2:layer*3;
				
			} else if (str.charAt(i)==')') {
				if (stack.isEmpty()||stack.peek()!='(') {
					ans = 0;
					break;
				} else {
					stack.pop();
					if (isLayered.pop()) {
						ans += layer;
					}
					layer /= 2;
				}
				
			} else if (str.charAt(i)==']') {
				if (stack.isEmpty()||stack.peek()!='[') {
					ans = 0;
					break;
				} else {
					stack.pop();
					if (isLayered.pop()) {
						ans += layer;
						
					}
					layer /= 3;
					
				}
			}
			
			System.out.println(stack.toString());
			System.out.println(isLayered.toString());
			
			
		}
		if (!stack.isEmpty()) ans = 0;
		System.out.println(ans);
	}

}
