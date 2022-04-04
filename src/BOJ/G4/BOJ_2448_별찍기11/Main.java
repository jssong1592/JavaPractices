package BOJ.G4.BOJ_2448_별찍기11;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		System.out.println(buildTree(N));

	}

	static String buildTree(int n) throws Exception {
		StringBuilder sb = new StringBuilder();
		if (n==3) {
			sb.append("  *  \n");
			sb.append(" * * \n");
			sb.append("*****\n");
		}
		else {
			sb.append(combineTree(n/2, buildTree(n/2)));
		}
		return sb.toString();
	}
	
	static String combineTree(int n, String s) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new StringReader(s));
		String line;
		while ((line = br.readLine())!=null) {
			for (int i=0;i<n;i++) {
				sb.append(" ");
			}
			sb.append(line);
			for (int i=0;i<n;i++) {
				sb.append(" ");
			}
			sb.append("\n");
		}
		
		br = new BufferedReader(new StringReader(s));
		while ((line = br.readLine())!=null) {
			sb.append(line).append(" ").append(line).append("\n");
		}
		
		return sb.toString();
	}
}
