import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
		public int compare(int[] o1, int[] o2) {
			return o1[2] - o2[2];
		}
	});
	static int[] parent; // 부모 저장
	static ArrayList<Integer> costArr = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // n개의 집
		int m = Integer.parseInt(st.nextToken()); // 집들을 연결하는 m개의 길
		parent = new int[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // 첫 번째 집
			int b = Integer.parseInt(st.nextToken()); // 두 번째 집
			int c = Integer.parseInt(st.nextToken()); // 길의 유지비

			pq.offer(new int[] { a, b, c });
		}

		init();

		int sum = 0;
		int size = pq.size();
		for (int i = 0; i < size; i++) {
			int[] cur = pq.poll();

			if (union(cur[0], cur[1])) {
				sum += cur[2];
				costArr.add(cur[2]);
			}
			if (costArr.size() == n - 1)
				break;
		}

		System.out.println(sum - costArr.get(costArr.size() - 1));
	}

	public static void init() {
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
	}

	public static int find(int x) { // int
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}

	public static boolean union(int x, int y) { // boolean
		if (find(y) == find(x))
			return false;
		parent[find(y)] = find(x);
		return true;
	}
}
