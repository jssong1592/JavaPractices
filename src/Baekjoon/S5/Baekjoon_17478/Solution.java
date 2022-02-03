package Baekjoon.S5.Baekjoon_17478;

import java.util.Scanner;

public class Solution {
	
	public static void recursion(int n, int cnt) {
		StringBuilder sb = new StringBuilder();
		
		for (int i=0;i<cnt;i++) {
			sb.append("____");
		}
		
		System.out.println(sb+"\"����Լ��� ������?\"");
		
		if (n==cnt) {
			System.out.println(sb+"\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"");
		
		} else {
			System.out.println(sb+"\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.");
			System.out.println(sb+"���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.");
			System.out.println(sb+"���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"");
			recursion(n,cnt+1);
		}
		System.out.println(sb+"��� �亯�Ͽ���.");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.");
		recursion(N,0);

	}

}
