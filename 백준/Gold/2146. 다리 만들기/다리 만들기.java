import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 주변에 0이 하나라도 있으면 제일 바깥쪽에 있다는 의미
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map;
	static int[][] nMap;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static int n;
	static ArrayList<Integer> complete = new ArrayList<Integer>();
	static ArrayList<Position> edges = new ArrayList<>();
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		nMap = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				int cur = Integer.parseInt(st.nextToken());
				map[i][j] = cur;
			}
		}

		int cnt = 101;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1) {
					island_naming(i, j, cnt);
					cnt++;
				}
			}
		}

		for (int i = 0; i < edges.size(); i++) {
			int y = edges.get(i).y;
			int x = edges.get(i).x;

			set_bridge(y, x, map[y][x]);
		}

		System.out.println(answer);
	}

	public static void copy_map() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				nMap[i][j] = map[i][j];
			}
		}
	}

	// current는 현재 출발한 섬 이름
	public static void set_bridge(int y, int x, int current) {
		Queue<Position> q = new LinkedList<Position>();
		q.add(new Position(y, x));
		copy_map();
		boolean[][] visited = new boolean[n][n];

		while (!q.isEmpty()) {
			Position c = q.poll();
			int cy = c.y;
			int cx = c.x;

			for (int i = 0; i < 4; i++) {
				int ny = cy + dy[i];
				int nx = cx + dx[i];

				if (ny < 0 || ny >= n || nx < 0 || nx >= n)
					continue;
				if (map[ny][nx] == current)
					continue;
				if (visited[ny][nx])
					continue;
				if (map[ny][nx] != 0) {
					answer = Math.min(answer, nMap[cy][cx] - current);
					return;
				}

				nMap[ny][nx] = nMap[cy][cx] + 1;
				visited[ny][nx] = true;
				q.add(new Position(ny, nx));
			}
		}
	}

	// 가장자리인지 찾기
	public static boolean find_edge(int y, int x) {
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
				continue;
			}
			if (map[ny][nx] == 0) {
				return true;
			}
		}

		return false;
	}

	public static void island_naming(int y, int x, int name) {
		Queue<Position> q = new LinkedList<Position>();
		q.add(new Position(y, x));
		map[y][x] = name;
		ArrayList<Position> arr = new ArrayList<Position>();

		if (find_edge(y, x)) { // 가장자리일 경우
			edges.add(new Position(y, x));
		}

		while (!q.isEmpty()) {
			Position c = q.poll();
			int cy = c.y;
			int cx = c.x;

			for (int i = 0; i < 4; i++) {
				int ny = cy + dy[i];
				int nx = cx + dx[i];

				if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
					continue;
				}
				if (map[ny][nx] != 1) {
					continue;
				}

				map[ny][nx] = name;
				q.add(new Position(ny, nx));

				if (find_edge(ny, nx)) { // 가장자리일 경우
					edges.add(new Position(ny, nx));
				}
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
