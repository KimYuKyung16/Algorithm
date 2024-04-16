import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int total = 10001;
		int[][] dp = new int[total][3];

		dp[1][0] = 0;
		dp[1][1] = 0;
		dp[1][2] = 1;

		dp[2][0] = 1;
		dp[2][1] = 0;
		dp[2][2] = 2;

		dp[3][0] = 1;
		dp[3][1] = 1;
		dp[3][2] = 3;

		for (int i = 4; i < total; i++) {
			dp[i][2] = dp[i - 1][2];

			if (i == 5) {
				dp[i][0] = 1;
				dp[i][1] = dp[i - 3][1];
				dp[i][2] += (dp[i][0] + dp[i][1]);
				continue;
			}

			dp[i][0] = dp[i - 2][0] + dp[i - 2][1];
			dp[i][1] = dp[i - 3][1];
			dp[i][2] += (dp[i][0] + dp[i][1]);
		}

		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			// index 0은 2와 3으로 이루어진 경우
			// index 1은 3으로만 이루어진 경우
			// index 2는 총합

			System.out.println(dp[n][2]);
		}
	}
}
