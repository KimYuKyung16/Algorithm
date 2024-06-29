import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, k, order = 0;
	static ArrayList<Node> belt = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2 * n; i++) {
			belt.add(new Node(Integer.parseInt(st.nextToken()), 0));
		}

		while (count()) {
			order++;
			rotate();
			move();
		}

		System.out.println(order);
	}

	// 1. 회전
	public static void rotate() {
		Node last = belt.remove(belt.size() - 1);
		belt.add(0, last);

		belt.get(n - 1).robot = 0;
	}

	// 2. 로봇 이동
	public static void move() {
		for (int i = n - 2; i >= 0; i--) {
			if (belt.get(i).robot >= 1) {
				if (belt.get(i + 1).robot == 0 && belt.get(i + 1).power >= 1) {
					belt.get(i).robot--;
					belt.get(i + 1).robot++;
					belt.get(i + 1).power--;
				}
			}
		}

		belt.get(n - 1).robot = 0;

		if (belt.get(0).power > 0) {
			belt.get(0).robot++;
			belt.get(0).power--;
		}
	}

	// 3, 내구도
	public static boolean count() {
		int count = 0;
		for (int i = 0; i < belt.size(); i++) {
			if (belt.get(i).power <= 0) {
				count++;
			}
		}

		if (count >= k) {
			return false;
		} else {
			return true;
		}
	}

	public static class Node {
		int power;
		int robot;

		public Node(int power, int robot) {
			this.power = power;
			this.robot = robot;
		}
	}
}
