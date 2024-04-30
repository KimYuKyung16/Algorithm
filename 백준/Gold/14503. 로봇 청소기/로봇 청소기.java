import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m;
	static Position robotP;
	static int d;
	static int[][] map;

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static int answer = 0;

	// 0은 북, 1은 동, 2는 남, 3은 서
	// 1은 벽, 0은 청소된 빈칸, 2는 청소 완료
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		robotP = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		d = Integer.parseInt(st.nextToken()); // 청소기 방향
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			int rr = robotP.r;
			int rc = robotP.c;

			// 청소 안됐으면 청소
			if (map[rr][rc] == 0) {
				map[rr][rc] = 2;
				answer++;
			}

			// 청소할 칸이 있는 경우
			if (confirm_around()) {
				while (true) {
					// 반시계 방향으로 90도 회전
					if (d == 0) {
						d = 3;
					} else {
						d = d - 1;
					}

					int nr = robotP.r + dr[d];
					int nc = robotP.c + dc[d];

					if (nr < 0 || nr >= n || nc < 0 || nc >= m)
						continue;
					if (map[nr][nc] == 0) {
						robotP.r = nr;
						robotP.c = nc;
						break;
					}
				}
			} else { // 청소할 칸이 없는 경우
				// 한 칸 후친할 수 있으면 후진
				int nd = (d + 2) % 4; // 후진할 방향
				int nr = robotP.r + dr[nd];
				int nc = robotP.c + dc[nd];

				if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
					// 후진 불가능할 경우
					System.out.println(answer);
					return;
				}
				if (map[nr][nc] == 1) {
					// 후진 불가능할 경우
					System.out.println(answer);
					return;
				}
				robotP.r = nr;
				robotP.c = nc;
			}
		}
	}

	// 주변에 청소할 칸이 있는지 확인
	public static boolean confirm_around() {
		for (int i = 0; i < 4; i++) {
			int nr = robotP.r + dr[i];
			int nc = robotP.c + dc[i];

			if (nr < 0 || nr >= n || nc < 0 || nc >= m)
				continue;
			if (map[nr][nc] == 0) {
				return true;
			}
		}
		return false;
	}

	public static class Position {
		int r;
		int c;

		public Position(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
