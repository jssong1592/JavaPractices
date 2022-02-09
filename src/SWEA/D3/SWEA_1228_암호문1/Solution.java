package SWEA.D3.SWEA_1228_¾ÏÈ£¹®1;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc=0;tc<10;tc++) {
			int length = sc.nextInt();
			LinkedList<Integer> list = new LinkedList<>();
			
			for (int i=0;i<length;i++) {
				list.add(sc.nextInt());
			}
			
			int cmd = sc.nextInt();
			
			for (int i=0;i<cmd;i++) {
				char insert = sc.next().charAt(0);
				int idx = sc.nextInt();
				int nums = sc.nextInt();
				
				LinkedList<Integer> extraList = new LinkedList<>();
				
				for (int num=0;num<nums;num++) {
					extraList.add(sc.nextInt());
				}
				
				list.addAll(idx, extraList);
				
				
				
			}
			
			System.out.printf("#%d ",tc+1);
			for (int j=0;j<10;j++) {
				System.out.printf("%d ",list.get(j));
			}
			System.out.println();
			
		}

	}

}
