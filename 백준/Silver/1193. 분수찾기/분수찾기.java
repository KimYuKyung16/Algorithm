import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine()); // 찾을 번째
		
		int i = 1;
		int j = 1;
		int order = 1;
		int count = 1;
		
		while(count != x) {
			if (order%2 == 0) { // 짝수일 경우
				if (j == 1) {
					order++;
					i++;
				} else {
					i++;
					j--;
				}
			} else { // 홀수일 경우
				if (i == 1) {
					order++;
					j++;
				} else {
					i--;
					j++;
				}
			}
            count++;
		}
		
		System.out.printf("%d/%d", i, j);
	}
}