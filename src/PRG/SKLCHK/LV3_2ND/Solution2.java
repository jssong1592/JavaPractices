package PRG.SKLCHK.LV3_2ND;

import java.util.Arrays;

public class Solution2 {
	public long solution(int n, int m, int x, int y, int[][] queries) {
		long answer = 0;
		long startX = x;
		long endX = x;
		long startY = y;
		long endY = y;

		for (int i = queries.length - 1; i >= 0; i--) {
			switch (queries[i][0]) {
			case 0:
				if(startY > 0) startY += queries[i][1];
				endY += queries[i][1];
				if (endY>m-1) endY = m - 1;
				break;
			case 1:
				startY -= queries[i][1];
				if (endY < m-1) endY -= queries[i][1];
				
				if (startY<0) startY = 0;
				break;
			case 2:
				if(startX > 0) startX += queries[i][1];
				endX += queries[i][1];
				if (endX>n-1) endX = n - 1;
				break;
			case 3:
				startX -= queries[i][1];
				if (endX < n-1) endX -= queries[i][1];
				if (startX<0) startX = 0;
				break;
			default:
				break;
			}
			if (startX>n-1||endX<0||startY>m-1||endY<0) return answer;
		}
		answer = (endX-startX+1) * (endY-startY+1);

		return answer;
	}

	public static void main(String[] args) {
		int n = 2;
		int m = 2;
		int x = 0;
		int y = 0;
		int[][] queries = { { 2, 1 }, { 0, 1 }, { 1, 1 }, { 0, 1 }, { 2, 1 } };
		Solution2 sol = new Solution2();
		long ans = sol.solution(n, m, x, y, queries);
		System.out.println(ans);

	}

}
