import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static List<List<Node>> tree = new ArrayList<>();
  static int N;
  static boolean[] visited;
  static int distance;
  static int v1, v2;
  static int answer;

  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());
    visited = new boolean[N+1];

    for (int i=0; i<=N; i++) {
      tree.add(new ArrayList<>());
    }

    for (int i=0; i<N-1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      tree.get(a).add(new Node(b, c));
      tree.get(b).add(new Node(a, c));
    }

    visited[1] = true;
    findV(1, 0);
    visited[1] = false;

    distance = 0;
    visited[v1] = true;
    findV(v1, 0);

    System.out.println(distance);
  }

  public static void findV(int v, int sum) {
    for (Node n : tree.get(v)) {
      if (visited[n.v]) continue;

      visited[n.v] = true;
      if (distance < sum+n.c) {
        v1 = n.v;
        distance = sum+n.c;
      }
      findV(n.v, sum+n.c);
      visited[n.v] = false;
    }
  }

  private static class Node {
    int v;
    int c;
    Node(int v, int c) {
      this.v = v;
      this.c = c;
    }
  }
}
