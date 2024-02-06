import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] Board;
	static int N, M, R;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader brr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(brr.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(s.nextToken());
		M = Integer.parseInt(s.nextToken());
		R = Integer.parseInt(s.nextToken());
		Board = new int[N][M];
		// 맵 구성
		for (int i = 0; i < N; i++) {
			s = new StringTokenizer(brr.readLine());
			for (int j = 0; j < M; j++) {
				Board[i][j] = Integer.parseInt(s.nextToken());
			}
		}

		for (int i = 0; i < R; i++) {
			int[] tl = { 0, 0 };
			int[] tr = { 0, M - 1 };
			int[] br = { N - 1, M - 1 };
			int[] bl = { N - 1, 0 };
			dfs(tl, tr, br, bl);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(Board[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void dfs(int[] tl, int[] tr, int[] br, int[] bl) {
		if (tl[0] > br[0] || tl[1] > br[1] || tl[0] == br[0] || tl[1] == br[1]) {
			return;
		}

		int num = 0;
		for (int i = bl[0]; i > tl[0]; i--) { // down
			if (i == bl[0]) {
				num = Board[bl[0]][bl[1]];
			}
			Board[i][bl[1]] = Board[i - 1][bl[1]];
		}

		int num2 = 0;
		for (int i = br[1]; i > bl[1]; i--) { // right
			if (i == br[1]) {
				num2 = Board[br[0]][br[1]];
			}
			Board[br[0]][i] = Board[br[0]][i - 1];
		}
		Board[bl[0]][bl[1] + 1] = num;

		int num3 = 0;
		for (int i = tr[0]; i < br[0]; i++) { // up
			if (i == tr[0]) {
				num3 = Board[tr[0]][tr[1]];
			}
			Board[i][tr[1]] = Board[i + 1][tr[1]];
		}
		Board[br[0] - 1][br[1]] = num2;

		for (int i = tl[1]; i < tr[1]; i++) { // left
			Board[tl[0]][i] = Board[tl[0]][i + 1];
		}
		Board[tr[0]][tr[1] - 1] = num3;

		tl[0]++;
		tl[1]++;
		tr[0]++;
		tr[1]--;
		br[0]--;
		br[1]--;
		bl[0]--;
		bl[1]++;

		dfs(tl, tr, br, bl);
	}
}
