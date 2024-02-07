import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int[] dy = { -2, -1, 1, 2 };
	static int[] dx = { 1, 2, 2, 1 };
	static int n, m;
	static int answer = 1;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); // 세로
		m = Integer.parseInt(st.nextToken()); // 가로

		if (n == 1) {
			answer = 1;
		} else if (n == 2) {
			if (m % 2 > 0) {
				answer = Math.min(4, m / 2 + 1);
			} else {
				answer = Math.min(4, m / 2);
			}
		} else {
			if (m < 7) {
				answer = Math.min(m, 4);
			} else {
				answer = 5 + (m - 7);
			}
		}

		System.out.println(answer);
	}
}
