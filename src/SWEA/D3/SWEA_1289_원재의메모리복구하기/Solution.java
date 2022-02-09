package SWEA.D3.SWEA_1289_원재의메모리복구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int t=0;t<tc;t++) {
			String s = br.readLine();
			String[] arr = s.split("");
			int cnt = 0;
			
			for (int i=0;i<arr.length;i++) {
				if (i==0) {
					if (arr[0].equals("1")) {
						cnt++;
					}
				} else if (!arr[i].equals(arr[i-1])) {
					cnt++;
				}
			}
			
			System.out.printf("#%d "+ cnt +"%n",t+1);
		}

	}
}
