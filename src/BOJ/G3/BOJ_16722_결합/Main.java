package BOJ.G3.BOJ_16722_결합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static String[][] arr;
	static HashMap<int[],Boolean> hap;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new String[10][3]; 
		
		for (int i=1;i<=9;i++) {
			arr[i] = br.readLine().split(" ");
		}
		
		hap = new HashMap<>();
		makeHap();
		
		boolean G = false;
		int hapCnt = hap.size();
		int point = 0;
		int n = Integer.parseInt(br.readLine());
		for (int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String type = st.nextToken();
			if (type.equals("H")) {
				int[] combi = new int[3];
				for (int j=0;j<3;j++) {
					combi[j] = Integer.parseInt(st.nextToken());
				}
				Arrays.sort(combi);
				
				if (checkHap(combi)) {
					int[] c = getKey(combi);
					if (!hap.get(c)) {
						point++;
						hap.put(c,true);
						hapCnt--;
					} else {
						point--;
					}
				} else {
					point--;
				}
			}
			else {
				if (hapCnt==0&&!G) {
					point += 3;
					G = true;
				} else {
					point--;
				}
			}
		}
		
		System.out.println(point);
	}
	
	static int[] getKey(int[] combi) {
		int[] result = null;
		for (int[] key:hap.keySet()) {
			boolean flag = true;
			for (int i=0;i<3;i++) {
				if (key[i]!=combi[i]) flag = false;
			}
			if (flag) return key;
		}
		return result;
	}
	
	static void makeHap() {
		for (int i=1;i<=7;i++) {
			for (int j=i+1;j<=8;j++) {
				for (int k=j+1;k<=9;k++) {
					int[] combi = new int[] {i,j,k};
					if (checkHap(combi)) hap.put(combi, false);
				}
			}
		}
	}
	
	static boolean checkHap(int[] combi) {
		if (!checkShape(combi)) return false;
		if (!checkColor(combi)) return false;
		if (!checkBack(combi)) return false;
		return true;
	}
	
	static boolean checkShape(int[] combi) {
		int CIRCLE = 0;
		int TRIANGLE = 0;
		int SQUARE = 0;
		for (int i=0;i<3;i++) {
			if (arr[combi[i]][0].equals("CIRCLE")) CIRCLE++;
			else if (arr[combi[i]][0].equals("SQUARE")) SQUARE++;
			else if (arr[combi[i]][0].equals("TRIANGLE")) TRIANGLE++;
		}
		
		if (CIRCLE==2||TRIANGLE==2||SQUARE==2) return false;
		return true;
	}
	
	static boolean checkColor(int[] combi) {
		int YELLOW = 0;
		int RED = 0;
		int BLUE = 0;
		for (int i=0;i<3;i++) {
			if (arr[combi[i]][1].equals("YELLOW")) YELLOW++;
			else if (arr[combi[i]][1].equals("RED")) RED++;
			else if (arr[combi[i]][1].equals("BLUE")) BLUE++;
		}
		
		if (YELLOW==2||RED==2||BLUE==2) return false;
		return true;
	}
	
	static boolean checkBack(int[] combi) {
		int GRAY = 0;
		int WHITE = 0;
		int BLACK = 0;
		for (int i=0;i<3;i++) {
			if (arr[combi[i]][2].equals("GRAY")) GRAY++;
			else if (arr[combi[i]][2].equals("WHITE")) WHITE++;
			else if (arr[combi[i]][2].equals("BLACK")) BLACK++;
		}
		
		if (GRAY==2||WHITE==2||BLACK==2) return false;
		return true;
	}
}
