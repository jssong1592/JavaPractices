package BOJ.S1.BOJ_2961_도영이가만든맛있는음식;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] food = new int[N][];
		
		for (int i=0;i<N;i++) { // 재료 정보 저장
			StringTokenizer st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			food[i] = new int[] {S,B};
		}
		
		int result = Integer.MAX_VALUE;
		
		//재료 집합의 모든 부분집합에 대하여 탐색하기
		for (int i=1;i<(1<<N);i++) { //비트마스킹으로 부분집합 판별하기(공집합 제외니까 0 빼고 1부터)
			int sour = 1;
			int bitter = 0;
			for (int j=0;j<N;j++) { //i의 0~N-1번째 비트가 켜져있는지 1을 j만큼 비트시프트하면서 판별 
				if (((1<<j)&i)!=0) { //0이 안나오면 비트가 켜져있음. 따라서 선택된 인덱스 취급하여 연산
					sour *= food[j][0];
					bitter += food[j][1];
					
				}
			}
			result = Math.min(result, Math.abs(sour-bitter));
		}
		
		System.out.println(result);
		
	}

}
