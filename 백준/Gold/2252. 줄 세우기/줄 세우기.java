import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static List<List<Integer>> graph = new ArrayList<>();
  static int[] costs;
  
  public static void main(String[] args) throws Exception {
    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    costs = new int[N+1];

    for (int i=0; i<=N; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      graph.get(A).add(B);
      costs[B]++;
    }

    Queue<Integer> queue = new LinkedList<>();
    for (int i=1; i<costs.length; i++) {
      if (costs[i] == 0) queue.add(i);
    }

    List<Integer> list = new ArrayList<>();
    while(!queue.isEmpty()) {
      int cur = queue.poll();
      
      list.add(cur);
      for (int n : graph.get(cur)) {
        costs[n]--;
        if (costs[n] == 0) {
          queue.add(n);
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int n : list) {
      sb.append(n).append(" ");
    }
    System.out.println(sb.toString());
  }
}
