package BOJ.S1.BOJ_1992_쿼드트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		//N*N 배열 map에 입력 데이터 저장
		for (int i=0;i<N;i++) {
			String s = br.readLine();
			for (int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
			}
		}
		
		System.out.println(quad(N,0,0));
	}
	
	static String quad(int N, int startX, int startY) {
		// 크기가 1이면 해당 좌표의 숫자 그대로 스트링으로 변환하여 반환
		if (N==1) return String.valueOf(map[startX][startY]);
		
		// 크기가 1보다 크면 4분면으로 나눠 (xxxx) 형식을 반환하도록 StringBuilder로 문자열 생성
		StringBuilder sb = new StringBuilder();
		
		// 각 4분면의 map에서의 위치를 가로세로 인덱스에 N/2를 더하면서 설정하고, 크기를 2로 나눔
		sb.append("(")
		.append(quad(N/2,startX,startY))
		.append(quad(N/2,startX,startY+N/2))
		.append(quad(N/2,startX+N/2,startY))
		.append(quad(N/2,startX+N/2,startY+N/2))
		.append(")");
		
		String s = sb.toString();
		
		// 압축이 가능하면 압축
		if (s.equals("(1111)")) s = "1";
		else if (s.equals("(0000)")) s = "0";
		
		return s;
	}
}
