import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static int N, K;

  public static void main(String[] args) throws Exception {
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    System.out.println(move());
  }

  public static int move() {
    Deque<int[]> deque = new LinkedList<>();
    int[] visited = new int[100001];

    for (int i=0; i<visited.length; i++) {
      visited[i] = Integer.MAX_VALUE;
    }
    
    deque.add(new int[] {N, 0});
    visited[N] = 0;
    while(!deque.isEmpty()) {
      int[] cur = deque.pollFirst();
      int v = cur[0];
      int t = cur[1];

      if (v == K) {
        return t;
      }

      if (v*2 < 100001 && t < visited[v*2]) {
        visited[v*2] = t;
        deque.addFirst(new int[] {v*2, t});
      }
      if (v-1 >= 0 && t < visited[v-1]) {
        visited[v-1] = t;
        deque.addLast(new int[] {v-1, t+1});
      }
      if (v+1 < 100001 && t < visited[v+1]) {
        visited[v+1] = t;
        deque.addLast(new int[] {v+1, t+1});
      }
    }

    return 0;
  }
}