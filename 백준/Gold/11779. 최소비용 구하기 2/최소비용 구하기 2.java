import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static int N, M;
  static int S, E;
  static ArrayList<ArrayList<Node>> list = new ArrayList<>();
  static int[] dists;
  static int[] prevs;

  public static void main(String[] args) throws Exception {
    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());
    prevs = new int[N+1];

    for (int i=0; i<=N; i++) {
      list.add(new ArrayList<>());
    }

    for (int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      list.get(s).add(new Node(e, c));
    }

    st = new StringTokenizer(br.readLine());
    S = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());

    dijkstra();

    int index = E;
    List<Integer> path = new ArrayList<>();
    while(index != 0) {
      path.add(index);
      index = prevs[index];
    }
    Collections.reverse(path);

    System.out.println(dists[E]);
    System.out.println(path.size());
    StringBuilder sb = new StringBuilder();
    for (int city : path) {
      sb.append(city).append(" ");
    }
    System.out.println(sb.toString());
  }

  public static void dijkstra() {
    PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.c - b.c);
    dists = new int[N+1];
    Arrays.fill(dists, Integer.MAX_VALUE);

    dists[S] = 0;
    pq.add(new Node(S, 0));

    while(!pq.isEmpty()) {
      Node cur = pq.poll();

      if (cur.c > dists[cur.v]) continue;

      for (Node next : list.get(cur.v)) {
        if (cur.c + next.c < dists[next.v]) {
          dists[next.v] = cur.c + next.c;
          prevs[next.v] = cur.v;
          pq.add(new Node(next.v, cur.c + next.c));
        }
      }
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
