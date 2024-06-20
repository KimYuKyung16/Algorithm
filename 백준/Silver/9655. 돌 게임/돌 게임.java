import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] win;

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		win = new int[1001];

		win[1] = 1;
		win[2] = 2;
		win[3] = 3;

		for (int i = 4; i <= n; i++) {
			win[i] = Math.min(win[i - 1], win[i - 3]) + 1;
		}

		if (win[n] % 2 == 0) {
			System.out.println("CY");
		} else {
			System.out.println("SK");
		}
	}
}
