import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br;
	static String[][] board;
	static int n;
	static int[] dy = { 0, 1 };
	static int[] dx = { 1, 0 };
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		board = new String[n][n];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				board[i][j] = str.substring(j, j + 1);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int dir = 0; dir < 2; dir++) {
					change(i, j, dir);
					eat();
					change(i, j, dir);
				}
			}
		}

		System.out.println(answer);
	}

	public static void change(int y, int x, int direction) {
		int ny = y + dy[direction];
		int nx = x + dx[direction];

		if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
			return;
		}

		String temp = board[y][x];
		board[y][x] = board[ny][nx];
		board[ny][nx] = temp;

	}

	public static void eat() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				eating(board[i][j], i, j, 0, 1);
				eating(board[i][j], i, j, 1, 1);
			}
		}
	}

	public static void eating(String current, int y, int x, int direction, int count) {
		int ny = y + dy[direction];
		int nx = x + dx[direction];

		if (ny < 0 || ny >= n || nx < 0 || nx >= n || !current.equals(board[ny][nx])) {
			answer = Math.max(answer, count);
			return;
		}

		eating(current, ny, nx, direction, count + 1);
	}
}
