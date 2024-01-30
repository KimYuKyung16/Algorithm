import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int m, n;
	static int[][] land;
	static int[][] visited;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int testcase = 0; testcase < t; testcase++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			land = new int[n][m];
			visited = new int[n][m];
			int count = 0;

			// 배추 심는 중 ..
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				land[y][x] = 1;
			}

			for (int y = 0; y < n; y++) {
				for (int x = 0; x < m; x++) {
					if (land[y][x] == 1 && visited[y][x] == 0) {
						visited[y][x] = 1;
						dfs(y + 1, x);
						dfs(y - 1, x);
						dfs(y, x + 1);
						dfs(y, x - 1);

						count++;
					}
				}
			}

			System.out.println(count);
		}
	}

	public static void dfs(int y, int x) {
		if (y < 0 || y > n - 1 || x > m - 1 || x < 0)
			return;
		if (land[y][x] == 0 || visited[y][x] == 1) {
			return;
		}

		visited[y][x] = 1;
		dfs(y + 1, x);
		dfs(y - 1, x);
		dfs(y, x + 1);
		dfs(y, x - 1);
	}
}
