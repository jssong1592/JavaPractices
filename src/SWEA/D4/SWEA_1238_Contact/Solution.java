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
			//���� ���κ��� �̵��� �Ÿ��� �迭�� 2��° ���ҷ� ������
			q.offer(new int[] {start,0});
			visited[start] = true;
			
			int[] maxResult = new int[] {start,0};
			
			while (!q.isEmpty()) {
				int[] node = q.poll();
				//���� ��尡 ���� Max ��庸�� �ָ� ���ٸ� ������ �ش� ���� Max ��ü
				if (node[1]>maxResult[1]) maxResult = node;
				//���� �Ÿ���� ��� ��ȣ�� ���Ͽ� ����
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
