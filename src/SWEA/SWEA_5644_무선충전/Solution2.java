package SWEA.SWEA_5644_��������;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution2 {

	static boolean[][][] map;
	static int[] dx = {0,-1,0,1,0};
	static int[] dy = {0,0,1,0,-1};

	
	static class Station {
		int x,y;
		int cover, perform;
		
		public Station(int x, int y, int cover, int perform) {
			super();
			this.x = x;
			this.y = y;
			this.cover = cover;
			this.perform = perform;
		}
	
	}

			
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1;tc<=T;tc++) {
			ArrayList<Station> list = new ArrayList<>(); //�����ҵ� ����
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int time = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			
			
			int[] A = {0,0};
			int[] B = {9,9};
			
			int[] dirA = new int[time];
			int[] dirB = new int[time];
			
			st = new StringTokenizer(br.readLine()," ");
			for (int i=0;i<time;i++) dirA[i] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine()," ");
			for (int i=0;i<time;i++) dirB[i] = Integer.parseInt(st.nextToken());
			
			//Station ���� �ޱ�
			for (int i=0;i<cnt;i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int cover = Integer.parseInt(st.nextToken());
				int perform = Integer.parseInt(st.nextToken());
				
				list.add(new Station(x-1,y-1,cover,perform));
			}
			
		
			int total = 0;//��
			
			//�� �ʸ��� A,B�� �ִ�� ���� �� �ִ� �������� ���
			for (int i=0;i<=time;i++) {
				//1.���� ������ ������ ã��(0��,1��,������, �ߺ��� ��)
				boolean[][] possible = new boolean[cnt][2];//����ں� ���� ������ ������ ǥ��
				for (int j = 0; j < cnt; j++) {
					Station s = list.get(j);
					if (Math.abs(s.x-A[0])+Math.abs(s.y-A[1])<=s.cover) {
						possible[j][0] = true;
					}
					if (Math.abs(s.x-B[0])+Math.abs(s.y-B[1])<=s.cover) {
						possible[j][1] = true;
					}
				}
				
				
				//2.���� ������ ������ �߿��� max ������ ã��
				int maxA = 0, maxB = 0;
				for (int j=0;j<cnt;j++) {
					Station s = list.get(j);
					if(possible[j][0]&&!possible[j][1]&&maxA<s.perform) {//A�� ����
						maxA = s.perform;
					}
					if(!possible[j][0]&&possible[j][1]&&maxB<s.perform) {//B�� ����
						maxB = s.perform;
					}
				}
				
				//2-2.A,B ���� ���ÿ� ���� ������ ���
				for (int j=0;j<cnt;j++) {
					Station s = list.get(j);
					if(possible[j][0]&&possible[j][1]) {//A,B �� ���� ����
						if(maxA<s.perform && maxA<=maxB) {
							maxA = s.perform;
						} else if (maxB<s.perform && maxB<maxA){
							maxB = s.perform;
						}
					}
						
				}
				
				//3.������ max���� ���ϱ� -> ����
				total += maxA + maxB;
				
				//4.���� �̵�
				if(i>=time) break;
				A[0] += dx[dirA[i]];
				A[1] += dy[dirA[i]];
				B[0] += dx[dirB[i]];
				B[1] += dy[dirB[i]];
			}
			
			System.out.printf("#%d %d\n",tc,total);
	
		}

	}
}