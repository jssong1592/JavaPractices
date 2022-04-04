package BOJ.G4.BOJ_17144_미세먼지안녕;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int R,C,T;
	static int[][] map;
	static int[][] map2;	
	static ArrayList<int[]> dyson;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		dyson = new ArrayList<int[]>();
		
		for (int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<C;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j]==-1) {
					dyson.add(new int[] {i,j});
				}
			}
		}
		
		for (int t=0;t<T;t++) {
			//미세먼지 확산 시키기
			map2 = new int[R][C];
			for (int x=0;x<R;x++) {
				for (int y=0;y<C;y++) {
					if (map[x][y]!=-1) {
						int curDust = map[x][y];
						int curDustPiece = curDust / 5;
						int sideDust = 0;
						for (int i=0;i<4;i++) {
							int nx = x + dx[i];
							int ny = y + dy[i];
							
							//각 방향에 대해 확산이 가능하면 주변에 먼지 5분의 1만큼 뿌리고, 옆에 있는 먼지 5분의 1 받기
							if (nx>=0&&nx<R&&ny>=0&&ny<C&&map[nx][ny]!=-1) {
								sideDust += (map[nx][ny] / 5);
								curDust -= curDustPiece;
							}
						}
						
						map2[x][y] = curDust + sideDust;
					}
				}
			}
			
			//미세먼지 이동 시키기
			//청정기 상부
			int[] up = dyson.get(0);
			int x = up[0];
			int y = up[1];
			//좌
			for (int i=x;i>0;i--) {
				map2[i][0] = map2[i-1][0];
			}
			//상
			for (int i=0;i<C-1;i++) {
				map2[0][i] = map2[0][i+1];
			}
			//우
			for (int i=0;i<x;i++) {
				map2[i][C-1] = map2[i+1][C-1];
			}
			//하
			for (int i=C-1;i>0;i--) {
				map2[x][i] = map2[x][i-1];
			}
			map2[x][y] = -1;
			map2[x][y+1] = 0;
			
			//청정기 하부
			int[] down = dyson.get(1);
			x = down[0];
			y = down[1];
			//좌
			for (int i=x;i<R-1;i++) {
				map2[i][0] = map2[i+1][0];
			}
			//하
			for (int i=0;i<C-1;i++) {
				map2[R-1][i] = map2[R-1][i+1];
			}
			//우
			for (int i=R-1;i>x;i--) {
				map2[i][C-1] = map2[i-1][C-1];
			}
			//상
			for (int i=C-1;i>0;i--) {
				map2[x][i] = map2[x][i-1];
			}
			map2[x][y] = -1;
			map2[x][y+1] = 0;
			
			//반복 Ready
			map = map2;
//			for (int i=0;i<R;i++) {
//				map[i] = Arrays.copyOf(map2[i], map2[i].length);
//			};
//			for (int i=0;i<R;i++) {
//				System.out.println(Arrays.toString(map[i]));
//			};
//			System.out.println();
			
		}
		
		//먼지 수 계산하기
		int total = 0;
		for (int i=0;i<R;i++) {
			for (int j=0;j<C;j++) {
				if (map[i][j]!=-1) total+=map[i][j];
			}
		}
		
		System.out.println(total);
	}

}
