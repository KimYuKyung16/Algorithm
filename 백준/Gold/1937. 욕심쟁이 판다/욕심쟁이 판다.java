import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static int N;
  static int[][] map;
  static int[][] dp;
  static int[] dy = {-1,0,1,0};
  static int[] dx = {0,1,0,-1};

  public static void main(String[] args) throws Exception {
    N = Integer.parseInt(br.readLine());
    map = new int[N][N];
    dp = new int[N][N];
    for (int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j=0; j<N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        dp[i][j] = -1;
      }
    }

    int answer = 0;
    for (int i=0; i<N; i++) {
      for (int j=0; j<N; j++) {
        answer = Math.max(answer, dfs(i, j));
      }
    }
    System.out.println(answer);
  }

  public static int dfs(int y, int x) {
    if (dp[y][x] != -1) return dp[y][x];

    dp[y][x] = 1;

    for (int i=0; i<4; i++) {
      int ny = y + dy[i];
      int nx = x + dx[i];
      if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
      if (map[ny][nx] <= map[y][x]) continue;

      dp[y][x] = Math.max(dp[y][x], dfs(ny, nx) + 1);
    }

    return dp[y][x];
  }
}