import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static int INF = 10001;
  static int[] dp;

  public static void main(String[] args) throws Exception {
    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    dp = new int[K+1];

    Arrays.fill(dp, INF);
    dp[0] = 0;

    for (int i=0; i<N; i++) {
      int c = Integer.parseInt(br.readLine());
      for (int j = c; j <= K; j++) {
        dp[j] = Math.min(dp[j], dp[j - c] + 1);
      }
    }

    if (dp[K] == INF) {
      System.out.println(-1);
    } else {
      System.out.println(dp[K]);
    }
  }
}
