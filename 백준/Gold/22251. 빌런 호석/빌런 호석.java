import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, K, P, X;
	static int[][] numberList;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // N층까지
		K = Integer.parseInt(st.nextToken()); // 디스플레이에 K자리까지
		P = Integer.parseInt(st.nextToken()); // 최대 P개를 반전
		X = Integer.parseInt(st.nextToken()); // 현재 서있는 층
		numberList = new int[10][7];
		String current = fill(Integer.toString(X));
		int answer = 0;

		get_numberList();

		for (int i = 1; i <= N; i++) {
			String compare = fill(Integer.toString(i));

			if (compare_numbers(current, compare)) {
				answer++;
			}
		}

		System.out.println(answer);
	}

	public static boolean compare_numbers(String current, String compare) {
		int count = 0;
		for (int i = 0; i < K; i++) {
			for (int j = 0; j < 7; j++) {
				if (numberList[current.charAt(i) - '0'][j] != numberList[compare.charAt(i) - '0'][j]) {
					count++;
				}
			}
		}
		if (count > P || count < 1) {
			return false;
		}

		return true;
	}

	public static String fill(String right) {
		String left = "";
		String result = "";

		for (int i = 0; i < K - right.length(); i++) {
			left += "0";
		}
		result = left + right;

		return result;
	}

	public static void get_numberList() {
		numberList[0] = new int[] { 1, 1, 1, 1, 1, 1, 0 };
		numberList[1] = new int[] { 0, 1, 1, 0, 0, 0, 0 };
		numberList[2] = new int[] { 1, 1, 0, 1, 1, 0, 1 };
		numberList[3] = new int[] { 1, 1, 1, 1, 0, 0, 1 };
		numberList[4] = new int[] { 0, 1, 1, 0, 0, 1, 1 };
		numberList[5] = new int[] { 1, 0, 1, 1, 0, 1, 1 };
		numberList[6] = new int[] { 1, 0, 1, 1, 1, 1, 1 };
		numberList[7] = new int[] { 1, 1, 1, 0, 0, 0, 0 };
		numberList[8] = new int[] { 1, 1, 1, 1, 1, 1, 1 };
		numberList[9] = new int[] { 1, 1, 1, 1, 0, 1, 1 };
	}
}
