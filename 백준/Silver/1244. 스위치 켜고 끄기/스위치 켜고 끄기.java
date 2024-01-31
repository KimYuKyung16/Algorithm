import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int n; // 스위치 개수
	static String[] switchState; // 스위치 상태
	static int studentsSize; // 학생수

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		switchState = br.readLine().split(" ");
		studentsSize = Integer.parseInt(br.readLine());

		for (int i = 0; i < studentsSize; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()); // 성별
			int num = Integer.parseInt(st.nextToken()); // 학생이 받은 수

			// 남학생은 1, 여학생은 2
			if (s == 1) { // 남학생일 경우
				boy(num);
			} else { // 여학생일 경우
				girl(num);
			}
		}

		for (int i = 0; i < switchState.length; i++) {
			System.out.print(switchState[i] + " ");
			if ((i + 1) % 20 == 0) {
				System.out.println();
			}
		}
	}

	// 남학생일 경우
	public static void boy(int num) {
		for (int i = num; i <= n; i += num) {
			changeSwitch(switchState[i - 1], i - 1);
		}
	}

	// 여학생일 경우
	public static void girl(int num) {
		int count = 0;
		int left = 0, right = 0;

		while (true) {
			if (num - count - 1 < 0 || num + count - 1 >= n)
				break;
			left = num - count - 1; // 왼쪽
			right = num + count - 1; // 오른쪽

			if (switchState[left].equals(switchState[right])) {
				if (left == right) {
					changeSwitch(switchState[left], left);
				} else {
					changeSwitch(switchState[left], left);
					changeSwitch(switchState[right], right);
				}
				count++;
			} else {
				break;
			}
		}
	}

	// 스위치 상태 바꾸기
	public static void changeSwitch(String state, int index) {
		if (state.equals("0")) {
			switchState[index] = "1";
		} else {
			switchState[index] = "0";
		}
	}
}
