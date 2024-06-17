import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Character[] list;
	static int n;

	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		int redCnt = 0;
		int blueCnt = 0;
		list = new Character[n];
		int result = Integer.MAX_VALUE;

		String str = br.readLine();
		for (int i = 0; i < n; i++) {
			Character current = str.charAt(i);
			list[i] = current;

			if (current == 'R') {
				redCnt++;
			} else {
				blueCnt++;
			}
		}

		if (redCnt == 0 || blueCnt == 0) {
			System.out.println(0);
			return;
		}

		int leftCnt = 1;
		Character first = list[0];
		int i = 1;
		while (list[i] == first) {
			leftCnt++;
			i++;
		}

		int rightCnt = 1;
		Character last = list[list.length - 1];
		i = list.length - 2;
		while (list[i] == last) {
			rightCnt++;
			i--;
		}

		int answer1 = cal('l', leftCnt, first);
		int answer2 = cal('r', rightCnt, last);

		result = Math.min(answer1, answer2);

		if (first == last) {
			Character current;
			int answer = 0;
			if (first == 'R') {
				current = 'B';
			} else {
				current = 'R';
			}
			for (int j = 0; j < n; j++) {
				if (list[j] == current) {
					answer++;
				}
			}

			result = Math.min(result, answer);
		}

		System.out.println(result);
	}

	public static int cal(Character dir, int cnt, Character start) {
		int answer = 0;

		if (dir == 'l') {
			for (int i = cnt; i < n; i++) {
				if (list[i] == start) {
					answer++;
				}
			}
		} else {
			for (int i = list.length - cnt - 1; i >= 0; i--) {
				if (list[i] == start) {
					answer++;
				}
			}
		}

		return answer;
	}
}
