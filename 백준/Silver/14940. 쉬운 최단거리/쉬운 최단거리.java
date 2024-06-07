import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m;
	static int[][] map;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static Queue<Position> q = new LinkedList<Position>();;
	static int[][] visited;
	static Position start;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 세로
		m = Integer.parseInt(st.nextToken()); // 가로
		map = new int[n][m];
		visited = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 2) {
					q.add(new Position(i, j));
					start = new Position(i, j);
					map[i][j] = 0;
				} else if (map[i][j] == 1) {
					map[i][j] = 10000;
				}
			}
		}

		bfs();
		no();
		print();
	}

	public static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void no() {
		int sy = start.y;
		int sx = start.x;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 10000) {
					map[i][j] = -1;
				}
			}
		}
	}

	public static void bfs() {
		while (!q.isEmpty()) {
			Position current = q.remove();
			int cy = current.y;
			int cx = current.x;

			for (int i = 0; i < 4; i++) {
				int ny = cy + dy[i];
				int nx = cx + dx[i];

				if (ny < 0 || ny >= n || nx < 0 || nx >= m)
					continue;
				if (map[ny][nx] == 0)
					continue;
				if (visited[ny][nx] == 1)
					continue;
				visited[ny][nx] = 1;
				map[ny][nx] = map[cy][cx] + 1;
				q.add(new Position(ny, nx));
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
