package BOJ.S1.BOJ_1148_단어만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] words = new int[200000][26];
		
		int cnt = 0;
		while (true) {
			String line = br.readLine();
			if (line.equals("-")) break;
			for (int i=0;i<line.length();i++) {
				words[cnt][line.charAt(i)-'A']++;
			}
			cnt++;
		}
		
		while(true) {
			TreeMap<Integer,TreeSet<String>> map = new TreeMap<>();
			String puzzle = br.readLine();
			if (puzzle.equals("#")) break;
			
			for (int i=0;i<puzzle.length();i++) {
				int sol = 0;
				int[] p = new int[26];
				for (int k=0;k<puzzle.length();k++) {
					p[puzzle.charAt(k)-'A']++;
				}
				for (int j=0;j<cnt;j++) {
					if (canMake(p,words[j])&&words[j][puzzle.charAt(i)-'A']>0){
						sol++;
					};
				}
				if (!map.containsKey(sol)) {
					map.put(sol, new TreeSet<>());
				}
				
				map.get(sol).add(puzzle.substring(i,i+1));
//				System.out.println(map);
			}
			
			StringBuilder sb = new StringBuilder();
			Entry<Integer,TreeSet<String>> minEntry = map.firstEntry();
			for (String s:minEntry.getValue()) {
				sb.append(s);
			}
			sb.append(" ").append(minEntry.getKey()).append(" ");
			Entry<Integer,TreeSet<String>> maxEntry = map.lastEntry();
			for (String s:maxEntry.getValue()) {
				sb.append(s);
			}
			sb.append(" ").append(maxEntry.getKey());
			System.out.println(sb.toString());
		}
		
		
	}
	static boolean canMake(int[] p, int[] word) {
		
		for (int i=0;i<26;i++) {
			if (p[i]<word[i]) return false;
		}
		return true;
	}

}
