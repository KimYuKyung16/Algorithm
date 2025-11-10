import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static int N, M;
  static char[][] board;
  static int[][] dp;
  static int[][] visited;
  static int[] dy = {-1,0,1,0};
  static int[] dx = {0,1,0,-1};
  static int answer = 0;

  public static void main(String[] args) throws Exception {
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    board = new char[N][M];
    dp = new int[N][M];
    visited = new int[N][M];
    
    for (int i=0; i<N; i++) {
      String input = br.readLine();
      for (int j=0; j<M; j++) {
        board[i][j] = input.charAt(j);
      }
    }

    visited[0][0] = 1;
    dfs(0,0);

    if (answer == -1) {
      System.out.println(answer);
      return;
    } else {
      System.out.println(dp[0][0]);
    }
  }

  public static int dfs(int y, int x) {
    if (answer == -1) return 0;
    if (dp[y][x] != 0) return dp[y][x];

    dp[y][x] = 1;

    for (int i=0; i<4; i++) {
      int ny = y + (dy[i] * (board[y][x] - '0'));
      int nx = x + (dx[i] * (board[y][x] - '0'));

      if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
      // 동전을 무한번 움직이는 경우
      if (visited[ny][nx] == 1) {
        answer = -1;
        return 0;
      }
      if (board[ny][nx] == 'H') continue;
      
      visited[ny][nx] = 1;
      dp[y][x] = Math.max(dp[y][x], dfs(ny, nx) + 1);
      visited[ny][nx] = 0;
    }

    return dp[y][x];
  }
}
