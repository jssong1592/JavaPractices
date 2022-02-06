package PRG.LV2.PRG_42883;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


//큰 수 만들기
//https://programmers.co.kr/learn/courses/30/lessons/42883

public class Solution {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		String number = st.nextToken();
		int k = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		
	
		Stack<Character> stack = new Stack<>();
		
		
		for(int i=0;i<number.length();i++) {
			while(!stack.isEmpty()&&number.charAt(i)>stack.peek()&&k>0) {
				stack.pop();
				k--;
			}
			stack.push(number.charAt(i));
		}
		
		for (int i=0;i<stack.size()-k;i++) {
			sb.append(stack.get(i));
		}
		
		System.out.println(sb);
		

	}

}
