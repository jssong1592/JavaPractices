package JOL.IM.JOL_1828_�����;

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
		
		Arrays.sort(arr, (o1,o2)->{ //���� ������ ������������ ���� -> ���� ���� ���������� �����ʿ� ���� �� �ۿ� ����
			int[] a = (int[]) o1;
			int[] b = (int[]) o2;
			
			return a[0]!=b[0]?a[0]-b[0]:a[1]-b[1];
		});
		
//		System.out.println(Arrays.deepToString(arr));
		
		//ù��° ����� �µ��� ù ������ ����
		int curMin = arr[0][0];
		int curMax = arr[0][1];
		ans++;
		
		for (int i=1;i<N;i++) {
			
			//���� ��ᰡ ������ ������ �ʰ��ϸ� ���ο� ����� �ʿ��� ���̹Ƿ� ����� �߰� & ���� ����
			if (curMax<arr[i][0]) {
				ans++;
				
				curMin = arr[i][0];
				curMax = arr[i][1];
				
			} else {//���� ��ᰡ ���� ���� ���� �ְų� ���������� ���� ������
				curMin = Math.max(curMin, arr[i][0]);
				curMax = Math.min(curMax, arr[i][1]);
			}
		}
		
		System.out.println(ans);
	}
}
