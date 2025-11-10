import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static List<List<Node>> graph = new ArrayList<>();
  static int V,E,K;

  public static void main(String[] args) throws Exception {
    st = new StringTokenizer(br.readLine());
    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(br.readLine()); // 시작 번호
    
    for (int i=0; i<=V; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i=0; i<E; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
    
      graph.get(u).add(new Node(v, w));
    }

    dijkstra(K);
  }

  public static void dijkstra(int s) {
    PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.w - b.w);
    int[] dists = new int[V+1];
    Arrays.fill(dists, Integer.MAX_VALUE);
    pq.add(new Node(s, 0));
    dists[s] = 0;

    while(!pq.isEmpty()) {
      Node c = pq.poll();
      int cv = c.v;
      int cw = c.w;

      if (cw > dists[cv]) continue;

      for (Node n : graph.get(cv)) {
        int newCost = cw + n.w;
        if (newCost < dists[n.v]) {
          dists[n.v] = newCost;
          pq.add(new Node(n.v, newCost));
        } 
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i=1; i<dists.length; i++) {
      if (dists[i] == Integer.MAX_VALUE) {
        sb.append("INF");
      } else {
        sb.append(dists[i]);
      }
      sb.append('\n');
    }

    System.out.println(sb.toString());
  }

  private static class Node {
    int v;
    int w;

    Node(int v, int w) {
      this.v = v;
      this.w = w;
    }
  }
}
