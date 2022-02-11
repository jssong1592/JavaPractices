package SSAFY.소금쟁이중첩;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int bugNum = Integer.parseInt(st.nextToken());
			
			boolean[][] map = new boolean[N][N];
			int[][] bugPos = new int[bugNum][];
			int ans = 0;
			
			for (int i=0;i<bugNum;i++) {
				st = new StringTokenizer(br.readLine()," ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				
				bugPos[i] = new int[] {x,y,dir}; //1번 소금쟁이부터 위치와 방향을 bugPos배열에 저장
			}
			
			outer:for (int i=0;i<bugNum;i++) { //1번 소금쟁이부터 시작
				int x = bugPos[i][0];
				int y = bugPos[i][1];
				int dir = bugPos[i][2];
				
				
				inner:for (int cnt=3;cnt>0;cnt--) {
					 
					switch (dir) { // 방향 설정
					case 1:
						x += cnt; // 뛰기 횟수에 따라 거리 설정
						break;
					case 2:
						y += cnt;
						break;
					}
					if (x<N&&y<N) { // 도착할 위치가 연못 내부에 있다면
						if(!map[x][y]) { // 도착한 위치에 아무도 마킹을 안했다면
							map[x][y] = true; // 도착한 위치를 true로 마킹 
							continue;
						} else { // 도착한 위치가 누군가가 이미 마킹한 위치라면 해당 소금쟁이의 번호 저장하고 완전히 중단
							ans = i+1;
							break outer;
						}
					} else { // 뛰어서 연못 바깥으로 빠져나간다면 뛰기 중단
						break inner;
					}
				}
				
			}
			
			System.out.printf("#%d %d%n",tc,ans);
			
		}

	}

}
