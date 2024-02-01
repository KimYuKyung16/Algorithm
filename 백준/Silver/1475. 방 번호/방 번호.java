import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br;

	// 방 번호의 각 숫자를 count 하기

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		int[] cntList = new int[10];
		int answer = 0;

		for (int i = 0; i < n.length(); i++) {
			int num = n.charAt(i) - '0';
			cntList[num]++;
		}

		for (int i = 0; i < 10; i++) {
			int temp = 0;
			if (i == 6 || i == 9) {
				temp = (cntList[6] + cntList[9]) / 2;
				if ((cntList[6] + cntList[9]) % 2 > 0) {
					temp++;
				}
				answer = Math.max(answer, temp);
			} else {
				answer = Math.max(answer, cntList[i]);
			}
		}

		System.out.println(answer);
	}
}
