import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static boolean[] visited;
	static int[][] s;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		visited = new boolean[n];
		s = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				s[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			visited[i] = true;
			dfs(i, 1);
			visited[i] = false;
		}

		System.out.println(answer);
	}

	// 조합에 따른 계산하기
	public static void calc() {
		int start = 0;
		int link = 0;

		for (int i = 0; i < n; i++) {
			if (visited[i]) {
				for (int j = 0; j < n; j++) {
					if (visited[j] && j != i) {
						start += s[i][j];
					}
				}
			} else {
				for (int j = 0; j < n; j++) {
					if (!visited[j] && j != i) {
						link += s[i][j];
					}
				}
			}
		}

		answer = Math.min(answer, Math.abs(start - link));
	}

	// 조합 구하기
	public static void dfs(int start, int cnt) {
		if (cnt == n / 2) {
			calc();
		}

		for (int i = start + 1; i < n; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			dfs(i, cnt + 1);
			visited[i] = false;
		}
	}
}
