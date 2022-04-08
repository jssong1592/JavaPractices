package PRG.KAKAO2022;

import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P1 {

	public int[] solution(String[] id_list, String[] report, int k) {
		int N = id_list.length;
		HashMap<String,Integer> idMap = new HashMap<>();
		
		int no = 0;
		for (String id:id_list) {
			idMap.put(id,no++);
		}
		
		System.out.println(idMap);
		
		boolean[][] matrix = new boolean[N][N];
		
		for (String rep:report) {
			StringTokenizer st = new StringTokenizer(rep);
			int x = idMap.get(st.nextToken());
			int y = idMap.get(st.nextToken());
			
			matrix[x][y] = true;
		}
		
		boolean[] isStopped = new boolean[N];
		for (int i=0;i<N;i++) {
			int cnt = 0;
			for (int j=0;j<N;j++) {
				if (matrix[j][i]) cnt++;
				if (cnt==k) {
					isStopped[i] = true;
					break;
				}
			}
		}
		
		int[] result = new int[N];
		
		for (int i=0;i<N;i++) {
			int mail = 0;
			for (int j=0;j<N;j++) {
				if (matrix[i][j]&&isStopped[j]) mail++;
			}
			result[i] = mail;
		}
		
		return result;
	}

	public static void main(String[] args) {

		P1 sol = new P1();
		String[] id_list = { "muzi", "frodo", "apeach", "neo" };
		String[] report = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };
		int k = 2;
		int[] result = sol.solution(id_list, report, k);
		System.out.println(Arrays.toString(result));

		String[] id_list2 = { "con", "ryan" };
		String[] report2 = { "ryan con", "ryan con", "ryan con", "ryan con" };
		int k2 = 3;
		int[] result2 = sol.solution(id_list2, report2, k2);
		System.out.println(Arrays.toString(result2));
	}

}
