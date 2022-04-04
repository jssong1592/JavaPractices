package BOJ.B2.BOJ_3040_백설공주와일곱난쟁이;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] dwarf = new int[9];
		
		for (int i=0;i<9;i++) {
			dwarf[i] = sc.nextInt();
		}

		outer:for (int i=(1<<1);i<(2<<8);i<<=1) {
			for (int j=(1<<0);j<i;j<<=1) {
				int total = 0;
				ArrayList<Integer> list = new ArrayList<>();
				int bit = (2<<8)-1-i-j;
				for (int k=0;k<9;k++) {
					if ((bit&(1<<k))!=0) {
						list.add(dwarf[k]);
						total += dwarf[k];
					}
				}
				
				if (total == 100&&list.size()==7) {
					for (Integer d:list) {
						System.out.println(d);
					}
					break outer;
				}
			}
		}
		
		
		
	}

}
