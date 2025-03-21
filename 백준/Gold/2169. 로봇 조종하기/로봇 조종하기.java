import java.util.*;
import java.io.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static int N, M;
  static int[][] map, dp, temp;

  public static void main(String[] args) throws Exception {
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N+1][M+1];
    dp = new int[N+1][M+1];
    temp = new int[2][M+2];

    for (int i=1; i<=N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j=1; j<=M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i=1; i<=M; i++) {
      dp[1][i] = dp[1][i-1] + map[1][i];
    }

    for (int i=2; i<=N; i++) {
      // 왼 -> 오
      temp[0][0] = dp[i-1][1];
      for (int j=1; j<=M; j++) {
        temp[0][j] = Math.max(dp[i-1][j], temp[0][j-1]) + map[i][j];
      }
      // 오 -> 왼
      temp[1][M+1] = dp[i-1][M];
      for (int j=M; j>=1; j--) {
        temp[1][j] = Math.max(dp[i-1][j], temp[1][j+1]) + map[i][j];
      }

      for (int j=1; j<=M; j++) {
        dp[i][j] = Math.max(temp[0][j], temp[1][j]);
      }
    }

	System.out.println(dp[N][M]);
  }
}
