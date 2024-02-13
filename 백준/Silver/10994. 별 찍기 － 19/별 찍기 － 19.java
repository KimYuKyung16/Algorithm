import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static Character[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int len = 4 * n - 3;
		board = new Character[len][len];

		star(0, 0, len);

		for (int i = 0; i < board.length; i++) {
			String temp = "";
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == null) {
					temp += " ";
				} else {
					temp += board[i][j];
				}
			}
			System.out.println(temp);
		}
	}

	public static void star(int y, int x, int len) { // 시작 좌표 (좌, 상)
		if (len < 0) {
			return;
		}

		for (int i = 0; i < len; i++) {
			board[y][x] = '*';
			if (i == len - 1)
				continue;
			x++;
		}

		for (int i = 0; i < len; i++) {
			board[y][x] = '*';
			if (i == len - 1)
				continue;
			y++;
		}

		for (int i = 0; i < len; i++) {
			board[y][x] = '*';
			if (i == len - 1)
				continue;
			x--;
		}

		for (int i = 0; i < len; i++) {
			board[y][x] = '*';
			if (i == len - 1)
				continue;
			y--;
		}

		star(y + 2, x + 2, len - 4);
	}
}
