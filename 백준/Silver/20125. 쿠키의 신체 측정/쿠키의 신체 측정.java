import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static char[][] board;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		board = new char[n][n];

		int hy = 0;
		int hx = 0;

		for (int i = 0; i < n; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < n; j++) {
				board[i][j] = tmp.charAt(j);
			}
		}
		boolean flag = false;
		for (int i = 0; i < n; i++) {
			if (flag)
				break;
			for (int j = 0; j < n; j++) {
				if (board[i][j] == '*') {
					hy = i;
					hx = j;
					flag = true;
					break;
				}
			}
		}

		System.out.println((hy + 2) + " " + (hx + 1));

		int left_hand_cnt = 0;
		for (int x = hx - 1; x >= 0; x--) {
			if (board[hy + 1][x] == '*') {
				left_hand_cnt++;
			} else {
				break;
			}
		}

		int right_hand_cnt = 0;
		for (int x = hx + 1; x < n; x++) {
			if (board[hy + 1][x] == '*') {
				right_hand_cnt++;
			} else {
				break;
			}
		}

		int middle = 0;
		int y = hy + 2;
		while (true) {
			if (board[y][hx] == '*') {
				middle++;
				y++;
				continue;
			} else {
				break;
			}
		}
		y++;

		int left_leg_cnt = 1;
		int right_leg_cnt = 1;

		int ly = y;
		int lx = hx - 1;
		int ry = y;
		int rx = hx + 1;

		while (true) {
			if (ly >= n) {
				break;
			}
			if (board[ly][lx] == '*') {
				left_leg_cnt++;
				ly++;
			} else {
				break;
			}
		}

		while (true) {
			if (ry >= n) {
				break;
			}
			if (board[ry][rx] == '*') {
				right_leg_cnt++;
				ry++;
			} else {
				break;
			}
		}

		System.out.println(left_hand_cnt + " " + right_hand_cnt + " " + middle + " " + left_leg_cnt + " " + right_leg_cnt);

	}
}
