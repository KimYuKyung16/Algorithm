import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map;
	static int[][] m;
	static int n;
	static int[] dy = { 0, 1, 1 }; // 가로, 세로, 대각선
	static int[] dx = { 1, 0, 1 };
	static int answer = 0;

	// 가로: 0, 세로: 1, 대각선: 2
	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int current = Integer.parseInt(st.nextToken());
				map[i][j] = current;
			}
		}

		move(0, 1, 0);

		System.out.println(answer);
	}

	// dir --> 가로: 0, 세로: 1, 대각선: 2
	public static void move(int y, int x, int dir) {
		if (y == n - 1 && x == n - 1) {
			answer++;
			return;
		}

		if (dir == 0) { // 가로 방향
			for (int i = 0; i < 3; i++) {
				if (i == 1)
					continue;
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (ny < 0 || ny >= n || nx < 0 || nx >= n)
					continue;
				if (map[ny][nx] == 1)
					continue;
				if (i == 2 && !diagonal(y, x)) {
					continue;
				}

				move(ny, nx, i);
			}
		} else if (dir == 1) { // 세로 방향
			for (int i = 0; i < 3; i++) {
				if (i == 0)
					continue;
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (ny < 0 || ny >= n || nx < 0 || nx >= n)
					continue;
				if (map[ny][nx] == 1)
					continue;
				if (i == 2 && !diagonal(y, x))
					continue;

				move(ny, nx, i);
			}
		} else if (dir == 2) { // 대각선 방향
			for (int i = 0; i < 3; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (ny < 0 || ny >= n || nx < 0 || nx >= n)
					continue;
				if (map[ny][nx] == 1)
					continue;
				if (i == 2 && !diagonal(y, x))
					continue;

				move(ny, nx, i);
			}
		}
	}

	// 대각선일 경우
	public static boolean diagonal(int y, int x) {
		if (map[y + 1][x] == 1 || map[y][x + 1] == 1) {
			return false;
		} else {
			return true;
		}
	}
}
