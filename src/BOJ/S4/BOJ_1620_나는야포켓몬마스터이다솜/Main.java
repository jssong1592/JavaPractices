package BOJ.S4.BOJ_1620_나는야포켓몬마스터이다솜;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<Integer,String> NumName = new HashMap<>();
		HashMap<String,Integer> NameNum = new HashMap<>();
		
		for (int i=1;i<=N;i++) {
			String monster = br.readLine();
			NumName.put(i, monster);
			NameNum.put(monster.toLowerCase(), i);
		}
		
		for (int i=0;i<M;i++) {
			String problem = br.readLine();
			if (problem.charAt(0)>='0'&&problem.charAt(0)<='9') {
				System.out.println(NumName.get(Integer.parseInt(problem)));
			} else {
				System.out.println(NameNum.get(problem.toLowerCase()));
			}
		}
	}

}
