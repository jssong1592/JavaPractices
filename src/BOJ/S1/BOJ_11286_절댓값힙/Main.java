package BOJ.S1.BOJ_11286_절댓값힙;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String line;
		
		PriorityQueue<Integer> pq1 = new PriorityQueue<>();
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
		
		while ((line = br.readLine())!=null) {
			int cmd = Integer.parseInt(line);
			
			if (cmd>0) {
				pq1.offer(cmd);
			} else if (cmd<0) {
				pq2.offer(cmd);
				
			} else {
				if (!pq1.isEmpty()&&!pq2.isEmpty()) {
					int ans = pq1.peek()>=(-pq2.peek())?pq2.poll():pq1.poll();
					System.out.println(ans);
				} else if (!pq1.isEmpty()&&pq2.isEmpty()) {
					System.out.println(pq1.poll());
				} else if (pq1.isEmpty()&&!pq2.isEmpty()) {
					System.out.println(pq2.poll());
				} else {
					System.out.println(0);
				}
			}
			
				
			
		}
		
		
		
	}

}
