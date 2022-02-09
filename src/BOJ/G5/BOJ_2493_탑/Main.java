package BOJ.G5.BOJ_2493_탑;

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
				while(!stack.isEmpty()&&stack.peek()[1]<T) //스택이 비거나, 현재 탑 높이가 스택의 맨 윗 부분 탑 높이보다 낮을 때까지 계속 pop
					stack.pop();
				
				if (stack.isEmpty()) sb.append("0 "); // 다 pop하고 스택이 비어있으면 0
				else sb.append(stack.peek()[0]+" "); // 스택이 안 비어있으면(신호를 받은 탑이 스택의 맨 윗 부분에 있음) 탑의 번호 기록
			}
			
			stack.push(new int[] {i+1,T}); // 자기 자신은 push
		}
		System.out.println(sb);
	}

}
