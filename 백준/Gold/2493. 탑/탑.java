import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Stack<int[]> stack = new Stack<int[]>();
	static String[] result;

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		result = new String[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int current = Integer.parseInt(st.nextToken());

			if (stack.size() == 0) {
				stack.add(new int[] { i + 1, current });
				result[i] = "0";
			} else {
				while (!stack.isEmpty()) {
					int[] last = stack.get(stack.size() - 1);

					if (last[1] >= current) {
						result[i] = Integer.toString(last[0]);
						break;
					} else {
						stack.pop();
					}
				}
				stack.add(new int[] { i + 1, current });
			}

			if (result[i] == null) {
				result[i] = "0";
			}
		}

		System.out.println(String.join(" ", result));
	}
}
