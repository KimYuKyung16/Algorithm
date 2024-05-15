import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m;
	static int[][] map;
	static int[][] nMap;
	static ArrayList<Position> virus = new ArrayList<Position>();
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static int answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		nMap = new int[n][m];

		for (int y = 0; y < n; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < m; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());

				if (map[y][x] == 2) {
					virus.add(new Position(y, x));
				}
			}
		}

		for (int y = 0; y < n; y++) {
			for (int x = 0; x < m; x++) {
				if (map[y][x] == 0) {
					copy_map();

					map[y][x] = 1;
					dfs(1);
					map[y][x] = 0;
				}
			}
		}

		System.out.println(answer);
	}

	public static void dfs(int cnt) {
		if (cnt == 3) {
			copy_map();
			bfs();
			return;
		}

		for (int y = 0; y < n; y++) {
			for (int x = 0; x < m; x++) {
				if (map[y][x] == 0) {
					map[y][x] = 1;
					dfs(cnt + 1);
					map[y][x] = 0;
				}
			}
		}
	}

	public static void bfs() {
		Queue<Position> q = new LinkedList<Position>();
		boolean[][] visited = new boolean[n][m];

		for (int i = 0; i < virus.size(); i++) {
			q.add(virus.get(i));
		}

		while (!q.isEmpty()) {
			Position current = q.remove();
			int y = current.y;
			int x = current.x;

			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];

				if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
					continue;
				}
				if (nMap[ny][nx] == 1 || nMap[ny][nx] == 2) {
					continue;
				}
				if (visited[ny][nx]) {
					continue;
				}

				nMap[ny][nx] = 2;
				visited[ny][nx] = true;
				q.add(new Position(ny, nx));
			}
		}

		confirm();
	}

	public static void confirm() {
		int cnt = 0;

		for (int y = 0; y < n; y++) {
			for (int x = 0; x < m; x++) {
				if (nMap[y][x] == 0) {
					cnt++;
				}
			}
		}

		answer = Math.max(answer, cnt);
	}

	public static void copy_map() {
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < m; x++) {
				nMap[y][x] = map[y][x];
			}
		}
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
