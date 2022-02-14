package BOJ.G4.BOJ_1967_트리의지름;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<int[]>[] graph = new ArrayList[N+1];
		
		
		for (int i=0;i<N+1;i++) graph[i] = new ArrayList<int[]>();
		
		for (int i=0;i<N-1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			graph[parent].add(new int[] {child,weight});
			graph[child].add(new int[] {parent,weight});
		}
		
		for (int i=0;i<N+1;i++) {
			ArrayList<int[]> x = graph[i];
			for (int[] arr:x) System.out.println(Arrays.toString(arr));
		}

	}

}
