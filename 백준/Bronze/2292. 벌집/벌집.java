import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int i = 1;
		int current = 6;
		int total = 1;
		while (true) {
			if (n <= total) {
				System.out.println(i);
				return;
			}
			total += (current * i);
			i++;
		}
	}
}
