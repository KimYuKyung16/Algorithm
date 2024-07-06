import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] != o2[0]) {
					return Integer.compare(o2[0], o1[0]);
				} else if (o1[1] != o2[1]) {
					return Integer.compare(o2[1], o1[1]);
				} else if (o1[2] != o2[2]) {
					return Integer.compare(o2[2], o1[2]);
				} else {
					return Integer.compare(o2[3], o1[3]); // 국가 번호로 비교
				}
			}
		});

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			pq.add(new int[] { g, s, b, c });
		}

		int grade = 0;
		int middle = 1;
		int[] pre = new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE };
		while (!pq.isEmpty()) {
			int[] c = pq.poll();
			if (c[0] == pre[0] && c[1] == pre[1] && c[2] == pre[2]) {
				middle++;
			} else {
				if (middle > 1) {
					grade += middle;
					middle = 1;
				} else {
					grade++;
				}

			}

			if (c[3] == k) {
				System.out.println(grade);
				break;
			}
			pre = c;
		}

	}
}