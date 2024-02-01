import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 시작 지점을 주변에 L이 하나만 있는 경우에만 설정

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static char[][] map; // 보물 지도
	static int[][] visited; // 방문처리
	static int n, m; // 세로, 가로
	static int answer = Integer.MIN_VALUE; // 답
	static Queue<int[]> queue = new LinkedList<int[]>();
	static int cy, cx;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); // 세로 크기
		m = Integer.parseInt(st.nextToken()); // 가로 크기
		map = new char[n][m];
		visited = new int[n][m];

		// 보물 지도 구성하기
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		// 시작
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < m; x++) {
				if (map[y][x] == 'W')
					continue;

				visited = new int[n][m];
				visited[y][x] = 1;
				queue.add(new int[] { y, x });
				bfs(y, x);
			}
		}

		System.out.println(answer);
	}

	public static void bfs(int y, int x) {
		while (!queue.isEmpty()) { // 큐에 값이 있는 경우
			int[] current = queue.remove(); // 큐의 제일 첫번째 값(좌표) 제거
			cy = current[0];
			cx = current[1];

			for (int i = 0; i < 4; i++) {
				int ny = cy + dy[i];
				int nx = cx + dx[i];

				if (ny < 0 || ny >= n || nx < 0 || nx >= m)
					continue;
				if (map[ny][nx] == 'W')
					continue;

				if (visited[ny][nx] != 0) {
					continue;
				}
				visited[ny][nx] = visited[cy][cx] + 1;
				queue.add(new int[] { ny, nx });
			}
		}

		answer = Math.max(visited[cy][cx] - 1, answer);
	}
}
