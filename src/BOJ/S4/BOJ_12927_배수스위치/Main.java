package BOJ.S4.BOJ_12927_배수스위치;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split("");
		int ans = 0;
		for (int i=0;i<s.length;i++) {
			switch(s[i]) {
			case "N": continue;
			case "Y": 
				for (int j=i;j<s.length;j+=(i+1)) {
					switch(s[j]) {
					case "Y" : s[j] = "N"; break;
					case "N" : s[j] = "Y"; break;
					}
					
				}
				
				ans++;
			}
		}
		for (int i=0;i<s.length;i++) {
			if (s[i].equals("Y")) {
				ans = -1;
				break;
			}
		}
		System.out.println(ans);

	}

}
