package PRG.LV3.PRG_12907_거스름돈;

import java.util.*;

public class Solution {
	public int solution(int n, int[] money) {
        int[] results = new int[n+1];
        results[0] = 1;
        Arrays.sort(money);
        for (int i=0;i<money.length;i++) {
            for (int j=1;j<n+1;j++) {
                if (j-money[i]>=0) {
                    results[j] += results[j-money[i]];
                }
            }
            results[i] %= 1000000007;
        }
        
        return results[n];
    }
}
