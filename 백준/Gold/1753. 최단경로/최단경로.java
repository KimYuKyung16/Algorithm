import java.io.*;
import java.util.*;

class Node {
  int v;
  int d;

  Node(int v, int d) {
    this.v = v;
    this.d = d;
  }
}

public class Main {
  static BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static StringTokenizer st;
  static List<List<Node>> graph = new ArrayList<>();
  static int[] distances;

  public static void main(String[] args) throws Exception {
    st = new StringTokenizer(br.readLine());
    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(br.readLine());
    distances = new int[V+1];
    Arrays.fill(distances, Integer.MAX_VALUE);

    for (int i = 0; i <= V; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i=0; i<E; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken()); // 가중치

      graph.get(u).add(new Node(v, w));
    }

    dijkstra(K);

    StringBuilder sb = new StringBuilder();
    for (int i=1; i<distances.length; i++) {
      if (distances[i] == Integer.MAX_VALUE) {
        sb.append("INF").append("\n");
      } else {
        sb.append(distances[i]).append("\n");
      }
    }
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  public static void dijkstra(int start) {
    PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> {
      return Integer.compare(a.d, b.d);
    });
    distances[start] = 0;
    queue.add(new Node(start, 0));

    while (!queue.isEmpty()) {
      Node current = queue.poll();
      int currentV = current.v;
      int currentD = current.d;

      if (currentD > distances[currentV]) continue;

      for (Node neighbor : graph.get(currentV)) {
        int newDist = distances[currentV] + neighbor.d;

        if (newDist < distances[neighbor.v]) {
          distances[neighbor.v] = newDist;
          queue.add(new Node(neighbor.v, newDist));
        }
      }
    }
  }
}
