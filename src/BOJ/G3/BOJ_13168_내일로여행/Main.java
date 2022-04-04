package BOJ.G3.BOJ_13168_내일로여행;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	//내일로 구매시
	//무궁화호, 새마을, 청춘 -> 무료
	//S-Train, V-Train -> 50% 할인
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		HashMap<String, Integer> cityNo = new HashMap<>();
		int no = 0;
		while (st.hasMoreTokens()) {
			String city = st.nextToken();
			if (!cityNo.containsKey(city)) {
				cityNo.put(city, no++);
			}
		}
		
		int cityCnt = cityNo.size();
//		System.out.println(cityNo);
		double[][][] floyd = new double[cityCnt][cityCnt][2]; 
		
		for (int i=0;i<cityCnt;i++) {
			for (int j=0;j<cityCnt;j++) {
				for (int k=0;k<2;k++) {
					if (i==j) floyd[i][j][k] = 0;
					else floyd[i][j][k] = 1000000;
				}
			}
		}
		
		
		int M = Integer.parseInt(br.readLine());
		
		String[] targets = br.readLine().split(" ");
		
		int K = Integer.parseInt(br.readLine());
		
		for (int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			String type = st.nextToken();
			int cityA = cityNo.get(st.nextToken());
			int cityB = cityNo.get(st.nextToken());
			double fare = Double.parseDouble(st.nextToken());
			
			for (int j=0;j<2;j++) {
				floyd[cityA][cityB][j] = Math.min(calcFare(j,type,fare), floyd[cityA][cityB][j]);
				floyd[cityB][cityA][j] = Math.min(calcFare(j,type,fare), floyd[cityB][cityA][j]);
			}
		}
		
		
		for (int k=0;k<cityCnt;k++) {
			for (int a=0;a<cityCnt;a++) {
				for (int b=0;b<cityCnt;b++) {
						floyd[a][b][0] = Math.min(floyd[a][b][0], floyd[a][k][0]+floyd[k][b][0]);
						floyd[a][b][1] = Math.min(floyd[a][b][1], floyd[a][k][1]+floyd[k][b][1]);
				}
			}
		}
		
		
		double yesTicket = R;
		double noTicket = 0;
		
		for (int i=0;i<targets.length-1;i++) {
//			System.out.println(floyd[cityNo.get(targets[i])][cityNo.get(targets[i+1])][1]);
//			System.out.println(floyd[cityNo.get(targets[i])][cityNo.get(targets[i+1])][0]);
			
			yesTicket += floyd[cityNo.get(targets[i])][cityNo.get(targets[i+1])][1];
			noTicket += floyd[cityNo.get(targets[i])][cityNo.get(targets[i+1])][0];
		}
		
		if (yesTicket < noTicket) System.out.println("Yes");
		else System.out.println("No");
		
		
	}
	
	static double calcFare(int hasTicket, String type, double fare) {
		if (hasTicket==1) {
			if (type.equals("Mugunghwa")||type.equals("ITX-Cheongchun")||type.equals("ITX-Saemaeul"))
				return 0;
			if (type.equals("S-Train")||type.equals("V-Train"))
				return fare / 2;
			
			return fare;
		}
		
		return fare;
	}

}
