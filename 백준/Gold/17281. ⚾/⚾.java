import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] order = new int[9]; // 타순
	static boolean[] visited = new boolean[9]; // 방문처리
	static int[][] play;
	static int answer = Integer.MIN_VALUE;
	static int n; // 이닝 수

	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		play = new int[n][9];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 9; j++) {
				play[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		get_order(0);

		System.out.println(answer);
	}

	public static void get_score() {
		int score = 0;
		int cur_order = 0; // 현재 순서

		for (int i = 0; i < n; i++) {
			int out_cnt = 0; // 아웃된 횟수
			int[] location = new int[4]; // 루

			while (out_cnt != 3) {
				int result = play[i][order[cur_order]]; // 현재 타석에 선 사람의 결과
				int move = 0; // 이동하는 정도

				switch (result) {
				case 0: { // 아웃
					out_cnt++;
					break;
				}
				case 1: { // 안타
					move = 1;
					break;
				}
				case 2: { // 2루타
					move = 2;
					break;
				}
				case 3: { // 3루타
					move = 3;
					break;
				}
				case 4: { // 홈런
					move = 4;
					break;
				}
				}

				if (move == 4) { // 홈런일 경우
					int cnt = 1;
					for (int r = 1; r < 4; r++) {
						if (location[r] == 1) {
							cnt++;
							location[r] = 0;
						}
					}
					score += cnt;
				} else {
					for (int r = 3; r >= 1; r--) {
						if (location[r] == 1) {
							location[r] = 0;
							int nr = r + move;
							if (nr > 3) {
								score += 1;
							} else {
								location[nr] = 1;
							}
						}
					}
					location[move] = 1;
				}

				cur_order++;
				cur_order = cur_order % 9;
			}
		}

		answer = Math.max(score, answer);
	}

	// 타순 구하기
	public static void get_order(int cnt) {
		if (cnt == 9) {
			// 야구 점수 구하기
			get_score();
//			System.out.println(Arrays.toString(order));
			return;
		}
		if (cnt == 3) {
			visited[0] = true;
			order[cnt] = 0;
			get_order(cnt + 1);
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (visited[i] || i == 0)
				continue;
			visited[i] = true;
			order[cnt] = i;
			get_order(cnt + 1);
			order[cnt] = 0;
			visited[i] = false;
		}
	}
}
