import java.io.*;

public class Main {
	static BufferedReader br;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		int currentNum = 666;
		
		while (count != n) {
			if (String.valueOf(currentNum).contains("666")) {
				count++;
			}
			currentNum++;
		}
		
		System.out.println(--currentNum);
	}
}
