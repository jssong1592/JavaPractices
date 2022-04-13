package SWEA.SWEA_4013_특이한자석;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static ArrayList<Integer>[] gear;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1;tc<=T;tc++) {
			int K = Integer.parseInt(br.readLine());
			
			gear = new ArrayList[4];
			
			for (int i=0;i<4;i++) {
				gear[i] = new ArrayList<Integer>();
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j=0;j<8;j++) {
					gear[i].add(Integer.parseInt(st.nextToken()));
				}
				
			}
			
			for (int k=0;k<K;k++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int no = Integer.parseInt(st.nextToken()) - 1;
				int type = Integer.parseInt(st.nextToken());
				
				visited = new boolean[4];
				process(type, no);
//				for (int i=0;i<4;i++) {
//					System.out.println(gear[i]);
//				}
			}
			
			
			int ans = 1 * gear[0].get(0) + 2 * gear[1].get(0) + 4 * gear[2].get(0) + 8 * gear[3].get(0);
			
			System.out.printf("#%d %d\n",tc,ans);
		}

	}
	
	static void process(int type, int no) {
		if (visited[no]) return;
		visited[no] = true;
		int left = no-1>=0?no-1:-1;
		int right = no+1<4?no+1:4;
		
		if (left!=-1&&gear[no].get(6)!=gear[left].get(2)) {
			process(-type, left);
		}
		
		if (right!=4&&gear[no].get(2)!=gear[right].get(6)) {
			process(-type,right);
		}
		rotate(type,no);
	}
	
	static void rotate(int type, int no) {
		//시계방향 -> 마지막을 빼서 첫번째로 넣고, 첫번째는 2번째로 밀기
		if (type==1) {
			int last = gear[no].get(7);
			gear[no].remove(7);
			gear[no].add(0, last);
		}
		//반시계방향 -> 첫번째를 빼서 2번째를 당기고, 첫번째는 마지막으로 밀기
		else {
			int first = gear[no].get(0);
			gear[no].remove(0);
			gear[no].add(first);
		}
	}
}
