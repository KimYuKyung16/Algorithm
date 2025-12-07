import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static List<int[]> list = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());

    for (int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      list.add(new int[] {a, b});
    }

    list.sort((a,b) -> a[0] - b[0]);

    int[] dp = new int[N];
    Arrays.fill(dp, 1);

    for (int i=0; i<dp.length; i++) {
      for (int j=0; j<i; j++) {
        if (list.get(j)[1] < list.get(i)[1]) {
          dp[i] = Math.max(dp[i], dp[j]+1);
        }
      }
    }

    int max = 0;
    for (int i=0; i<dp.length; i++) {
      max = Math.max(max, dp[i]);
    }

    System.out.println(N-max);
  }
}
