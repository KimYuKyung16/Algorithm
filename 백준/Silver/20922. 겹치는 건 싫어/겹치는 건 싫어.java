import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] arr;
	static int answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		arr = new int[n];
		int[] count = new int[200001];
		ArrayList<Integer> pick = new ArrayList<Integer>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			pick.add(arr[i]);
			count[arr[i]]++;

			if (count[arr[i]] > k) {
				while (true) {
					if (pick.get(0) == arr[i]) {
						pick.remove(0);
						count[arr[i]]--;
						break;
					}
					count[pick.get(0)]--;
					pick.remove(0);
				}
			}

			answer = Math.max(answer, pick.size());
		}

		System.out.println(answer);
	}
}
