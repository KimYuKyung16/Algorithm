import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int l, c;
	static String[] alpa;
	static String alpa1 = "aeiou";
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		visited = new boolean[c];

		alpa = new String[c];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < c; i++) {
			alpa[i] = st.nextToken();
		}
		Arrays.sort(alpa);

		dfs("", 0, 0);
	}

	// 자음: con, 모음: gat
	public static void dfs(String str, int con, int gat) {
		if (str.length() == l) {
			if (con >= 1 && gat >= 2) {
				System.out.println(str);
			}
			return;
		}

		int index = 0;
		if (str.length() > 0) {
			index = Arrays.asList(alpa).indexOf(str.charAt(str.length() - 1) + "");
		}

		for (int i = index; i < alpa.length; i++) {
			if (visited[i]) {
				continue;
			}
			visited[i] = true;
			int nCon = con;
			int nGat = gat;
			if (alpa1.contains(alpa[i])) {
				nCon++;
			} else {
				nGat++;
			}
			dfs(str + alpa[i], nCon, nGat);
			visited[i] = false;
		}
	}
}
