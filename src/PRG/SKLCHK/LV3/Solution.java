package PRG.SKLCHK.LV3;

import java.util.StringTokenizer;

public class Solution {
	static int maxCnt;
	public int solution(String[] lines) {
		//00:00:00.000부터 23:59:59.999 까지 처리 배열?
		int[][] arr = new int[lines.length][];
        for (int i=0;i<lines.length;i++) {
        	String line = lines[i];
        	String[] info = line.split(" ");
        	String endTime = info[1];
        	String workTime = info[2];
        	
        	int eTime = processEndTime(endTime);
        	int time = processWorkTime(workTime);
        	int sTime = eTime-time+1;
        	arr[i] = new int[] {sTime,eTime};
        }
        
        maxCnt = -1;
        for (int i=0;i<arr.length;i++) {
        	int cnt = 0;
        	int base = arr[i][1];
        	for (int j=0;j<arr.length;j++) {
        		if (base<=arr[j][1]&&arr[j][1]<=base+999) cnt++;
        		else if (arr[j][0]<=base&&base+999<=arr[j][1]) cnt++;
        		else if (base<=arr[j][0]&&arr[j][0]<=base+999) cnt++;
        	}
        	maxCnt = Math.max(maxCnt, cnt);
        }
        return maxCnt;
    }
	
	static int processEndTime(String endTime) {
		StringTokenizer st = new StringTokenizer(endTime,":");
		int hour = Integer.parseInt(st.nextToken());
		int minute = Integer.parseInt(st.nextToken());
		String s = st.nextToken();
		st = new StringTokenizer(s,".");
		int second = Integer.parseInt(st.nextToken());
		int decimal = Integer.parseInt(st.nextToken());
		
		int arrNum = decimal + second *1000 + minute *60*1000 + hour *60*60*1000;
		
		return arrNum;
	}
	
	static int processWorkTime(String workTime) {
		StringTokenizer st = new StringTokenizer(workTime,"s");
		
		double time = Double.parseDouble(st.nextToken());
		
		return (int) (1000 * time);
	}
	
	
	public static void main(String[] args) {
		String[] lines = {"2016-09-15 01:00:04.001 2.0s",
				"2016-09-15 01:00:07.000 2s"};
		Solution sol = new Solution();
		System.out.println(sol.solution(lines));

		String[] lines2 = {"2016-09-15 01:00:04.002 2.0s",
				"2016-09-15 01:00:07.000 2s"};
		
		System.out.println(sol.solution(lines2));
		
		String[] lines3 = {"2016-09-15 20:59:57.421 0.351s",
				"2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s",
				"2016-09-15 20:59:58.688 1.041s",
				"2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s",
				"2016-09-15 21:00:00.741 1.581s",
				"2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s",
				"2016-09-15 21:00:02.066 2.62s"};
		
		System.out.println(sol.solution(lines3));
		
	}

}
