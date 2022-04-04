package BOJ.G5.BOJ_2075_N번째큰수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static int findMaxStack(Stack<Integer>[] table) { // 현재 가장 큰 수가 있는 인덱스 찾기
		int max = Integer.MIN_VALUE;
		int maxIdx = Integer.MIN_VALUE;
		for (int i=0;i<table.length;i++) {
			if (table[i].peek()>max) {
				max = table[i].peek();
				maxIdx = i;
			}
		}
		System.out.println(table[maxIdx].toString());
		return maxIdx;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer>[] table = new Stack[N];
		
		for (int i=0;i<N;i++) {
			table[i] = new Stack<Integer>();
		}
		
		for (int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int j=0;j<N;j++) {
				
				table[j].push(Integer.parseInt(st.nextToken()));
			}
		}
		
		for (int i=0;i<N-1;i++) { // N-1번 pop해서 N번째 큰 수까지 찾아내기
			int idx = findMaxStack(table);
			table[idx].pop();
		}
		
		System.out.println(table[findMaxStack(table)].peek());
	}

}
