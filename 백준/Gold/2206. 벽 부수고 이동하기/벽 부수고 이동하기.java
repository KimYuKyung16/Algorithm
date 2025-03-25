import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static int[][] map;
  static int[] dy = {-1, 0, 1, 0};
  static int[] dx = {0, 1, 0, -1};
  static int N, M, answer = -1;
  public static void main(String[] args) throws Exception {
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][M];

    for (int i=0; i<N; i++) {
      String input = br.readLine();
      for (int j=0; j<M; j++) {
        map[i][j] = input.charAt(j) - '0'; // 벽 여부, 최소값
      }
    }

    bfs(0, 0);

    System.out.println(answer);
  }

  public static void bfs(int sy, int sx) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] { sy, sx, 1, 0 }); // y, x, count, isCrack
    boolean[][][] visited = new boolean[N][M][2];
    visited[sy][sx][0] = true;

    while(!queue.isEmpty()) {
      int[] current = queue.poll();
      int count = current[2];
      int isCrack = current[3];

      if (current[0] == N-1 && current[1] == M-1) { // 도착
        answer = count;
        return;
      }

      for (int i=0; i<4; i++) {
        int ny = dy[i] + current[0];
        int nx = dx[i] + current[1];

        if (ny >= N || ny < 0 || nx >= M || nx < 0) continue;

        if (map[ny][nx] == 0 && !visited[ny][nx][isCrack]) { // 벽X
          visited[ny][nx][isCrack] = true;
          queue.add(new int[] {ny, nx, count+1, isCrack});
        } else { // 벽O
          if (isCrack == 1) {
            continue;
          }  else {
            if (visited[ny][nx][1]) continue;
            visited[ny][nx][1] = true;
            queue.add(new int[] {ny, nx, count+1, 1});
          }
        }
      }
    }
  }
}
