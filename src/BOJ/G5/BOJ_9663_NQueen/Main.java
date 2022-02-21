package BOJ.G5.BOJ_9663_NQueen;

import java.util.Scanner;

public class Main {
	static int N;
	static int ans;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		ans = 0;
		
		
		int[] col = new int[N];
		dfs(0,col);
		
		System.out.println(ans);
	}
	
	static void dfs(int row, int[] col) {
		if (row==N) {
			ans++;
			return;
		}
		outer: for (int c=0;c<N;c++) {
			for (int prev=0;prev<row;prev++) {
				if (col[prev]==c||Math.abs(prev-row)==Math.abs(col[prev]-c)) {
					continue outer;
				}
			}
			col[row] = c;
			
			dfs(row+1,col);
			
		}
		
	}

}
