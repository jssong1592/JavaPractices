package SWEA.D3.SWEA_1873_상호의배틀필드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	
	public static String[][] map;
	public static int[] curPosition = {0,0,0};
	
	
	public static void setPos(int x, int y, String dir) {
		curPosition[0] = x;
		curPosition[1] = y;
		switch (dir) {
		case "^" : curPosition[2] = 0; break;
		case "v" : curPosition[2] = 1; break;
		case "<" : curPosition[2] = 2; break;
		case ">" : curPosition[2] = 3; break;
		default : break;
		}
		
	}
	
	public static void shoot() {
		int nx = curPosition[0] + dx[curPosition[2]];
		int ny = curPosition[1] + dy[curPosition[2]];
		
		while (nx>=0&&nx<map.length&&ny>=0&&ny<map[nx].length) {
			if (map[nx][ny].equals("*")) {
				map[nx][ny] = ".";
				break;
			} else if (map[nx][ny].equals("#")) {
				break;
			}
			nx += dx[curPosition[2]];
			ny += dy[curPosition[2]];
		}
	}
	
	public static void move(String s) {
		int nx = 0, ny = 0;
		
		switch (s) {
		case "U":
			map[curPosition[0]][curPosition[1]] = "^";
			curPosition[2] = 0;
			
			nx = curPosition[0] + dx[0];
			ny = curPosition[1] + dy[0];
			
			break;
			
		case "D":
			map[curPosition[0]][curPosition[1]] = "v";
			curPosition[2] = 1;
			
			nx = curPosition[0] + dx[1];
			ny = curPosition[1] + dy[1];
		
			break;
			
		case "L":
			map[curPosition[0]][curPosition[1]] = "<";
			curPosition[2] = 2;
			
			nx = curPosition[0] + dx[2];
			ny = curPosition[1] + dy[2];
			
			break;
			
		case "R":
			map[curPosition[0]][curPosition[1]] = ">";
			curPosition[2] = 3;
			
			nx = curPosition[0] + dx[3];
			ny = curPosition[1] + dy[3];
			
			break;
			
		default: break;
		}
		
		if (nx>=0&&nx<map.length&&ny>=0&&ny<map[nx].length&&map[nx][ny].equals(".")) {
			map[nx][ny] = map[curPosition[0]][curPosition[1]];
			map[curPosition[0]][curPosition[1]] = ".";
			curPosition[0] = nx;
			curPosition[1] = ny;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=0;tc<T;tc++) {
			String[] info = br.readLine().split(" ");
			int x = Integer.parseInt(info[0]);
			int y = Integer.parseInt(info[1]);
			
			map = new String[x][];
			
			for (int i=0;i<x;i++) {
				map[i] = br.readLine().split("");
				for (int j=0;j<y;j++) {
					if (map[i][j].equals("^")||map[i][j].equals("v")||
							map[i][j].equals("<")||map[i][j].equals(">")) 
					setPos(i,j,map[i][j]);
				}
			}
			
			int cnt = Integer.parseInt(br.readLine());
			String[] cmd = br.readLine().split("");
			
			for (String s:cmd) {
				switch (s) {
				case "U":
				case "D":
				case "L":
				case "R":
					move(s);
					break;
				case "S":
					shoot();
					break;
				default:
					break;
				}
				
			}
			
			System.out.printf("#%d ",tc+1);
			for (int i=0;i<map.length;i++) {
				for(int j=0;j<map[i].length;j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}

	}

}
