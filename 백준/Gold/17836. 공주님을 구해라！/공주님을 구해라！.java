import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static int[][] map;
  static int[] dy = {1,0,-1,0};
  static int[] dx = {0,1,0,-1};

  public static void main(String[] args) throws Exception {
    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int T = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    for (int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j=0; j<M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int time = move(N, M, T);

    if (time == Integer.MAX_VALUE) {
      System.out.println("Fail");
    } else {
      System.out.println(time);
    }
  }

  public static int move(int N, int M, int T) {
    int answer = Integer.MAX_VALUE;
    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(0,0,0, map[0][0] == 2 ? true : false));
    boolean[][][] visited = new boolean[N][M][2]; // 0:무기X, 1:무기O

    while(!queue.isEmpty()) {
      Node cur = queue.poll();

      if (cur.t > T) continue; 
      if (cur.y == N-1 && cur.x == M-1) {
        answer = cur.t;
        return answer;
      }

      for (int i=0; i<4; i++) {
        int ny = cur.y + dy[i];
        int nx = cur.x + dx[i];
        int nTime = cur.t+1;

        if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
        if (visited[ny][nx][cur.weapon ? 1 : 0]) continue;
        if (map[ny][nx] == 1) { // 벽O
          if (cur.weapon) {
            visited[ny][nx][1] = true;
            queue.add(new Node(ny, nx, nTime, cur.weapon));
          } else {
            continue;
          }
        } else if (map[ny][nx] == 0) { // 벽X
          visited[ny][nx][cur.weapon ? 1 : 0] = true;
          queue.add(new Node(ny, nx, nTime, cur.weapon));
        } else if (map[ny][nx] == 2) {
          visited[ny][nx][cur.weapon ? 1 : 0] = true;
          queue.add(new Node(ny, nx, nTime, true));
        }
      }
    }

    return answer;
  }

  private static class Node {
    int y, x;
    int t;
    boolean weapon = false;

    Node(int y, int x, int t, boolean weapon) {
      this.y = y;
      this.x = x;
      this.t = t;
      this.weapon = weapon;
    }
  }

}

