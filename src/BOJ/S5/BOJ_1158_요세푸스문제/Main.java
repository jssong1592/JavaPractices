package BOJ.S5.BOJ_1158_요세푸스문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		
		StringBuilder sb = new StringBuilder("<");
		
		for (int i=1;i<=N;i++) {
			q.offer(i);
		}
		
		int cnt = K-1;
		
		while (!q.isEmpty()) {
			
			if (cnt==0) {
				sb.append(q.poll());
				cnt = K-1;
				if (!q.isEmpty()) sb.append(", ");
				else sb.append(">");
			} else {
				q.offer(q.poll());
				cnt--;
			}
			
		}
		
		System.out.println(sb);

	}

}
