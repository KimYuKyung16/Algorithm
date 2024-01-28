import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		String[] nums = br.readLine().split(" ");

		int left = 0;
		int right = 0;
		int answer = Integer.MIN_VALUE;
		int sum = 0;

		while (right <= n) {
			if (right - left == k) {
				answer = Math.max(answer, sum);
				sum -= Integer.parseInt(nums[left++]);
			} else if (right - left > k) {
				sum -= Integer.parseInt(nums[left++]);
			} else if (right - left < k) {
				if (right >= n)
					break;
				sum += Integer.parseInt(nums[right++]);
			}
		}

		System.out.println(answer);

	}
}