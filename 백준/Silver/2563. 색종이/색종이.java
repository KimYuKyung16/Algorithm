import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int[][] board = new int[100][100];
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine()); // 색종이의 수

		for (int count = 0; count < t; count++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 가로 거리
			int m = Integer.parseInt(st.nextToken()); // 세로 거리

			int startY = 100 - 10 - m;
			int startX = n;

			for (int i = startY; i < startY + 10; i++) {
				for (int j = startX; j < startX + 10; j++) {
					board[i][j] = 1;
				}
			}
		}

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (board[i][j] == 1) {
					answer++;
				}
			}
		}

		System.out.println(answer);
	}
}
