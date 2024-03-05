import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int[] dy = { -1, 0, 1, 0, 0, 0 }; // 상, 우, 하, 좌, 위, 아래
	static int[] dx = { 0, 1, 0, -1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, 1, -1 };
	static Queue<int[]> queue = new LinkedList<int[]>();
	static int[][][] visited; // 방문 처리
	static int m, n, h; // 가로, 세로, 쌓아올려지는 상자 수
	static int answer = 0; // 0은 모든 토마토가 익어있는 상태, -1은 토마토가 모두 익지 못하는 상태
	static int cnt_0 = 0;

	// 1은 익은 토마토, 0은 익지 않은 토마토, -1은 토마토 없음.

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken()); // 상자의 가로 칸의 수
		n = Integer.parseInt(st.nextToken()); // 상자의 세로 칸의 수
		h = Integer.parseInt(st.nextToken()); // 쌓아올려지는 상자의 수
		visited = new int[h][n][m];

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < m; k++) {
					int current = Integer.parseInt(st.nextToken());
					visited[i][j][k] = current;

					if (current == 1) { // 익은 토마토들의 좌표를 다 넣어주기
						queue.add(new int[] { i, j, k }); // {z, y, x}
					}
					if (current == 0) {
						cnt_0++;
					}
				}
			}
		}

		if (cnt_0 == 0) {
			System.out.println(0);
			return;
		}

		bfs();

		// 모든 계산을 끝내고 나서 안익은 토마토가 있는지 확인하는 작업
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (visited[i][j][k] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}

		System.out.println(answer - 1);
	}

	public static void bfs() {
		while (!queue.isEmpty()) {
			int[] current = queue.poll(); // {z, y, x}
			int z = current[0];
			int y = current[1];
			int x = current[2];

			for (int i = 0; i < 6; i++) {
				int nz = z + dz[i];
				int ny = y + dy[i];
				int nx = x + dx[i];

				if (ny < 0 || nx < 0 || nz < 0 || ny >= n || nx >= m || nz >= h)
					continue;
				if (visited[nz][ny][nx] != 0)
					continue;

				visited[nz][ny][nx] = visited[z][y][x] + 1;
				answer = Math.max(answer, visited[nz][ny][nx]);
				queue.add(new int[] { nz, ny, nx });
			}
		}
	}
}
