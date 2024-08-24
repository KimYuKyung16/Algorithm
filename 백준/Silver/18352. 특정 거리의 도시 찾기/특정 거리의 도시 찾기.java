import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, K, X;
	static List<List<Edge>> graph = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 도시 개수
		M = Integer.parseInt(st.nextToken()); // 도로 개수
		K = Integer.parseInt(st.nextToken()); // 거리 정보
		X = Integer.parseInt(st.nextToken()); // 출발 도시의 번호

		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			graph.get(A).add(new Edge(B, 1));
		}

		dijkstra();
	}

	public static void dijkstra() {
		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[X] = 0;

		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		pq.add(new int[] { X, 0 });

		while (!pq.isEmpty()) {
			int[] current = pq.poll();
			int currentNode = current[0];
			int currentDist = current[1];

			if (currentDist > dist[currentNode])
				continue;

			for (Edge edge : graph.get(currentNode)) {
				int nextNode = edge.node;
				int newDist = currentDist + edge.weight;

				if (newDist < dist[nextNode]) {
					dist[nextNode] = newDist;
					pq.add(new int[] { nextNode, newDist });
				}
			}
		}

		int cnt = 0;
		for (int i = 0; i < dist.length; i++) {
			if (dist[i] == K) {
				System.out.println(i);
				cnt++;
			}
		}
		if (cnt == 0) {
			System.out.println(-1);
		}
	}

	public static class Edge {
		int node;
		int weight;

		public Edge(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}
	}
}
