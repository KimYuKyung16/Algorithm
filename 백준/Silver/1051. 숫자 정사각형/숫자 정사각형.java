import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int[][] board;
	static int answer = 1;
	static int n, m;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		board = new int[n][m];

		for (int i = 0; i < n; i++) {
			String arr = br.readLine();
			for (int j = 0; j < m; j++) {
				board[i][j] = arr.charAt(j) - '0';
			}
		}

		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < m; j++) {
				for (int k = j + 1; k < m; k++) {
					if (board[i][k] == board[i][j]) {
						int width = k - j; // 너비
						answer = Math.max(answer, find(i, j, width));
					}
				}
			}
		}

		System.out.println(answer);
	}

	public static int find(int y, int x, int width) {
		if (y + width >= n || x + width >= m)
			return 1;
		if (board[y + width][x] != board[y][x])
			return 1;
		if (board[y + width][x + width] != board[y][x])
			return 1;

		return (width + 1) * (width + 1);
	}
}
