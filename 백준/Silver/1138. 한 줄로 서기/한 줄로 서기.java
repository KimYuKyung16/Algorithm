import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] people = new int[n];
		ArrayList<Integer> height = new ArrayList<Integer>();

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = n - 1; i >= 0; i--) {
			height.add(people[i], i + 1);
		}

		for (int i = 0; i < n; i++) {
			System.out.print(height.get(i) + " ");
		}
	}
}
