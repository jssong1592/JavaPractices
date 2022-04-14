package BOJ.G2.BOJ_2696_중앙값구하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc=0;tc<T;tc++) {
			int M = Integer.parseInt(br.readLine());
			
			PriorityQueue<Integer> pqLow = new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Integer> pqHigh = new PriorityQueue<>();
			

			StringBuilder sb = new StringBuilder();
			int OutCnt = 0;
			
			int Mcnt = 0;
			while (Mcnt<M) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				while (st.hasMoreTokens()) {
					int num = Integer.parseInt(st.nextToken());
					Mcnt++;
					
					if (pqLow.size()==pqHigh.size()) {
						pqHigh.offer(num);
					} else {
						pqLow.offer(num);
					}
					
					if (!pqLow.isEmpty()) {
						if (pqHigh.peek()<pqLow.peek()) { 
							int a = pqHigh.poll();
							int b = pqLow.poll();
							
							pqLow.offer(a);
							pqHigh.offer(b);
						}
					}
					
					if (Mcnt%2==1) {
						sb.append(pqHigh.peek());
						OutCnt++;
						if (OutCnt%10==0) sb.append("\n");
						else sb.append(" ");
					}
				}
			}
			
			System.out.println(M/2 + 1);
			System.out.println(sb.toString());
		}

	}

}
