import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static List<Integer>[] tree;
  static int N;
  static boolean[] list;
    
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

    int Q = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i=0; i<Q; i++) {
      st = new StringTokenizer(br.readLine());
      int t = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());

      if (t == 2) {
        sb.append("yes").append("\n");
      } else {
        // 해당 정점이 단절점인지?
        if (tree[k].size() > 1) {
          sb.append("yes").append("\n");
        } else {
          sb.append("no").append("\n");
        }
      }
    }

    System.out.println(sb);
  }
}
