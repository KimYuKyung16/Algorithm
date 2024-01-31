import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringBuilder sb;
	static StringTokenizer st;
	static int[] visited;
	static int n, m;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); // n까지의 수
		m = Integer.parseInt(st.nextToken()); // m개를 고름
		visited = new int[n + 1];

		for (int i = 1; i < n + 1; i++) {
			visited[i] = 1;
			dfs(1, "" + i);
			visited[i] = 0;
		}
		System.out.println(sb);
	}

	public static void dfs(int cnt, String str) {
		if (cnt == m) {
			sb.append(str + "\n");
			return;
		}

		for (int i = 1; i < n + 1; i++) {
			if (visited[i] == 1)
				continue;
			visited[i] = 1;
			dfs(cnt + 1, str + " " + i);
			visited[i] = 0;
		}
	}
}
