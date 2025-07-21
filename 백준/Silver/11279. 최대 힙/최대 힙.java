import java.util.*;
import java.io.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
    for (int i=0; i<N; i++) {
      int x = Integer.parseInt(br.readLine());

      if (x == 0) {
        if (pq.isEmpty()) {
          sb.append(0).append("\n");
        } else {
          sb.append(pq.poll()).append("\n");
        }
      } else {
        pq.add(x);
      }
    }

    System.out.println(sb);
  }
}
