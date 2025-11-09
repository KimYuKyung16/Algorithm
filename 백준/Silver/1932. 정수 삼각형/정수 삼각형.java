import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static int N;
  static ArrayList<Integer>[] dp;
  
  public static void main(String[] args) throws Exception {
    N = Integer.parseInt(br.readLine());
    dp = new ArrayList[N];
    for (int i=0; i<N; i++) {
      dp[i] = new ArrayList<>();
    }
    for (int i=0; i<N; i++) {
      for (int j=0; j<i+1; j++) {
        dp[i].add(0);
      }
    }

    dp[0].set(0, Integer.parseInt(br.readLine()));
    for (int i=1; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j=0; j<=i; j++) {
        int cur = Integer.parseInt(st.nextToken());
        if (j == 0) {
          dp[i].set(j, Math.max(dp[i-1].get(j), cur + dp[i-1].get(j)));
        } else if (j == i) {
          dp[i].set(j, Math.max(dp[i-1].get(j-1), cur + dp[i-1].get(j-1)));
        } else {
          dp[i].set(j, Math.max(cur + dp[i-1].get(j-1), cur + dp[i-1].get(j)));
        }
      }
    }

    int answer = 0;
    for (int i=0; i<N; i++) {
      answer = Math.max(answer, dp[N-1].get(i));
    }

    System.out.println(answer);
  }
}
