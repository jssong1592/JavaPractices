package BOJ.S1.BOJ_1074_Z;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		Stack<Integer> stack = new Stack<>(); //4분면 단위 좌표 저장할 arrayList
		
		int length = (1<<N); //2의 N제곱부터 시작
		
		while (length>1) {
			length = length/2;
			if (r<length) { //찾고자 하는 행이 길이의 절반보다 작으면
				if (c<length) stack.push(0);
				else { //찾고자 하는 열이 길이의 절반보다 크면
					stack.push(1);
					c = c-length; //열의 상대 위치 조정
				}
			} else { //찾고자 하는 행이 길이의 절반보다 크면
				if (c<length) {
					stack.push(2);
				}
				else {
					stack.push(3);
					c = c-length; //열의 상대 위치 조정
				}
				r = r-length; //행의 상대 위치 조정
			}
		}
		
		int ans = 0;
		int area = 1;
		while (!stack.isEmpty()) {
			ans += stack.pop() * area;
			area *= 4;
		}
		

		System.out.println(ans);
	}

}
