import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static String S, T;
	static int answer = 0;

	public static void main(String[] args) throws Exception {
		S = br.readLine();
		T = br.readLine();

		if (S.equals(T)) {
			answer = 1;
			return;
		}

		dfs(T);
		System.out.println(answer);
	}

	public static void dfs(String str) {
		if (str.length() == S.length()) {
			if (str.equals(S)) {
				answer = 1;
				return;
			}
		}
		if (str.length() <= S.length()) {
			return;
		}
		if (str.charAt(str.length() - 1) == 'A') {
			dfs(str.substring(0, str.length() - 1));
		}
		if (str.charAt(0) == 'B') {
			dfs(reverse_string(str).substring(0, str.length() - 1));
		}
	}

	public static String reverse_string(String str) {
		String reversed = "";

		for (int i = str.length() - 1; i >= 0; i--) {
			reversed += str.charAt(i);
		}

		return reversed;
	}
}
