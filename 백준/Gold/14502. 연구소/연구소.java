import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static int N, M;
  static int[][] map;
  static int[] dy = {-1,0,1,0};
  static int[] dx = {0,1,0,-1};
  static ArrayList<Node> viruses = new ArrayList<>();
  static int answer = 0;

  // 0은 빈칸, 1은 벽, 2는 바이러스
  public static void main(String[] args) throws Exception {
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][M];

    for (int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j=0; j<M; j++) {
        int c = Integer.parseInt(st.nextToken());
        if (c == 2) {
          viruses.add(new Node(i, j));
        }
        map[i][j] = c;
      }
    }

    dfs(0);

    System.out.println(answer);
  }

  public static void dfs(int count) {
    if (count == 3) {
      bfs();
      return;
    }

    for (int i=0; i<N; i++) {
      for (int j=0; j<M; j++) {
        if (map[i][j] == 0) {
          map[i][j] = 1;
          dfs(count+1);
          map[i][j] = 0;
        }
      }
    }
  }

  public static void bfs() {
    Queue<Node> queue = new LinkedList<>();
    int[][] nMap = new int[N][M];
    for (int i = 0; i < N; i++) {
        nMap[i] = map[i].clone(); 
    }

    for (Node n : viruses) {
      queue.add(n);
    }

    while(!queue.isEmpty()) {
      Node current = queue.poll();

      for (int i=0; i<4; i++) {
        int ny = current.y + dy[i];
        int nx = current.x + dx[i];

        if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
        if (nMap[ny][nx] == 1 || nMap[ny][nx] == 2) continue;

        nMap[ny][nx] = 2;
        queue.add(new Node(ny, nx));
      }
    }

    confirm(nMap);
  }

  public static void confirm(int[][] mapResult) {
    int count = 0;
    for (int i=0; i<N; i++) {
      for (int j=0; j<M; j++) {
        if (mapResult[i][j] == 0) {
          count++;
        }
      }
    }
    answer = Math.max(answer, count);
  }

  public static class Node {
    int y, x;

    Node(int y, int x) {
      this.y = y;
      this.x = x;
    }

    public String toString() {
      return "(" + y + "," + x + ")";
    }
  }
  
}
