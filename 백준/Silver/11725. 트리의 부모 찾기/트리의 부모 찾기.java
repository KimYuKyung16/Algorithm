import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static List<Integer>[] tree;
  static int N;

  public static void main(String[] args) throws Exception {
    N = Integer.parseInt(br.readLine());

    tree = new ArrayList[N+1];
    for (int i=0; i<=N; i++) {
      tree[i] = new ArrayList<>();
    }

    for (int i=0; i<N-1; i++) {
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());

      tree[v1].add(v2);
      tree[v2].add(v1);
    }

    bfs();
  }

  public static void bfs() {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(1);
    int[] result = new int[N+1];
    boolean[] visited = new boolean[N+1];
    visited[1] = true;

    while(!queue.isEmpty()) {
      int cv = queue.poll();
      for (int v : tree[cv]) {
        if (visited[v]) continue;
        visited[v] = true;
        queue.add(v);
        result[v] = cv;  
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i=2; i<=N; i++) {
      sb.append(result[i]).append("\n");
    }

    System.out.println(sb);
  }
}
