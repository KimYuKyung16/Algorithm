import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static int t = 1;

	public static void main(String[] args) throws Exception {
		while (true) {
			int n = Integer.parseInt(br.readLine()); // 동굴의 크기
			if (n == 0)
				break;

			int[][] map = new int[n][n]; // 기본 맵
			boolean[][] visited = new boolean[n][n]; // 방문 처리
			int[][] sum = new int[n][n]; // 비용 계산
			// 값, y, x
			PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				};
			});

			for (int y = 0; y < n; y++) {
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < n; x++) {
					map[y][x] = Integer.parseInt(st.nextToken());
					sum[y][x] = Integer.MAX_VALUE;
				}
			}

			sum[0][0] = map[0][0];
			visited[0][0] = true;
			pq.add(new int[] { sum[0][0], 0, 0 });
			dijk(map, visited, sum, pq, n);

			System.out.printf("Problem %d: %d\n", t, sum[n - 1][n - 1]);
			t++;
		}
	}

	public static void dijk(int[][] map, boolean[][] visited, int[][] sum, PriorityQueue<int[]> pq, int n) {
		while (!pq.isEmpty()) {
			int[] current = pq.poll();
			visited[current[1]][current[2]] = true;

			for (int i = 0; i < 4; i++) {
				int ny = current[1] + dy[i];
				int nx = current[2] + dx[i];

				if (ny < 0 || ny >= n || nx < 0 || nx >= n)
					continue;
				if (visited[ny][nx])
					continue;

				sum[ny][nx] = Math.min(sum[ny][nx], current[0] + map[ny][nx]);
				pq.add(new int[] { sum[ny][nx], ny, nx });
			}
		}
	}
}
