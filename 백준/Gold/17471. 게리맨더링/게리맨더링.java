import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] peopleCnt;
	static int n;
	static boolean[] arr;
	static boolean[][] graph;
	static int answer = Integer.MAX_VALUE;
	static ArrayList<Integer> team1 = new ArrayList<>();
	static ArrayList<Integer> team2 = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		arr = new boolean[n + 1];
		peopleCnt = new int[n + 1];
		graph = new boolean[n + 1][n + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			peopleCnt[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int count = Integer.parseInt(st.nextToken());
			while (st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());
				graph[i][num] = true;
			}
			graph[i][i] = true;
		}

		for (int i = 1; i <= n; i++) {
			arr[i] = true;
			combi(i);
			arr[i] = false;
		}

		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}

	public static boolean confirm_cnt() {
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]) {
				cnt++;
			}
		}
		if (cnt == n)
			return false;
		else
			return true;
	}

	public static void combi(int start) {
		if (confirm_cnt()) {
			divide_team();

			if (confirm_connect(team1) && confirm_connect(team2)) {
				calc();
			}
		}

		for (int i = start; i <= n; i++) {
			if (arr[i])
				continue;
			arr[i] = true;
			combi(i);
			arr[i] = false;
		}
	}

	public static void divide_team() {
		team1.clear();
		team2.clear();

		for (int i = 1; i < arr.length; i++) {
			if (arr[i]) {
				team1.add(i);
			} else {
				team2.add(i);
			}
		}
	}

	public static boolean confirm_connect(ArrayList<Integer> team) {
		boolean[] v = new boolean[n + 1];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(team.get(0));

		while (!q.isEmpty()) {
			int c = q.remove();

			for (int i = 0; i < graph[c].length; i++) {
				if (graph[c][i] && team.contains(i)) {
					if (v[i])
						continue;
					v[i] = true;
					q.add(i);
				}
			}
		}

		int cnt = 0;
		for (int i = 0; i < v.length; i++) {
			if (v[i])
				cnt++;
		}

		if (cnt == team.size()) {
			return true;
		} else {
			return false;
		}
	}

	public static void calc() {
		int sum1 = 0;
		int sum2 = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i])
				sum1 += peopleCnt[i];
			else
				sum2 += peopleCnt[i];
		}

		answer = Math.min(Math.abs(sum1 - sum2), answer);
	}

}
