import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		String board = br.readLine();
		String answer = "";

		String[] boardList = board.split("\\.", -1);

		for (int i = 0; i < boardList.length; i++) {
			int length = boardList[i].length();
			if (length == 0) {
				answer += ".";
				continue;
			}
			if (length < 2 || length % 2 != 0) {
				answer = "-1";
				break;
			}

			int Aquot = length / 4;
			int Aremain = length % 4;

			for (int j = 0; j < Aquot; j++) {
				answer += "AAAA";
			}

			if (Aremain != 0) {
				int Bquot = Aremain / 2;
				for (int j = 0; j < Bquot; j++) {
					answer += "BB";
				}
			}
			answer += ".";
		}

		if (board.replace(".", "").length() == 0) {
			System.out.println(board);
			return;
		}
		if (answer.contains("A") || answer.contains("B")) {
			System.out.println(answer.substring(0, answer.length() - 1));
		} else {
			System.out.println(-1);
		}
	}
}
