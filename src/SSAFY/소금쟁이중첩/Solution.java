package SSAFY.�ұ�������ø;

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
				
				bugPos[i] = new int[] {x,y,dir}; //1�� �ұ����̺��� ��ġ�� ������ bugPos�迭�� ����
			}
			
			outer:for (int i=0;i<bugNum;i++) { //1�� �ұ����̺��� ����
				int x = bugPos[i][0];
				int y = bugPos[i][1];
				int dir = bugPos[i][2];
				
				
				inner:for (int cnt=3;cnt>0;cnt--) {
					map[x][y] = true; // ���� �ٴ� �ڸ��� true�� ��ŷ
					switch (dir) { // ���� ����
					case 1:
						x += cnt; // �ٱ� Ƚ���� ���� �Ÿ� ����
						break;
					case 2:
						y += cnt;
						break;
					}
					if (x<N&&y<N) { // ������ ��ġ�� ���� ���ο� �ִٸ�
						if(!map[x][y]) { // ������ ��ġ�� �ƹ��� ��ŷ�� ���ߴٸ� ���� �ٱ� �ܰ��
							continue;
						} else { // ������ ��ġ�� �������� �̹� ��ŷ�� ��ġ��� �ش� �ұ������� ��ȣ �����ϰ� ������ �ߴ�
							ans = i+1;
							break outer;
						}
					} else { // �پ ���� �ٱ����� ���������ٸ� �ٱ� �ߴ�
						break inner;
					}
				}
				
			}
			
			System.out.printf("#%d %d%n",tc,ans);
			
		}

	}

}
