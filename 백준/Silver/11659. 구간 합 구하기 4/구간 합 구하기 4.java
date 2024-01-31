import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int[] nums;
	static int[] sums; // 누적합 구하기용

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		nums = new int[n];
		sums = new int[n + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < nums.length + 1; i++) {
			if (i == 0) {
				sums[0] = 0;
			} else {
				sums[i] = sums[i - 1] + nums[i - 1];
			}
		}

		for (int k = 0; k < m; k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken()); // 1
			int j = Integer.parseInt(st.nextToken()); // 3

			System.out.println(sums[j] - sums[i - 1]);
		}
	}
}
