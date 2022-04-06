package SWEA.SWEA_2112_보호필름;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int D, W, K, min;
	static final int A = 0, B = 1;
	static int[] drugA, drugB;
	static int[][] film;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			drugA = new int[W];
			drugB = new int[W];
			
			film = new int[D][W];
			min = K;
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			Arrays.fill(drugA, A);
			Arrays.fill(drugB, B);
			
			process(0,0);

			System.out.printf("#%d %d\n", tc, min);
		}

	}

	static boolean check() {
		//열 고정하고 행 탐색, 연속된 셀의 같은 특성이 K개 이상인지 검사
		for (int c=0;c<W;c++) {
			int cnt = 1;
			int before = film[0][c];
			for (int r=1;r<D;r++) {
				int cur = film[r][c];
				if (before==cur) {
					if(++cnt==K) break;
				
				} else {
					before = cur;
					cnt = 1;
				}
			}
			if (cnt<K) return false;
		}
		
		return true;
	}
	
	//각 막에 부분집합으로 약품 비투여, 약품A투여, 약품B 투여
	static boolean process(int row, int useCnt) {
		
		if (row==D) {
			if(check()) {
				min = Math.min(min, useCnt);
				return min==0; //약품을 하나도 사용하지 않았으면 true
			}
			
			return false;
		}
		
		//기존 임시최적해의 최소약품수보다 현재까지 사용한 약품수가 같거나 크면 의미없음
		if(useCnt>=min) return false; 
		
		int[] backup = film[row]; //현재 막의 상태배열 기억
		//약품 비투여
		process(row+1,useCnt); //약품을 하나도 사용하지 않았으므로 그대로 true 리턴 계속하도록
		//약품A 투여
		film[row] = drugA;
		process(row+1,useCnt+1);
		
		//약품B 투여
		film[row] = drugB;
		process(row+1,useCnt+1);
		
		//되돌리기
		film[row] = backup;
		return false;
	}
}
