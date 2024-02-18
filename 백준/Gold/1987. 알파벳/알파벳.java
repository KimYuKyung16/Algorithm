import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int r, c;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static char[][] board;
	static int[][] visited;
	static int[] alpha_visited = new int[26];
	static int answer;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		board = new char[r][c];
		visited = new int[r][c];

		for (int i = 0; i < r; i++) {
			String temp = br.readLine();
			for (int j = 0; j < c; j++) {
				board[i][j] = temp.charAt(j);
			}
		}

		dfs(0, 0, 0);

		System.out.println(answer);
	}

	public static void dfs(int y, int x, int count) {
		if (y < 0 || y >= r || x < 0 || x >= c) {
			answer = Math.max(answer, count);
			return;
		}

		if (alpha_visited[(int) board[y][x] - 65] > 0) {
			answer = Math.max(answer, count);
			return;
		}
		if (visited[y][x] == 1) {
			answer = Math.max(answer, count);
			return;
		}

		count++;
		visited[y][x] = 1;
		alpha_visited[(int) board[y][x] - 65] = 1;

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (ny < 0 || ny >= r || nx < 0 || nx >= c) {
				answer = Math.max(answer, count);
				continue;
			}
			dfs(ny, nx, count);
		}
		visited[y][x] = 0;
		alpha_visited[(int) board[y][x] - 65] = 0;
	}
}
