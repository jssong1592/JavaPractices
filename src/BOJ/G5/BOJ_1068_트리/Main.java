package BOJ.G5.BOJ_1068_트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer>[] tree = new ArrayList[N];
		int[] parentOf = new int[N];
		
		for (int i=0;i<N;i++) {
			tree[i] = new ArrayList<Integer>();
		}
		
		boolean[] isVisited = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i=0;i<N;i++) {
			int parent = Integer.parseInt(st.nextToken());
			
			parentOf[i] = parent;
			if (parent>=0) {
				tree[parent].add(i);	
			}
		}
		
		int delete = Integer.parseInt(br.readLine());
		if (parentOf[delete]!=-1)
			tree[parentOf[delete]].remove(Integer.valueOf(delete));
		isVisited[delete] = true;
			
		int ans = 0;
		
		Stack<Integer> dfs = new Stack<>();
		
		for (int i=0;i<N;i++) {
			if (!isVisited[i]&&parentOf[i]==-1) dfs.push(i);
		}
		
		while (!dfs.isEmpty()) {
			int node = dfs.pop();
			
			isVisited[node] = true;
			if (tree[node].isEmpty()) ans++;
			
			for (Integer child:tree[node]) {
				if (!isVisited[child]) {
					dfs.push(child);
				}
			}
			
		}
		
		System.out.println(ans);
		
		
	}

}
