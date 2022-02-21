package BOJ.G5.BOJ_1759_��ȣ�����;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
	static int L;
	static int C;
	static char[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new char[C];
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0;i<C;i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		//���� ����Ʈ�� �����ؼ� ���ڿ����� ������������ ���� �� �ְ� ó�� 
		Arrays.sort(arr);
		
		sb = new StringBuilder();
		
		pickLetter(0,0,0,0,new StringBuilder());
		
		System.out.println(sb);
	}

	static void pickLetter(int cnt, int start,int vowelCnt,int constCnt, StringBuilder temp) {
		//���ڿ��� ������ �����ϸ� �信 �ٿ��ְ� ��Ϳ��� ���ƿ���
		if (cnt==L&&vowelCnt>=1&&constCnt>=2) {
			sb.append(temp).append("\n");
			
			return;
		} 
		for (int i=start;i<C;i++) {
			//���� ���ĺ��� ����, ���������� ���� ���°� ��ȭ �ְ� ���� ���ڿ��� ���̱�
			if (arr[i]=='a'||arr[i]=='e'||arr[i]=='i'||arr[i]=='o'||arr[i]=='u') vowelCnt++;
			else constCnt++;
			
			temp.append(arr[i]);
			
			//������ ���� ���� ���ڿ��� �̵�
			pickLetter(cnt+1, i+1, vowelCnt, constCnt, temp);
			
			//��Ϳ��� ���ƿ� �� ���� ���ڸ� ���̱� ���� ���·� �ǵ��� �ֱ�
			if (arr[i]=='a'||arr[i]=='e'||arr[i]=='i'||arr[i]=='o'||arr[i]=='u') vowelCnt--;
			else constCnt--;
			temp.deleteCharAt(temp.length()-1);
		}
	}
}
