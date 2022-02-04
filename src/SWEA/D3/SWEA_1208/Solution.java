package SWEA.D3.SWEA_1208;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int findMax(int[] boxes) {
		int maxIdx = 0;
		for (int i=0;i<100;i++) {
			if (boxes[i]>boxes[maxIdx]) {
				maxIdx = i;
			}
		}
		
		return maxIdx;
	}
	
	static int findMin(int[] boxes) {
		int minIdx = 0;
		for (int i=0;i<100;i++) {
			if (boxes[i]<boxes[minIdx]) {
				minIdx = i;
			}
		}
		
		return minIdx;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc=0;tc<10;tc++) {
			int maxIdx=0, minIdx=0;
			
			int dump = Integer.parseInt(br.readLine());
			int[] boxes = new int[100];
			int i = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (i<100&&st.hasMoreTokens()) {
				boxes[i] = Integer.parseInt(st.nextToken());
				i++;
			}
	
			
			while (dump>0) {
				maxIdx = findMax(boxes);
				minIdx = findMin(boxes);
				
				boxes[maxIdx]--;
				boxes[minIdx]++;
				
				dump--;
			}
			
			System.out.printf("#%d %d%n",tc+1,boxes[findMax(boxes)]-boxes[findMin(boxes)]);
			
			
		}

	}

}
