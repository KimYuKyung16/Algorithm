import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken()); // 바구니 길이
		int j = Integer.parseInt(br.readLine()); // 사과 개수

		int basketLeft = 1;
		int basketRight = m;
		int answer = 0;

		for (int i = 0; i < j; i++) {
			int location = Integer.parseInt(br.readLine());
			if (m == 1) {
				answer += Math.abs(basketLeft - location);
				basketLeft = location;
			} else {
				int left = Math.abs(basketLeft - location);
				int right = Math.abs(basketRight - location);

				if (location >= basketLeft && location <= basketRight) {
					continue;
				} else if (location < basketLeft) { // 사과 왼
					answer += left;
					basketLeft = location;
					basketRight -= left;
				} else { // 사과 오
					answer += right;
					basketRight = location;
					basketLeft += right;
				}
			}
		}

		System.out.println(answer);
	}
}
