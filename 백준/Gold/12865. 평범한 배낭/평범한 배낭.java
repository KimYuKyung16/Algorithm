import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;

  public static void main(String[] args) throws Exception {
    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int[] dp = new int[K+1];

    for (int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      int W = Integer.parseInt(st.nextToken());
      int V = Integer.parseInt(st.nextToken());

      for (int j=K; j>=W; j--) {
        dp[j] = Math.max(dp[j], dp[j-W] + V);
      }
    } 

    System.out.println(dp[K]);
  }
}