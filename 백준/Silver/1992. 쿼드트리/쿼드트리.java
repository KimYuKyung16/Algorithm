import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br;
	static int[][] video;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 영상의 크기
		video = new int[n][n];

		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			for (int j = 0; j < n; j++) {
				video[i][j] = temp.charAt(j) - '0';
			}
		}
		divide(0, 0, n);
	}

	// 분할
	public static void divide(int y, int x, int len) {
		int cur = video[y][x];
		for (int i = y; i < y + len; i++) {
			for (int j = x; j < x + len; j++) {
				if (video[i][j] != cur) {
					System.out.print("(");
					divide(y, x, len / 2); // 좌상
					divide(y, x + len / 2, len / 2); // 우상
					divide(y + len / 2, x, len / 2); // 좌하
					divide(y + len / 2, x + len / 2, len / 2); // 우하
					System.out.print(")");
					return;
				}
			}
		}

		System.out.print(cur);
		return;
	}
}
