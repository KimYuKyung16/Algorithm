import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] nums;
	static int answer = 0;

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		nums = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(nums);

		for (int k = 0; k < n; k++) {
			int current = nums[k];

			int i = 0;
			int j = nums.length - 1;
			while (i < j) {
				if (nums[i] + nums[j] == current) {
					if (i == k) {
						i++;
					} else if (j == k) {
						j--;
					} else {
						answer++;
						break;
					}
				} else if (nums[i] + nums[j] < current) {
					i++;
				} else if (nums[i] + nums[j] > current) {
					j--;
				}
			}
		}

		System.out.println(answer);
	}
}
