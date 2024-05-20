import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] board;
	static int[][] copy_board;
	static int totalDepth;
	static int sy, sx, size; // 정사각형의 시작지점과 한 변의 길이
	static int n;
	static ArrayList<int[]> arr = new ArrayList<>();
	static ArrayList<int[]> order = new ArrayList<>();
	static boolean[] visited;
	static int m, k;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken()); // 회전 연산의 개수
		visited = new boolean[k];

		board = new int[n][m];
		copy_board = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());

			arr.add(new int[] { r, c, s });
		}

		for (int i = 0; i < arr.size(); i++) {
			order.add(arr.get(i));
			visited[i] = true;
			get_order(1);
			order.remove(order.size() - 1);
			visited[i] = false;
		}

		System.out.println(answer);
	}

	public static void copy() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				copy_board[i][j] = board[i][j];
			}
		}
	}

	// 순열 구하기
	public static void get_order(int cnt) {
		if (cnt == k) {
			copy();
			start();
			return;
		}

		for (int i = 0; i < k; i++) {
			if (visited[i])
				continue;
			order.add(arr.get(i));
			visited[i] = true;
			get_order(cnt + 1);
			order.remove(order.size() - 1);
			visited[i] = false;
		}
	}

	public static void start() {
		// 가장 왼쪽 윗 칸: (r-s, c-s)
		// 가장 오른쪽 아랫 칸: (r+s, c+s)
		// 정사각형을 시계 방향으로 한칸씩 돌림
		for (int i = 0; i < order.size(); i++) {
			int[] currnet = order.get(i);
			int r = currnet[0];
			int c = currnet[1];
			int s = currnet[2];

			// 정사각형의 시작 지점
			sy = r - s - 1;
			sx = c - s - 1;
			int initsy = sy;
			int initsx = sx;

			size = (r + s) - (r - s) + 1; // 정사각형의 한 변 크기

			if (size % 2 == 0) {
				totalDepth = size / 2 - 1;
				dfs(0);
				initsy++;
				initsx++;
				// 총 4칸일 경우
				int current = copy_board[initsy][sx];
				int next = copy_board[initsy][sx + 1];
				for (int j = 0; j < 4; j++) {
					if (j == 0) {
						initsx++;
						copy_board[initsy][initsx] = current;
						current = next;
						next = copy_board[initsy + 1][initsx];
					} else if (j == 1) {
						initsy++;
						copy_board[initsy][initsx] = current;
						current = next;
						next = copy_board[initsy][initsx - 1];
					} else if (j == 2) {
						initsx--;
						copy_board[initsy][initsx] = current;
						current = next;
						next = copy_board[initsy - 1][initsx];
					} else if (i == 3) {
						initsy--;
						copy_board[initsy][initsx] = current;
					}
				}
			} else {
				totalDepth = size / 2;
				dfs(0);
			}
		}

		calc();
	}

	public static void dfs(int depth) {
		// 연산이 끝났을 경우
		if (depth == totalDepth) {
			return;
		}

		move(sy, sx, depth);
		sy++;
		sx++;
		dfs(depth + 1);
	}

	// 실제로 이동
	public static void move(int y, int x, int depth) {
		int inity = y;
		int initx = x;
		int current = copy_board[y][x]; // 현재 들어갈 값
		int next = copy_board[y][x + 1]; // 다음에 들어갈 값

		// 오른쪽으로 이동
		while (true) {
			x++;
			copy_board[y][x] = current;

			current = next;

			if (x + 1 >= initx + (size - depth * 2)) {
				next = copy_board[y + 1][x];
				break;
			} else {
				next = copy_board[y][x + 1];
			}
		}

		// 아래로 이동
		while (true) {
			y++;
			copy_board[y][x] = current;

			current = next;

			if (y + 1 >= inity + (size - depth * 2)) {
				next = copy_board[y][x - 1];
				break;
			} else {
				next = copy_board[y + 1][x];
			}
		}

		// 왼쪽으로 이동
		while (true) {
			x--;
			copy_board[y][x] = current;

			current = next;

			if (x < initx + 1) {
				next = copy_board[y - 1][x];
				break;
			} else {
				next = copy_board[y][x - 1];
			}
		}

		// 위쪽으로 이동
		while (true) {
			y--;
			copy_board[y][x] = current;

			current = next;

			if (y < inity + 1) {
				break;
			} else {
				next = copy_board[y - 1][x];
			}
		}
	}

	public static void calc() {
		int minNum = Integer.MAX_VALUE;

		for (int i = 0; i < copy_board.length; i++) {
			int tmp = 0;

			for (int j = 0; j < copy_board[0].length; j++) {
				tmp += copy_board[i][j];
			}

			minNum = Math.min(minNum, tmp);
		}

		answer = Math.min(answer, minNum);
	}
}
