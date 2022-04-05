package BOJ.G2.BOJ_12015_가장긴증가하는부분수열2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N + 1];

		long[] dp = new long[N + 1];
		// dp[j]=k를 만족하는 j 중 arr[j]의 값이 가장 작은 j를 저장하는 배열
		int[] smallest = new int[N + 1];
		Arrays.fill(smallest, Integer.MAX_VALUE);
		smallest[0] = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i + 1] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;
		
		for (int i = 1; i < arr.length; i++) {
			// smallest 배열에서 이진탐색을 통해 자신이 들어갈 인덱스를 찾음
			int idx = bisect(smallest, arr[i]);
			ans = Math.max(idx, ans);
			// 자신이 들어갈 인덱스에 해당하는 smallest의 값이 자신으로 인해 더 작은 값으로 갱신될 수 있으면 갱신
			if (smallest[idx] > arr[i])
				smallest[idx] = arr[i];
			// 해당 인덱스(i)의 숫자가 마지막으로 들어가는 가장 긴 부분수열의 길이는
			// 그 숫자보다 작은 숫자로 끝나는 수열 중 가장 긴 수열의 길이 + 1
			dp[i] = dp[idx-1] + 1;
		}


//
//		System.out.println(Arrays.toString(dp));
//		System.out.println(Arrays.toString(smallest));
		System.out.println(ans);

	}

	static int bisect(int[] arr, int num) {
		int i = 0;
		int j = arr.length;

		while (i <= j) {
			int mid = (i + j) / 2;
			if (arr[mid] == num)
				return mid;
			if (arr[mid] > num)
				j = mid - 1;
			else
				i = mid + 1;
		}
		return i;
	}

}
