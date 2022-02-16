package SWEA.D3.SWEA_6808_�Կ��̿��ο�����ī�����;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] gyu = new int[9];
			int[] in = new int[9];
			int gyuWin = 0;
			int gyuLose = 0;
			ArrayList<Integer> in_temp = new ArrayList<>();
			
			for (int i=1;i<=18;i++) {
				in_temp.add(i);
			}
			
			for (int i=0;i<9;i++) {
				int now = Integer.parseInt(st.nextToken());
				gyu[i] = now;
				in_temp.remove(Integer.valueOf(now));
			}
			
			for (int i=0;i<9;i++) {
				in[i] = in_temp.get(i);
			}
			
			
			do { //NextPermutation ����Ͽ� ��� ������ ���Ͽ� ���� ����
				int gyuScore = 0;
				int inScore = 0;
				for (int i=0;i<9;i++) {
					if (gyu[i]>in[i]) gyuScore += gyu[i] + in[i];
					else inScore += gyu[i] + in[i];
				}
				if (gyuScore>inScore) gyuWin++;
				else gyuLose++;
			} while (np(in));
			
			System.out.printf("#%d %d %d\n",tc,gyuWin,gyuLose);
			
		}
	}
	
	static boolean np(int[] in) {
		//�� ������ ����� ��ġ Ȯ��
		int i = 8;
		while (i>0&&in[i-1]>=in[i]) i--;
		
		//����Ⱑ �� ��(��� ���Ұ� �������� ����)�̸� NP ��
		if (i==0) return false;
		
		//����� �ٷ� �� ������ ū ���� �ִ��� �ǳ����� Ȯ��
		int j = 8;
		while (in[i-1]>=in[j]) j--;
		
		//����� �ٷ� �� ���� �ش� �� ����
		swap(i-1,j,in);
		
		//�������� �ǳ����� ���� ���� ������������ �����ϱ�
		int k = 8;
		while(i<k) swap(i++,k--,in);
		
		return true;
	}
	
	static void swap(int i, int j, int[] in) {
		int temp = in[i];
		in[i] = in[j];
		in[j] = temp;
	}
}
