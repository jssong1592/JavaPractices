package SWEA.SWEA_5644_무선충전;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static boolean[][][] map;
	static PriorityQueue<Charger>[][] power;
	static Charger[] chargers; 
	static int[] dx = {0,-1,0,1,0};
	static int[] dy = {0,0,1,0,-1};
	
	static class Charger {
		int no;
		int x;
		int y;
		int range;
		int power;
		boolean isOccupied = false;
		
		public Charger(int no, int x, int y, int range, int power) {
			this.no = no;
			this.x = x;
			this.y = y;
			this.range = range;
			this.power = power;
		}

	}
	
	static void putRange(Charger charger) {
		Queue<int[]> q = new LinkedList<>();
		
		q.offer(new int[] {charger.x,charger.y,0});
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			map[cur[0]][cur[1]][charger.no] = true;
			
			for (int i=1;i<5;i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if (nx>=0 && nx<10 && ny>=0 && ny<10 && cur[2]<charger.range) {
					q.offer(new int[] {nx,ny,cur[2]+1});
				}
			}
		}
		
		
	}
			
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1;tc<=T;tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			
			
			map = new boolean[10][10][A];
			power = new PriorityQueue[10][10];
			
			for (int i=0;i<10;i++) {
				for (int j=0;j<10;j++) {
					power[i][j] = new PriorityQueue<Charger>((o1,o2)->{
						Charger c1 = (Charger) o1;
						Charger c2 = (Charger) o2;
						return c2.power - c1.power; 
					});
				}
			}
			
			
			chargers = new Charger[A];
			
			String[] aMoves = br.readLine().split(" ");
			String[] bMoves = br.readLine().split(" ");
			
			for (int i=0;i<A;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int range = Integer.parseInt(st.nextToken());
				int power = Integer.parseInt(st.nextToken());
				
				chargers[i] = new Charger(i,y-1,x-1,range,power);
			}
			
			for (Charger c:chargers) {
				putRange(c);
			}
			
			for (int i=0;i<10;i++) {
				for (int j=0;j<10;j++) {
					for (int k=0;k<map[i][j].length;k++) {
						if (map[i][j][k]) {
							power[i][j].offer(chargers[k]);
							
						}
					}
				}
			}
			
			int[] aPos = {0,0};
			int[] bPos = {9,9};
			
			int total = 0;
			Charger aCharger = power[aPos[0]][aPos[1]].poll();
			Charger bCharger = power[bPos[0]][bPos[1]].poll();
			if (aCharger!=null&&bCharger!=null) {
				if (aCharger.no!=bCharger.no) {
					total += aCharger.power + bCharger.power;
				} else {
					total += aCharger.power;
				}
				power[aPos[0]][aPos[1]].offer(aCharger);
				power[bPos[0]][bPos[1]].offer(bCharger);
			} 
			else if (aCharger!=null&&bCharger==null) {
				total += aCharger.power;
				power[aPos[0]][aPos[1]].offer(aCharger);
			} else if (aCharger==null&&bCharger!=null) {
				total += bCharger.power;
				power[bPos[0]][bPos[1]].offer(bCharger);
			} 
			
			
			int move = 0;
			
			while (move<M) {
				
				aPos[0] += dx[Integer.parseInt(aMoves[move])];
				aPos[1] += dy[Integer.parseInt(aMoves[move])];
				
				bPos[0] += dx[Integer.parseInt(bMoves[move])];
				bPos[1] += dy[Integer.parseInt(bMoves[move])];
				
				aCharger = power[aPos[0]][aPos[1]].poll();
				bCharger = power[bPos[0]][bPos[1]].poll();
				if (aCharger!=null&&bCharger!=null) {
					if (aCharger.no!=bCharger.no) {
						total += aCharger.power + bCharger.power;
					} else {
						total += aCharger.power;
					}
					power[aPos[0]][aPos[1]].offer(aCharger);
					power[bPos[0]][bPos[1]].offer(bCharger);
				} 
				else if (aCharger!=null&&bCharger==null) {
					total += aCharger.power;
					power[aPos[0]][aPos[1]].offer(aCharger);
				} else if (aCharger==null&&bCharger!=null) {
					total += bCharger.power;
					power[bPos[0]][bPos[1]].offer(bCharger);
				} 
				
				move++;
			}
			
			System.out.printf("#%d %d\n",tc,total);
	
		}

	}

}
