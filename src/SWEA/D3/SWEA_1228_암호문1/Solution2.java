package SWEA.D3.SWEA_1228_암호문1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc=0;tc<10;tc++) {
			
			int n = Integer.parseInt(br.readLine());
			
			LinkedList<Integer> list = new LinkedList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			while (st.hasMoreTokens()) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			int m = Integer.parseInt(br.readLine());
			String[] cmd = new String[m];
			st = new StringTokenizer(br.readLine(),"I"); 
			
			for (int i=0;i<m;i++) {
				cmd[i] = st.nextToken();
			}
			
			for (int i=0;i<m;i++) {
				StringTokenizer st2 = new StringTokenizer(cmd[i]);
				int idx = Integer.parseInt(st2.nextToken());
				int nums = Integer.parseInt(st2.nextToken());
				LinkedList<Integer> list2 = new LinkedList<>();
				
				for (int j=0;j<nums;j++) {
					list2.add(Integer.parseInt(st2.nextToken()));
				}
				
				list.addAll(idx, list2);
			}
			
			StringBuilder sb = new StringBuilder("#"+(tc+1)+" ");
			for (int i=0;i<10;i++) {
				sb.append(list.get(i)+" ");
			}
			System.out.println(sb);
			
		}

	}

}
