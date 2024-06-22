import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int[] cnt = new int[26];
		int max = 0;
		Character answer = '*';

		for (int i = 0; i < str.length(); i++) {
			int current = Character.toUpperCase(str.charAt(i));
			cnt[current - 65]++;
		}

		for (int i = 0; i < cnt.length; i++) {
			max = Math.max(max, cnt[i]);
		}

		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i] == max) {
				if (answer != '*') {
					System.out.println("?");
					return;
				}
				answer = (char) (i + 65);
			}
		}

		System.out.println(answer);
	}
}
