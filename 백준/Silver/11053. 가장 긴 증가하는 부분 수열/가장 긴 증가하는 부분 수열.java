import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;

  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    int[] dp = new int[N];
    Arrays.fill(dp, 1);

    st = new StringTokenizer(br.readLine());
    for (int i=0; i<N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < i; j++) {
        if (arr[j] < arr[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }

    int answer = 0;
    for (int i=0; i<dp.length; i++) {
      answer = Math.max(answer, dp[i]);
    }

    System.out.println(answer);
  }
}
