import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map;
	static boolean[] dessert;
	static boolean[][] visited;
	static int[] dy = { 1, 1, -1, -1 };
	static int[] dx = { 1, -1, -1, 1 };
	static int answer = -1;
	static int n;

	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			visited = new boolean[n][n];
			dessert = new boolean[101];
			answer = -1;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					visited[i][j] = true;
					dessert[map[i][j]] = true;
					dfs(i, j, i, j, 0, 1);
					visited[i][j] = false;
					dessert[map[i][j]] = false;
				}
			}

			System.out.printf("#%d %d\n", tc, answer);

		}
	}

	public static void dfs(int y, int x, int sy, int sx, int d, int cnt) {
		for (int i = d; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (ny < 0 || ny >= n || nx < 0 || nx >= n)
				continue;
			if (cnt > 2 && ny == sy && nx == sx) {
				answer = Math.max(answer, cnt);
				return;
			}
			if (visited[ny][nx])
				continue;
			if (dessert[map[ny][nx]])
				continue;

			visited[ny][nx] = true;
			dessert[map[ny][nx]] = true;
			dfs(ny, nx, sy, sx, i, cnt + 1);
			visited[ny][nx] = false;
			dessert[map[ny][nx]] = false;
		}
	}
}
