import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] nums = new int[1001];
		nums[0] = 1;
		nums[1] = 1;
		int cnt = 0;

		while (cnt != k) {
			for (int i = 2; i <= n; i++) {
				if (nums[i] == 0) { // 소수일 경우
					for (int j = i; j <= n; j += i) {
						if (nums[j] == 1)
							continue;
						nums[j] = 1;
						cnt++;
						if (cnt >= k) {
							System.out.println(j);
							return;
						}
					}
				}
			}
		}
	}
}
