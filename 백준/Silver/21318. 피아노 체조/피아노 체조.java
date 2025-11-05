import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;

  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());
    int[] scores = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i=0; i<N; i++) {
      scores[i] = Integer.parseInt(st.nextToken());
    }

    int[] sums = new int[N];
    sums[0] = 0;
    for (int i=1; i<N; i++) {
      if (scores[i] < scores[i-1]) {
        sums[i] = sums[i-1] + 1;
      } else {
        sums[i] = sums[i-1];
      }
    }
  
    StringBuilder sb = new StringBuilder();
    int Q = Integer.parseInt(br.readLine());
    for (int i=0; i<Q; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      sb.append(sums[y-1] - sums[x-1]).append('\n');
    }

    System.out.println(sb.toString());
  }
}
