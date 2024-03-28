import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static String[] formula;
	static int n;
	static int answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		formula = br.readLine().split("");

		dfs(1, Integer.parseInt(formula[0]));

		System.out.println(answer);
	}

	public static void dfs(int index, int current) {
		if (index >= n) {
			answer = Math.max(answer, current);
			return;
		}

		int nCurrent1 = calc(current, Integer.parseInt(formula[index + 1]), formula[index]);
		dfs(index + 2, nCurrent1);

		if (index + 3 >= n) {
			return;
		}
		int nCurrent2 = calc(current,
				calc(Integer.parseInt(formula[index + 1]), Integer.parseInt(formula[index + 3]), formula[index + 2]),
				formula[index]);

		dfs(index + 4, nCurrent2);
	}

	public static int calc(int left, int right, String op) {
		if (op.equals("+")) {
			return left + right;
		} else if (op.equals("-")) {
			return left - right;
		} else if (op.equals("*")) {
			return left * right;
		}

		return 0;
	}
}
