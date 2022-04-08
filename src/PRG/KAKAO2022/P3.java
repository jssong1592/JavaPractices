package PRG.KAKAO2022;

import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class P3 {

	public int[] solution(int[] fees, String[] records) {
		TreeMap<String,Integer> feeRecord = new TreeMap<>();
		HashMap<String,String> lastIn = new HashMap<>();
		for (String record:records) {
			StringTokenizer st = new StringTokenizer(record," ");
			String time = st.nextToken();
			String no = st.nextToken();
			String type = st.nextToken();
			
			if (type.equals("IN")) {
				lastIn.put(no, time);
				
			} else if (type.equals("OUT")) {
				String inTime = lastIn.get(no);
				int min = calcTime(inTime,time);
				if (!feeRecord.containsKey(no)) {
					feeRecord.put(no, min);
				} else {
					feeRecord.put(no, feeRecord.get(no)+min);
				}
				lastIn.remove(no);
			}
		}
		
		if (!lastIn.isEmpty()) {
			for (String no:lastIn.keySet()) {
				int min = calcTime(lastIn.get(no),"23:59");
				if (!feeRecord.containsKey(no)) {
					feeRecord.put(no, min);
				} else {
					feeRecord.put(no, feeRecord.get(no)+min);
				}
			}
		}
//		System.out.println(feeRecord);
		
        int[] answer = new int[feeRecord.size()];
        int i = 0;
        for (String no:feeRecord.keySet()) {
        	int min = feeRecord.get(no);
        	if (min<=fees[0]) {
        		answer[i] = fees[1];
        	} else {
        	int extra = (min-fees[0])%fees[2]>0?1:0;
        	answer[i] = fees[1] + ((min-fees[0]) / fees[2] + extra) * fees[3];
        	}
        	i++;
        }
        
        return answer;
    }
	
	static int calcTime(String inTime, String outTime) {
		int result = 0;
		
		StringTokenizer st = new StringTokenizer(outTime,":");
		int outHour = Integer.parseInt(st.nextToken());
		int outMin = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(inTime,":");
		int inHour = Integer.parseInt(st.nextToken());
		int inMin = Integer.parseInt(st.nextToken());
		
		if (outMin >= inMin) {
			result += outMin-inMin;
		} else {
			outHour--;
			result += outMin+60-inMin;
		}
		
		result += 60*(outHour-inHour);
		
		return result;
	}

	
	public static void main(String[] args) {

		P3 sol = new P3();
		int[] fees = {180, 5000, 10, 600};
		String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		
		int[] result = sol.solution(fees, records);
		
		System.out.println(Arrays.toString(result));
		
		fees = new int[] {120, 0, 60, 591};
		records =new String[]{"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};
		result = sol.solution(fees, records);
		System.out.println(Arrays.toString(result));
		
		fees = new int[] {1, 461, 1, 10};
		records =new String[]{"00:00 1234 IN"};
		result = sol.solution(fees, records);
		System.out.println(Arrays.toString(result));
	}
}
