package BOJ.G4.BOJ_2239_스도쿠;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[][] sudoku;
	static int[][] ans;
	static boolean flag = false;
	static boolean blocked = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		sudoku = new int[9][9];
		ans = new int[9][9];
		for (int i = 0; i < 9; i++) {
			String line = br.readLine();
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = Integer.parseInt(line.substring(j, j + 1));
			}
		}

		attempt(0, 0);

		StringBuilder sb = new StringBuilder();
		for (int i=0;i<9;i++) {
			for (int j=0;j<9;j++) {
				sb.append(sudoku[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

	static void attempt(int i, int j) {
		if (j==9) {
			if (i<8) {
				attempt(i+1,0);
				if (blocked) return;
			}
			flag = true;
			return;
		}
		if (sudoku[i][j] == 0) {
			for (int k = 1; k <= 10; k++) {
				if (k == 10) {
					sudoku[i][j] = 0;
					blocked = true;
					return;
				}
					
				sudoku[i][j] = k;

				if (checkRow(i, j) && checkCol(i, j) && checkBlock(i, j)) {
					blocked = false;
					attempt(i,j+1);
					
					if (flag) return;
				}
			}
		} else {
			attempt(i,j+1);
		}
		

	}

	static boolean checkRow(int i, int j) {
		for (int k = 0; k < 9; k++) {
			if (k != j && sudoku[i][k] == sudoku[i][j])
				return false;
		}
		return true;
	}

	static boolean checkCol(int i, int j) {
		for (int k = 0; k < 9; k++) {
			if (k != i && sudoku[k][j] == sudoku[i][j])
				return false;
		}
		return true;
	}

	static boolean checkBlock(int i, int j) {
		int blockRow = blockNum(i);
		int blockCol = blockNum(j);

		for (int p = blockRow; p < blockRow + 3; p++) {
			for (int q = blockCol; q < blockCol + 3; q++) {
				if (!(i == p && j == q) && sudoku[p][q] == sudoku[i][j])
					return false;
			}
		}

		return true;
	}

	static int blockNum(int i) {
		switch (i) {
		case 0:
		case 1:
		case 2:
			return 0;
		case 3:
		case 4:
		case 5:
			return 3;
		case 6:
		case 7:
		case 8:
			return 6;
		default:
			return -1;
		}
	}
}