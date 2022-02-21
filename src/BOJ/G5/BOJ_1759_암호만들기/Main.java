package BOJ.G5.BOJ_1759_암호만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
	static int L;
	static int C;
	static char[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new char[C];
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0;i<C;i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		//문자 리스트를 정렬해서 문자열들이 오름차순으로 나올 수 있게 처리 
		Arrays.sort(arr);
		
		sb = new StringBuilder();
		
		pickLetter(0,0,0,0,new StringBuilder());
		
		System.out.println(sb);
	}

	static void pickLetter(int cnt, int start,int vowelCnt,int constCnt, StringBuilder temp) {
		//문자열이 조건을 만족하면 답에 붙여주고 재귀에서 돌아오기
		if (cnt==L&&vowelCnt>=1&&constCnt>=2) {
			sb.append(temp).append("\n");
			
			return;
		} 
		for (int i=start;i<C;i++) {
			//붙일 알파벳이 자음, 모음인지에 따라 상태값 변화 주고 현재 문자열에 붙이기
			if (arr[i]=='a'||arr[i]=='e'||arr[i]=='i'||arr[i]=='o'||arr[i]=='u') vowelCnt++;
			else constCnt++;
			
			temp.append(arr[i]);
			
			//조합을 위해 다음 문자열로 이동
			pickLetter(cnt+1, i+1, vowelCnt, constCnt, temp);
			
			//재귀에서 돌아올 때 현재 문자를 붙이기 이전 상태로 되돌려 주기
			if (arr[i]=='a'||arr[i]=='e'||arr[i]=='i'||arr[i]=='o'||arr[i]=='u') vowelCnt--;
			else constCnt--;
			temp.deleteCharAt(temp.length()-1);
		}
	}
}
