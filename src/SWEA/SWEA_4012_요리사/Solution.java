package SWEA.SWEA_4012_요리사;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] syn;
	static boolean[] isSelected;
	
	static int N;
	static int minResult;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			minResult = Integer.MAX_VALUE;
			
			//입력 데이터를 2차원 배열에 저장
			syn = new int[N][N];
			
			for (int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for (int j=0;j<N;j++) {
					syn[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			isSelected = new boolean[N];
		
			combination(0,0);
			
			System.out.printf("#%d %d\n",tc,minResult);
		}

	}
	
	static void combination(int cnt, int start) {
		if (cnt==N/2) {
			//isSelected배열에서 true가 N/2개 골라지면 시너지 구하기
			int result = findSynergy();
			if (result<minResult) minResult = result;
			return;
		}
		else {
			for (int i=start;i<N;i++) {
				isSelected[i] = true;
				combination(cnt+1,i+1);
				isSelected[i] = false;
			}
		}
	}

	static int findSynergy() {
		int synergy1 = 0;
		int synergy2 = 0;
		//N개 중에서 2개 골라서 둘다 true면 1번에 시너지 합, 둘다 false면 2번에 시너지 합
		for (int i=0;i<N;i++) {
			for (int j=i+1;j<N-1;j++) {
				if (isSelected[i]&&isSelected[j]) {
					synergy1 += syn[i][j];
					synergy1 += syn[j][i];									
				} else if (!isSelected[i]&&!isSelected[j]) {
					synergy2 += syn[i][j];
					synergy2 += syn[j][i];	
				}
			}
		}
		
		return Math.abs(synergy1-synergy2);
	}
}
