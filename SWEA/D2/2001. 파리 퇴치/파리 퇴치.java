import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= t; test_case++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] board = new int[n][n];
			int answer = Integer.MIN_VALUE;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int sum = 0;
					for (int y = i; y < i + m; y++) {
						for (int x = j; x < j + m; x++) {
							if (y < 0 || y >= n || x < 0 || x >= n)
								continue;
							sum += board[y][x];
						}
					}

					answer = Math.max(answer, sum);
				}
			}

			System.out.printf("#%d %d\n", test_case, answer);
		}
	}
}
