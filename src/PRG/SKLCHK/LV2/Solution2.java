package PRG.SKLCHK.LV2;

import java.util.Arrays;
import java.util.Collections;

public class Solution2 {
	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		
		for (int i=0;i<prices.length;i++) {
			int cnt = 0;
			boolean flag = true;
			for (int j=i+1;j<prices.length;j++) {
				if (prices[i]<=prices[j]) cnt++;
				else {
					answer[i] = ++cnt;
					flag = false;
					break;
				}
			}
			if (flag) answer[i] = cnt;
		}
		
		return answer;
	}

	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		int[] c = { 1, 2, 3, 2, 3 };
		System.out.println(Arrays.toString(sol.solution(c)));
	}

}
