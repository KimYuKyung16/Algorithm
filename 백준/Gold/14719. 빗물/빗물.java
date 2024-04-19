import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map;
	static Queue<Position> queue;
	static int h, w;
	static Queue<Position> q;
	static boolean[][] visited;
	static int[] dy = { 0, 1, 0 }; // 상은 빼고
	static int[] dx = { 1, 0, -1 };
	static int result = 0; // 빗물 양

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());

		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		map = new int[h][w];
		visited = new boolean[h][w];

		st = new StringTokenizer(br.readLine());
		for (int x = 0; x < w; x++) {
			int cnt = Integer.parseInt(st.nextToken());

			for (int y = h - 1; y >= h - cnt; y--) {
				map[y][x] = 1;
			}
		}

		queue = new LinkedList<Position>();
		q = new LinkedList<Position>();

		for (int y = 0; y < h; y++) {
			queue.clear();
			for (int x = 0; x < w; x++) {
				if (map[y][x] == 1) {
					if (queue.size() == 1) { // 빗물이 고일 수 있음.
						if (visited[y][x])
							continue;
						queue.add(new Position(y, x));
						Position current = queue.poll();
						q.add(new Position(current.y, current.x));
						bfs();
					} else {
						queue.add(new Position(y, x));
					}
				}
			}
		}
        
		System.out.println(result);
	}

	public static void bfs() {
		int tmp = 0;
		while (!q.isEmpty()) {
			Position cur = q.poll();
			int cy = cur.y;
			int cx = cur.x;

			for (int i = 0; i < 3; i++) {
				int ny = cy + dy[i];
				int nx = cx + dx[i];

				if (tmp == 0) {
					if (i != 0) {
						break;
					}
				}

				if (ny < 0 || ny >= h || nx < 0 || nx >= w) // 범위를 벗어나는 경우
					continue;
				if (visited[ny][nx]) // 이미 방문한 경우
					continue;
				if (map[ny][nx] == 1) // 블록인 경우
					continue;

				visited[ny][nx] = true;
				q.add(new Position(ny, nx));

				result++;
			}
			tmp++;
		}
	}

	static class Position {
		int y;
		int x;

		public Position(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
