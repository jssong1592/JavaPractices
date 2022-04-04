package SWEA.D2.SWEA_2001_파리퇴치;

import java.io.*;
import java.util.*;

public class Solution {
	static int[][] map;
	
	static int countFlies(int startX,int startY, int M) {
		int flyCnt = 0;
		for (int i=startX;i<M+startX;i++) {
			for (int j=startY;j<M+startY;j++) {
				flyCnt += map[i][j];
			}
		}
		
		return flyCnt;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc=0;tc<T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			for (int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int maxFlyCnt = 0;
			for (int i=0;i<N-M+1;i++) {
				for (int j=0;j<N-M+1;j++) {
					int flyCnt = countFlies(i,j,M);
					if (maxFlyCnt < flyCnt) {
						maxFlyCnt = flyCnt;
					}
				}
			}
			
			System.out.printf("#%d %d%n",tc+1,maxFlyCnt);
			
		}

		
		
	}

}
