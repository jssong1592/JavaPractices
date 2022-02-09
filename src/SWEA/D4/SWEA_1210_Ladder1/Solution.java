package SWEA.D4.SWEA_1210_Ladder1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] moveVertical(int[] curPos, int[][] data) {
		int y = curPos[0];
		int x = curPos[1];
		while (true) {
			y--;
			if (y==0) break;
			else if ((x-1>=0&&data[y][x-1]==1)||(x+1<=99&&data[y][x+1]==1)) break;
		}
		return new int[] {y,x};
	}
	
	static int[] moveLeft(int[] curPos, int[][] data) {
		int y = curPos[0];
		int x = curPos[1]-1;
		while (data[y-1][x]!=1) {
			x--;
		}
		return new int[] {y,x};
	}
	
	static int[] moveRight(int[] curPos, int[][] data) {
		int y = curPos[0];
		int x = curPos[1]+1;
		while (data[y-1][x]!=1) {
			x++;
		}
		return new int[] {y,x};
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t=0;t<10;t++) {
			int[][] data = new int[100][100];
			
			int tc = Integer.parseInt(br.readLine());
			
	
			for (int i=0;i<100;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for (int j=0;j<100;j++) {
					
					data[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int startX = -1;
			int startY = 99;
			
			for (int i=0;i<100;i++) {
				if (data[startY][i]==2) startX = i;
			}
			
			int[] curPos = new int[] {startY,startX};

			while (curPos[0]!=0) {

				curPos = moveVertical(curPos,data);
				
				if (curPos[1]+1<=99&&data[curPos[0]][curPos[1]+1]==1) {

					curPos = moveRight(curPos,data);
				} else if (curPos[1]-1>=0&&data[curPos[0]][curPos[1]-1]==1) {

					curPos = moveLeft(curPos,data);
				}
				
			}
			
			System.out.printf("#%d %d%n",tc,curPos[1]);
			
		}

	}

}
