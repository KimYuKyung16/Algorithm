import java.io.*;
import java.util.*;

// 1. 1 -> A -> B -> N
// 2. 1 -> B -> A -> N
public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static int N, E;
  static List<List<Node>> graph = new ArrayList<>();
  static int INF = 200000000;

  public static void main(String[] args) throws Exception {
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());
    
    for (int i=0; i<=N; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i=0; i<E; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      graph.get(a).add(new Node(b, c));
      graph.get(b).add(new Node(a, c));
    }

    st = new StringTokenizer(br.readLine());
    int v1 = Integer.parseInt(st.nextToken());
    int v2 = Integer.parseInt(st.nextToken());
    
    int answer1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
    int answer2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);
    int answer = Math.min(answer1, answer2);

    if (answer >= INF) {
      System.out.println(-1);      
    } else {
      System.out.println(Math.min(answer1, answer2));
    }
  }

  public static int dijkstra(int start, int end) {
    int[] dist = new int[N+1];
    Arrays.fill(dist, INF);
    PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.c - b.c);
    dist[start] = 0;
    pq.add(new Node(start, 0));

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

    if (dist[end] == INF) {
      return INF;
    } else {
      return dist[end];
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
