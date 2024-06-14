import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] topList;
	static int[] bottomList;
	static boolean[] visited;
	static int start;
	static ArrayList<Integer> pick = new ArrayList<Integer>();
	static boolean[] tmpVisited;

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		topList = new int[n + 1];
		bottomList = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			topList[i] = i;
			bottomList[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 1; i <= n; i++) {
			visited = new boolean[n + 1];
			tmpVisited = new boolean[n + 1];
			start = i;
			visited[topList[i]] = true;
			tmpVisited[topList[i]] = true;
			dfs(topList[i]);
		}

		pick.sort(null);
		Set<Integer> set = new TreeSet<>(pick);
		System.out.println(set.size());
		for (Integer item : set) {
			System.out.println(item);
		}
	}

	public static void dfs(int current) {
		if (visited[bottomList[current]]) {
			if (bottomList[current] == start) {
				for (int i = 1; i < tmpVisited.length; i++) {
					if (tmpVisited[i]) {
						pick.add(i);
					}
				}
			}
			return;
		}

		visited[bottomList[current]] = true;
		tmpVisited[bottomList[current]] = true;
		dfs(bottomList[current]);
	}
}
