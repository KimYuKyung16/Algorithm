import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static LinkedList<Integer> nums = new LinkedList<Integer>(); // 숫자들
	static ArrayList<Integer> answer = new ArrayList<Integer>(); // 답

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // n명까지
		int k = Integer.parseInt(st.nextToken()); // k번째 사람
		int index = k - 1;

		for (int i = 0; i < n; i++) {
			nums.add(i + 1);
		}

		while (answer.size() != n) {
			int currentNum = nums.get(index);
			answer.add(currentNum);
			nums.remove(index);

			if (nums.size() != 0) {
				index = (index + k - 1) % nums.size();
			}
		}

		System.out.print("<");
		for (int i = 0; i < answer.size(); i++) {
			if (i == answer.size() - 1) {
				System.out.print(answer.get(i));
				continue;
			}
			System.out.print(answer.get(i) + ", ");
		}
		System.out.print(">");
	}
}
