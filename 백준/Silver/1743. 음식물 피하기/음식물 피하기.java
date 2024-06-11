import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static int n, m, k;
	static int answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r - 1][c - 1] = 1;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visited[i][j])
					continue;
				if (map[i][j] == 1) {
					bfs(i, j);
				}
			}
		}

		System.out.println(answer);
	}

	public static void bfs(int y, int x) {
		int size = 1;
		Queue<Position> q = new LinkedList<Position>();
		q.add(new Position(y, x));
		visited[y][x] = true;

		while (!q.isEmpty()) {
			Position current = q.remove();
			int cy = current.y;
			int cx = current.x;

			for (int i = 0; i < 4; i++) {
				int ny = cy + dy[i];
				int nx = cx + dx[i];

				if (ny < 0 || ny >= n || nx < 0 || nx >= m)
					continue;
				if (visited[ny][nx])
					continue;
				if (map[ny][nx] != 1)
					continue;

				visited[ny][nx] = true;
				size++;

				q.add(new Position(ny, nx));
			}
		}

		answer = Math.max(answer, size);
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
