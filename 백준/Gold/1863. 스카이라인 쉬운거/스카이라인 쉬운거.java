import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		Stack<int[]> stack = new Stack<int[]>();
		int count = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			while (!stack.isEmpty() && stack.peek()[1] > y) {
				count++;
				stack.pop();
			}
			if (!stack.isEmpty() && stack.peek()[1] == y) {
				continue;
			}
			stack.push(new int[] { x, y });
		}

		while (!stack.isEmpty()) {
			if (stack.peek()[1] > 0) {
				count++;
			}
			stack.pop();
		}

		System.out.println(count);
	}
}
