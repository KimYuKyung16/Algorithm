import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static int N, M, X;
  static List<List<Node>> graph1 = new ArrayList<>();
  static List<List<Node>> graph2 = new ArrayList<>();
  static int INF = Integer.MAX_VALUE;
  static int[] list;

  public static void main(String[] args) throws Exception {
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    X = Integer.parseInt(st.nextToken());
    list = new int[N+1];

    for (int i=0; i<=N; i++) {
      graph1.add(new ArrayList<>());
      graph2.add(new ArrayList<>());
    }

    for (int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int t = Integer.parseInt(st.nextToken());
      graph1.get(s).add(new Node(e, t));
      graph2.get(e).add(new Node(s, t));
    }

    dijkstra(graph1);
    dijkstra(graph2);

    int answer = 0;
    for (int i=0; i<list.length; i++) {
      answer = Math.max(answer, list[i]);
    }

    System.out.println(answer);
  }

  public static void dijkstra(List<List<Node>> graph) {
    PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.c - b.c);
    int[] dist = new int[N+1];
    Arrays.fill(dist, INF);

    dist[X] = 0;
    pq.add(new Node(X, 0));
    while(!pq.isEmpty()) {
      Node cur = pq.poll();

      if (cur.c > dist[cur.v]) continue;

      for (Node next : graph.get(cur.v)) {
        int nCost = cur.c + next.c;
        if (nCost < dist[next.v]) {
          dist[next.v] = nCost;
          pq.add(new Node(next.v, nCost));
        }
      }
    }

    for (int i=1; i<dist.length; i++) {
      list[i] += dist[i];
    }
  }

  public static class Node {
    int v;
    int c;
    Node(int v, int c) {
      this.v = v;
      this.c = c;
    }
  }
}
