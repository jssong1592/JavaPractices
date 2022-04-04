package BOJ.G4.BOJ_3584_가장가까운공통조상;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=0;tc<T;tc++) {
			int N = Integer.parseInt(br.readLine());
			
			ArrayList<Integer>[] tree = new ArrayList[N+1];
			for (int i=0;i<N+1;i++) {
				tree[i] = new ArrayList<Integer>();
			}
			
			boolean[] isVisited = new boolean[N+1];
			int[] parentOf = new int[N+1];
			
			for (int i=0;i<N-1;i++) {
				String[] s = br.readLine().split(" ");
				
				int A = Integer.parseInt(s[0]);
				int B = Integer.parseInt(s[1]);
					
				tree[A].add(B);
				parentOf[B] = A;
				
			}
			
			String[] s = br.readLine().split(" ");
			
			int x = Integer.parseInt(s[0]);
			int y = Integer.parseInt(s[1]);
			
			Stack<Integer> stack = new Stack<>();
			
			boolean flag = false;
			
			int ans = x;
			
			while (!flag) {
				
				stack.push(x);
				
				while (!stack.isEmpty()) {
					int node = stack.pop();
					if (node==y) {
						flag = true;
						ans = x;
						break;
					}
					isVisited[node] = true;
					for (Integer child:tree[node]) {
						if (!isVisited[child]) {
							stack.push(child);
						}
					}
				}
				
				x = parentOf[x];
			}
			
			System.out.println(ans);
			
		}
		

	}

}
