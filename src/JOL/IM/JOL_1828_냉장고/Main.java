package JOL.IM.JOL_1828_냉장고;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][];
		int ans = 0;
		
		for (int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int min = Integer.parseInt(st.nextToken());
			int max = Integer.parseInt(st.nextToken());
			
			arr[i] = new int[] {min,max};
		}
		
		Arrays.sort(arr, (o1,o2)->{ //받은 재료들을 오름차순으로 정렬 -> 다음 재료는 범위상으로 오른쪽에 있을 수 밖에 없음
			int[] a = (int[]) o1;
			int[] b = (int[]) o2;
			
			return a[0]!=b[0]?a[0]-b[0]:a[1]-b[1];
		});
		
//		System.out.println(Arrays.deepToString(arr));
		
		//첫번째 재료의 온도를 첫 범위로 설정
		int curMin = arr[0][0];
		int curMax = arr[0][1];
		ans++;
		
		for (int i=1;i<N;i++) {
			
			//다음 재료가 현재의 범위를 초과하면 새로운 냉장고 필요한 것이므로 냉장고 추가 & 범위 갱신
			if (curMax<arr[i][0]) {
				ans++;
				
				curMin = arr[i][0];
				curMax = arr[i][1];
				
			} else {//다음 재료가 현재 범위 내에 있거나 걸쳐있으면 범위 좁히기
				curMin = Math.max(curMin, arr[i][0]);
				curMax = Math.min(curMax, arr[i][1]);
			}
		}
		
		System.out.println(ans);
	}
}
