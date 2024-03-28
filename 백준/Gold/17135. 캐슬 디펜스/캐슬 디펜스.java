import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map;
	static int n, m, d;
	static int[] visited; // 궁수 방문 처리
	static int answer = Integer.MIN_VALUE;
	static int killCnt = 0;
	static int[][] newMap;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 행
		m = Integer.parseInt(st.nextToken()); // 열
		d = Integer.parseInt(st.nextToken()); // 궁수의 공격 거리 제한
		map = new int[n][m];
		newMap = new int[n][m];
		visited = new int[m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		getArchersPosition(0);
		System.out.println(answer);
	}

	public static void gameStart() {
		// 모든 궁수가 다 쏘고 난 후에는
		while (getEnemyCnt() > 0) {
			for (int i = 0; i < m; i++) { // 궁수 기준
				if (visited[i] == 1) { // 궁수가 있는 경우
					int enemy_y = m + 1;
					int enemy_x = n + 1;
					int enemy_dist = 1000;
					// 쏘기
					for (int y = n - 1; y >= 0; y--) {
						for (int x = 0; x < m; x++) {
							if (newMap[y][x] >= 1) {
								// 궁수와 적 사이의 거리
								int dist = Math.abs(n - y) + Math.abs(i - x);
								if (dist <= d && dist <= enemy_dist) { // 궁수가 공격할 수 있는 적인 경우
									if (dist == enemy_dist) {
										if (x < enemy_x) {
											enemy_y = y;
											enemy_x = x;
											enemy_dist = dist;
										}
									} else {
										enemy_y = y;
										enemy_x = x;
										enemy_dist = dist;
									}
								}
							}
						}
					}

					if (enemy_y < 0 || enemy_y >= n || enemy_x < 0 || enemy_x >= m) {
						continue;
					}
					newMap[enemy_y][enemy_x] += 1;
				}
			}

			killEnemy();
			moveEnemy();
		}

		answer = Math.max(killCnt, answer);
		killCnt = 0;
	}

	public static void mapCopy() {
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < m; x++) {
				newMap[y][x] = map[y][x];
			}
		}
	}

	public static int getEnemyCnt() {
		int enemyCnt = 0;
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < m; x++) {
				if (newMap[y][x] == 1) {
					enemyCnt++;
				}
			}
		}
		return enemyCnt;
	}

	// 적 없애기
	public static void killEnemy() {
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < m; x++) {
				if (newMap[y][x] >= 2) { // 궁수한테 화살을 맞은 적일 경우
					newMap[y][x] = 0;
					killCnt++;
				}
			}
		}
	}

	// 적 아래로 이동
	public static void moveEnemy() {
		for (int y = n - 1; y >= 0; y--) {
			for (int x = 0; x < m; x++) {
				if (newMap[y][x] == 1) {
					newMap[y][x] = 0;
					if (y + 1 >= n)
						continue;
					newMap[y + 1][x] = 1;
				}
			}
		}
	}

	// 궁수들의 위치를 구하는 함수
	public static void getArchersPosition(int cnt) {
		if (cnt == 3) {
			mapCopy();
			gameStart();
			return;
		}

		for (int i = 0; i < m; i++) {
			if (visited[i] == 1) {
				return;
			}
			visited[i] = 1;
			getArchersPosition(cnt + 1);
			visited[i] = 0;
		}
	}
}
