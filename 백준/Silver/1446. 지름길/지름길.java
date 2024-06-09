import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] dp = new int[10001];

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		ArrayList<int[]> load = new ArrayList<>();

		for (int i = 1; i < dp.length; i++) {
			dp[i] = i;
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());

			load.add(new int[] { start, end, len });
		}

		for (int i = 1; i <= d; i++) {
			dp[i] = Math.min(dp[i], dp[i - 1] + 1);

			for (int j = 0; j < n; j++) {
				if (load.get(j)[1] == i) {
					dp[i] = Math.min(dp[i], dp[load.get(j)[0]] + load.get(j)[2]);
				}
			}
		}

		System.out.println(dp[d]);
	}
}
