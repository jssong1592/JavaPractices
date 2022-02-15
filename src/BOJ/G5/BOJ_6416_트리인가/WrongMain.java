package BOJ.G5.BOJ_6416_트리인가;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class WrongMain {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = 1;
		
		boolean flag = true;
		HashMap<Integer,Integer> parentOf = new HashMap<>();
		
		while(true) {
			//줄 읽기
			String line = br.readLine();
			
			String[] st = line.split("  ");
			
			for (String vertex:st) {
				if (vertex.equals("0 0")) {//케이스 하나가 끝났으므로 결과 처리 후 플래그 초기화
					if (parentOf.size()==0||(flag&&countRoot(parentOf)==1))System.out.println("Case "+(tc)+" is a tree.");
					else System.out.println("Case "+(tc)+" is not a tree.");
					
					//케이스 초기화하고 다음 줄 읽고 넘어가기
					tc++;
					parentOf = new HashMap<>();
					line = br.readLine();
					flag = true;
					
					break;
				} else {
					StringTokenizer st2 = new StringTokenizer(vertex);
					int parent = Integer.parseInt(st2.nextToken());
					int child = Integer.parseInt(st2.nextToken());
					// 트리가 아닌 경우
					// 1. parent와 child가 같을 때
					// 2. child의 부모가 이미 존재할 때
					// 3. 노드가 순환할 때(조상을 자식으로 만드려고 할 때)
					// 4. 루트 노드가 2개 이상일 때
					if (parent==child||parentOf.get(child)!=null||isAncestor(child,parent,parentOf)) {
						flag = false;
					} else {
						parentOf.put(child, parent);
					}
				}
			}
			
			//케이스 끝내고 읽은 다음 줄이 -1 -1이면 완전히 끝내기
			if (line.equals("-1 -1")) break;
			
		}
		

	}
	
	static boolean isAncestor(int child, int parent, HashMap<Integer,Integer> parentOf) {
		while(parentOf.get(parent)!=null) {
			if (parentOf.get(parent)==child) {
				return true;
			}
			parent = parentOf.get(parent);
			
		}
		return false;
	}
	
	static int countRoot(HashMap<Integer,Integer> parentOf) {
		int cnt = 0;
		int root = -1;
		for(Integer child:parentOf.keySet()) {
			int parent = parentOf.get(child);
			while(parentOf.get(parent)!=null) {
		
				parent = parentOf.get(parent);
				
			}
			if (root!=parent) {
				root = parent;
				cnt++;
			}
		}
		return cnt;
	}

}
