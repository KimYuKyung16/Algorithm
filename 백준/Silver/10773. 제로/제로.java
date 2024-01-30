import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static BufferedReader br;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		Stack<String> nums = new Stack<>();
		int answer = 0;

		for (int i = 0; i < k; i++) {
			String num = br.readLine();
			if (num.equals("0")) {
				nums.pop();
			} else {
				nums.push(num);
			}
		}

		for (String num : nums) {
			answer += Integer.parseInt(num);
		}

		System.out.println(answer);
	}
}
