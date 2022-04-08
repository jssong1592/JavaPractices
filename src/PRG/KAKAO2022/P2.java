package PRG.KAKAO2022;

import java.util.Stack;

public class P2 {

	public int solution(int n, int k) {
		String kJin = toK(n,k);
		String[] list = kJin.split("0+");
		
		int answer = 0;
		
//		System.out.println(Arrays.toString(list));

		
		for (String num:list) {
			long i = Long.parseLong(num);
			if (check(i)) answer++;
		}
		
        return answer;
    }
	
	
	static String toK(int n, int k) {
		Stack<Integer> stack = new Stack<>();
		while (n>0) {
			stack.push(n%k);
			n /= k;
		}
		
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
//		System.out.println(sb.toString());
		
		return sb.toString();
	}
	
	static boolean check(long n) {
		if (n>1) {
			if (n%2==0) {
				if (n==2) return true;
				return false;
			} else {
				for (int i=3;i<=(int)Math.pow(n, 0.5);i+=2) {
					if (n%i==0) return false;
				}
			}
			return true;
		}
		return false;
	}
	
	
	public static void main(String[] args) {

		P2 sol = new P2();
		int n = 437674;
		int k = 3;
		
		int answer = sol.solution(n, k);
		
		System.out.println(answer);
		
		n = 110011;
		k = 10;
		
		answer = sol.solution(n, k);
		System.out.println(answer);
		answer = sol.solution(999999, 3);
		System.out.println(answer);
	}
}
