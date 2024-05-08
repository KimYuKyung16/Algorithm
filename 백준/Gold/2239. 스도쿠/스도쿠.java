import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] board = new int[9][9];
	static Position start;
	static int zero_cnt = 0;
	static int temp = 0;

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 9; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < 9; j++) {
				board[i][j] = tmp.charAt(j) - '0';
				if (board[i][j] == 0) {
					zero_cnt++;
				}
				if (board[i][j] == 0 && start == null) {
					start = new Position(i, j);
				}
			}
		}

		dfs(0);
	}

	public static void dfs(int depth) {
		if (zero_cnt == depth) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(board[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == 0) {
					// 가능한 경우
					for (int k = 1; k <= 9; k++) {
						if (confirm_row(k, i) && confirm_col(k, j) && confirm_nine(k, i, j)) {
							board[i][j] = k;
							dfs(depth + 1);
							board[i][j] = 0;
						} else {
							continue;
						}
					}

					return;
				}
			}
		}
	}

	// 가로 비교
	public static boolean confirm_row(int num, int y) {
		for (int x = 0; x < 9; x++) {
			if (board[y][x] == num) {
				return false;
			}
		}
		return true;
	}

	// 세로 비교
	public static boolean confirm_col(int num, int x) {
		for (int y = 0; y < 9; y++) {
			if (board[y][x] == num) {
				return false;
			}
		}
		return true;
	}

	// 9칸 비교
	public static boolean confirm_nine(int num, int y, int x) {
		int starty = (y / 3) * 3;
		int startx = (x / 3) * 3;

		for (int ny = starty; ny < starty + 3; ny++) {
			for (int nx = startx; nx < startx + 3; nx++) {
				if (board[ny][nx] == num) {
					return false;
				}
			}
		}
		return true;
	}

	public static class Position {
		int y;
		int x;

		public Position(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
