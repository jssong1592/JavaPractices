package BOJ.S1.BOJ_1629_곱셈;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());
		
		System.out.println(power(A,B,C));
	}
	
	static long power(long A, long B, long C) {
		if (B==1) return A % C;
		
		long temp = power(A,B/2,C);
		
		if (B%2==1) {
			return ((temp * temp % C) * A) % C;
		}
		
		
		
		return temp * temp % C;
	}

}
