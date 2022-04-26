package PRG.SKLCHK.LV2;

import java.util.Arrays;
import java.util.Collections;

public class Solution1 {
	public int solution(int[] citations) {
        int answer = 0;
        Integer[] c = new Integer[citations.length];
        for (int i=0;i<citations.length;i++) {
        	c[i] = citations[i];
        }
        Arrays.sort(c,Collections.reverseOrder());
        for (int i=0;i<c.length;i++) {
        	if (c[i]>=i+1) answer = i+1;
        }
        
        return answer;
    }
	
	
	public static void main(String[] args) {
		Solution1 sol = new Solution1();
		int[] c = {3,0,6,1,5};
		System.out.println(sol.solution(c));
		int[] c2 = {3,3,3,3,3};
		System.out.println(sol.solution(c2));
	}

}
