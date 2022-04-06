package BOJ.G4.BOJ_17471_게리맨더링;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[] isRed;
	static int[] people;
	static ArrayList<Integer>[] adjList;
	static int minDiff;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		people = new int[N+1];
		adjList = new ArrayList[N+1];
		minDiff = Integer.MAX_VALUE;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=1;i<N+1;i++) {
			adjList[i] = new ArrayList<Integer>();
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for (int j=0;j<num;j++) {
				adjList[i+1].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		//노드 최대 개수가 10이므로 모든 조합 비트마스킹
		for (int set=0;set<(1<<N);set++) {
			if (bfs(set)&&bfs((1<<N)-1-set)) {
				minDiff = Math.min(minDiff, calcDiff(set));
			}
			
		}
		
		if (minDiff==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(minDiff);

	}
	
	static boolean bfs(int set) {
		boolean[] visited = new boolean[N+1];
		Queue<Integer> queue = new LinkedList<>();
		visited[0] = true;
		for (int i=1;i<N+1;i++) {
			if ((set&(1<<(i-1)))==0) visited[i] = true;
		}
		
		int start = 0;
		for (int i=1;i<N+1;i++) {
			if (!visited[i]) {
				start = i;
				break;
			}
		}
		
		if (start==0) return false;
		
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int curNode = queue.poll();
			
			for (int nextNode:adjList[curNode]) {
				if(!visited[nextNode]) {
					visited[nextNode] = true;
					queue.offer(nextNode);
				}
			}
		}
		
		
		//탐색 다 끝나고 visited 돌았을 때 false가 있다면, 선거구가 연결되지 않은 것이므로 false 리턴
		for (int i=1;i<N+1;i++) {
			if (!visited[i]) return false;
		}
		
		return true;
	}

	static int calcDiff(int set) {
		int myPeople = 0;
		int yourPeople = 0;
		
		for (int i=1;i<N+1;i++) {
			if ((set&(1<<(i-1)))>0) myPeople += people[i];
			else yourPeople += people[i];
		}
		
		return Math.abs(myPeople-yourPeople);
	}
}
