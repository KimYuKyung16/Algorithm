import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int R, C;
	static int sheep, wolf;
	static int total_sheep, total_wolf;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];

		for (int r = 0; r < R; r++) {
			String tmp = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = tmp.charAt(c);
			}
		}

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (visited[r][c])
					continue;

				if (map[r][c] != '#') {
					sheep = 0;
					wolf = 0;
					if (map[r][c] == 'v') {
						wolf++;
					} else if (map[r][c] == 'o') {
						sheep++;
					}
					visited[r][c] = true;
					bfs(r, c);
				}
			}
		}

		System.out.println(total_sheep + " " + total_wolf);
	}

	public static void bfs(int r, int c) {
		Queue<Position> q = new LinkedList<Position>();
		q.add(new Position(r, c));

		while (!q.isEmpty()) {
			Position current = q.remove();
			int cr = current.r;
			int cc = current.c;

			for (int i = 0; i < 4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];

				if (nr < 0 || nr >= R || nc < 0 || nc >= C)
					continue;
				if (visited[nr][nc])
					continue;
				if (map[nr][nc] == '#')
					continue;

				if (map[nr][nc] == 'o') {
					sheep++;
				} else if (map[nr][nc] == 'v') {
					wolf++;
				}

				visited[nr][nc] = true;
				q.add(new Position(nr, nc));

			}
		}

		if (sheep > wolf) {
			total_sheep += sheep;
		} else {
			total_wolf += wolf;
		}
	}

	public static class Position {
		int r;
		int c;

		public Position(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
