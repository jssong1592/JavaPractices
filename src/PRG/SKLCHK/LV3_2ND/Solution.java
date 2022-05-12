package PRG.SKLCHK.LV3_2ND;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	static ArrayList<int[]> result;
    
    public int[][] solution(int n) {
        result = new ArrayList<>();
        
        hanoi(n,1,3,2);
        
        int[][] answer = new int[result.size()][];
        for (int i=0;i<answer.length;i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
    
    static void hanoi(int num, int start, int end, int mid) {
        if (num==1) {
            result.add(new int[]{start, end});
        } else {
            hanoi(num-1, start, mid, end);
            result.add(new int[]{start,end});
            hanoi(num-1, mid, end, start);
        }
    }
	
	public static void main(String[] args) {


	}

}
