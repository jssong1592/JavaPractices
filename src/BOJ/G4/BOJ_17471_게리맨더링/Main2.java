package BOJ.G4.BOJ_17471_게리맨더링;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
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
		
		//모든 노드에 대하여 bfs로 인접 노드를 하나씩 추가하면서 선거구를 2개로 나눌수 있는지 체크 
		//-> 추가 안된 노드들끼리 dfs해서 다 연결돼있는지 확인
		for (int node=1;node<N+1;node++) {
			isRed = new boolean[N+1];
			bfs(node);
		}
		
		if (minDiff==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(minDiff);

	}
	
	static void bfs(int node) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(node);
		isRed[node] = true;
		
		while(!queue.isEmpty()) {
			int curNode = queue.poll();
			
			for (int nextNode:adjList[curNode]) {
				if (!isRed[nextNode]) {
					//인접 노드가 있으면 선거구에 포함시키고, 나머지 선거구들이 연결되어있는지 확인
					isRed[nextNode] = true;
					//나머지 선거구들이 연결되어 있다면, 인구수 계산
					if (search()) {
						minDiff = Math.min(minDiff, calcDiff());
					}
				}
			}
		}
	}
	
	static boolean search() {
		boolean[] visited = new boolean[N+1];
		Queue<Integer> queue = new LinkedList<>();
		visited[0] = true;
		for (int i=1;i<N+1;i++) {
			if (isRed[i]) visited[i] = true;
		}
		
		int start = 0;
		for (int i=1;i<N+1;i++) {
			if (!visited[i]) {
				start = i;
				break;
			}
		}
		
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

	static int calcDiff() {
		int myPeople = 0;
		int yourPeople = 0;
		
		for (int i=1;i<N+1;i++) {
			if (isRed[i]) myPeople += people[i];
			else yourPeople += people[i];
		}
		
		return Math.abs(myPeople-yourPeople);
	}
}
