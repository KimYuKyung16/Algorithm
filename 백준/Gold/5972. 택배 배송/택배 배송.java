import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m;
	static int[] count;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		count = new int[n + 1];
		visited = new boolean[n + 1];

		for (int i = 0; i < count.length; i++) {
			count[i] = Integer.MAX_VALUE;
			graph.add(new ArrayList<>());

		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph.get(a).add(new Node(b, c));
			graph.get(b).add(new Node(a, c));
		}

		dijkstra();

		System.out.println(count[n]);
	}

	public static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> o1.cost - o2.cost);
		count[1] = 0;
		pq.add(new Node(1, 0));

		while (!pq.isEmpty()) {
			Node current = pq.remove();

			if (visited[current.index]) {
				continue;
			}
			visited[current.index] = true;

			for (Node n : graph.get(current.index)) {
				int index = n.index;
				int cost = n.cost;

				if (!visited[index] && count[index] > cost + count[current.index]) {
					count[index] = cost + count[current.index];
					pq.add(new Node(index, count[index]));
				}
			}
		}
	}

	static class Node {
		int index;
		int cost;

		public Node(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}
	}
}
