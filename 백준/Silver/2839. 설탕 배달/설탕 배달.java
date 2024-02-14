import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		int sum = 0;

		while (sum <= n) {
			sum += 5;
			answer++;
		}

		if (sum == n)
			System.out.println(answer);
		else {
			while (true) {
				sum -= 5;
				answer--;

				if ((n - sum) % 3 == 0) {
					answer += (n - sum) / 3;
					System.out.println(answer);
					break;
				}
				if (sum <= 0) {
					if (n - sum > 0) {
						System.out.println(-1);
					}
					break;
				}
			}
		}
	}
}