package SWEA.D4.SWEA_1238_Contact;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		int tc = 1;
		while((line = br. readLine())!=null) {
			ArrayList<Integer>[] list = new ArrayList[101];
			for (int i=0;i<101;i++) list[i] = new ArrayList<Integer>();
			
			boolean[] visited = new boolean[101];
			
			StringTokenizer st = new StringTokenizer(line);
			
			int E = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for (int i=0;i<E/2;i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				list[from].add(to);
			}
			
			//BFS
			Queue<int[]> q = new LinkedList<>();
			//시작 노드로부터 이동한 거리를 배열의 2번째 원소로 저장함
			q.offer(new int[] {start,0});
			visited[start] = true;
			
			int[] maxResult = new int[] {start,0};
			
			while (!q.isEmpty()) {
				int[] node = q.poll();
				//꺼낸 노드가 현재 Max 노드보다 멀리 갔다면 무조건 해당 노드로 Max 교체
				if (node[1]>maxResult[1]) maxResult = node;
				//같은 거리라면 노드 번호를 비교하여 결정
				else maxResult = maxResult[0]<=node[0]?node:maxResult;
				
				for (Integer i:list[node[0]]) {
					if (!visited[i]) {
						visited[i] = true;
						
						q.offer(new int[] {i, node[1]+1});
					}
				}
				
			}
			
			System.out.printf("#%d %d\n",tc,maxResult[0]);
			tc++;
		}

	}

}
