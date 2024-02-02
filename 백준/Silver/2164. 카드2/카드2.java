import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static BufferedReader br;
	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}

		int index = 0;
		while (true) {
			if (queue.size() == 1)
				break;

			if (index % 2 == 0) {
				queue.remove();
			} else {
				queue.add(queue.remove());
			}
			index++;
		}

		System.out.println(queue.peek());
	}
}
