import java.util.*;
import java.io.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;

  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);

    for (int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j=0; j<N; j++) {
        pq.add(Integer.parseInt(st.nextToken()));
      }
    }

    for (int i=0; i<N-1; i++) {
      pq.poll();
    }

    System.out.println(pq.poll());
  }
}
