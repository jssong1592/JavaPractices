package BOJ.G5.BOJ_6416_트리인가;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = 1;
		
		boolean flag = true;
		HashMap<Integer,Integer> parentOf = new HashMap<>();
		HashSet<Integer> nodes = new HashSet<>();
		HashSet<int[]> edges = new HashSet<>();
		while(true) {
			//줄 읽기
			String line = br.readLine();
			
			String[] st = line.split("  ");
			
			for (String edge:st) {
				if (edge.equals("0 0")) {//케이스 하나가 끝났으므로 결과 처리 후 플래그 초기화
					if (nodes.size()==0||(flag&&countRoot(nodes,parentOf)==1&&nodes.size()-edges.size()==1))
						System.out.println("Case "+(tc)+" is a tree.");
					else System.out.println("Case "+(tc)+" is not a tree.");
					
					//케이스 초기화하고 다음 줄 읽고 넘어가기
					tc++;
					
					flag = true;
					parentOf = new HashMap<>();
					nodes = new HashSet<>();
					edges = new HashSet<>();
					
					line = br.readLine();
					
					break;
				} else {
					StringTokenizer st2 = new StringTokenizer(edge);
					int parent = Integer.parseInt(st2.nextToken());
					int child = Integer.parseInt(st2.nextToken());
					
					nodes.add(parent);
					nodes.add(child);
					edges.add(new int[] {parent,child});
					
					// 수정) 트리일 경우
					// ★. 노드가 없어도 트리다
					// 1. 루트가 노드가 하나
					// 2. 정점 갯수 - 간선 갯수 == 1
					// 3. 들어오는 간선의 갯수가 2 이상인 노드가 있는지(child의 부모가 이미 존재)
					if (parent==child||parentOf.get(child)!=null) {
						flag = false;
					} else {
						parentOf.put(child, parent);
					}
				}
			}
			
			//케이스 끝내고 읽은 다음 줄이 -1 -1이면 완전히 끝내기
			if (line.equals("-1 -1")) return;
			
		}
		

	}

	static int countRoot(HashSet<Integer> nodes, HashMap<Integer,Integer> parentOf) {
		int cnt = 0;
		for (int node:nodes) {
			if (parentOf.get(node)==null) cnt++;
		}
		return cnt;
	}

}
