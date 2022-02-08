package SWEA.D3.SWEA_1225;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc=0;tc<10;tc++) {
			int t = sc.nextInt();
			Queue<Integer> q = new LinkedList<>();
			for (int i=0;i<8;i++) {
				q.offer(sc.nextInt());
			}
			boolean flag = true;
			while (flag) {
				for (int i=0;i<5;i++) {
					int x = q.poll();
					
					if (x-i-1>0) {
						q.offer(x-i-1);
					} else {
						q.offer(0);
						flag = false;
						break;
					}
				}
			}
			
			System.out.printf("#%d ", t);
			while (!q.isEmpty()) {
				System.out.printf("%d ",q.poll());
			}
			System.out.println();
		}

	}

}
