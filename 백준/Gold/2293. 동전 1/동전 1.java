import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;

  public static void main(String[] args) throws Exception {
    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[] dp = new int[k+1];
    dp[0] = 1;
    for (int i=0; i<n; i++) {
      int coin = Integer.parseInt(br.readLine());
      for (int j=coin; j<=k; j++) {
        dp[j] = dp[j] + dp[j - coin];
      }
    }

    System.out.println(dp[k]);
  }
}
