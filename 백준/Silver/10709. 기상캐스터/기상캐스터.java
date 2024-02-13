import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		char[][] sky = new char[h][w];
		int[][] time = new int[h][w];

		for (int y = 0; y < h; y++) {
			String str = br.readLine();
			for (int x = 0; x < w; x++) {
				sky[y][x] = str.charAt(x);
			}
		}

		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				time[y][x] = -1;
				if (sky[y][x] == 'c') {
					time[y][x] = 0;
				} else {
					for (int i = x; i >= 0; i--) {
						if (sky[y][i] == 'c') {
							time[y][x] = Math.abs(x - i);
							break;
						}
					}
				}
			}
		}

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print(time[i][j] + " ");
			}
			System.out.println();
		}
	}
}
