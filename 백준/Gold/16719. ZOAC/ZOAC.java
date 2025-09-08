import java.io.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static String str;
  static boolean[] visited;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    str = br.readLine();
    visited = new boolean[str.length()];

    dfs(0, str.length());

    System.out.println(sb.toString());
  }

  public static void dfs(int left, int right) {
    if (left >= right) return;

    int idx = left;
    for (int i=left; i<right; i++) {
      if (str.charAt(i) < str.charAt(idx)) {
        idx = i;
      }
    }
    visited[idx] = true;

    for (int i=0; i<str.length(); i++) {
      if (visited[i]) {
        sb.append(str.charAt(i));
      }
    }
    sb.append("\n");

    dfs(idx+1, right);
    dfs(left, idx);
  }
}
