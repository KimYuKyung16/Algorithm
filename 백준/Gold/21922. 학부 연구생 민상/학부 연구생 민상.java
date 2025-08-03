import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static int[][] map;
  static int N, M;
  static int[][][] visited;
  static int[] dy = {-1, 0, 1, 0};
  static int[] dx = {0, 1, 0, -1};
  static List<int[]> eList = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    visited = new int[N][M][4]; // 4방향의 visited를 확인
    for (int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j=0; j<M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());

        if (map[i][j] == 9) { // 에어컨
          eList.add(new int[] {i, j});
          visited[i][j][0] = 1;
        }
      }
    }

    // 에어컨 틀기 시작
    for (int[] e : eList) {
      for (int i=0; i<4; i++) {
        int sy = e[0] + dy[i];
        int sx = e[1] + dx[i];
        dfs(sy, sx, i);
      }
    }

    int answer = 0;
    for (int i=0; i<N; i++) {
      for (int j=0; j<M; j++) {
        for (int k=0; k<4; k++) {
          if (visited[i][j][k] == 1) {
            answer++;
            break;
          }
        }
      }
    }
    
    System.out.println(answer);
  }

  public static void dfs(int y, int x, int d) {
    if (y < 0 || y >= N || x < 0 || x >= M) return;

    if (map[y][x] == 0) {
      visited[y][x][d] = 1;
      int ny = y + dy[d];
      int nx = x + dx[d];
      dfs(ny, nx, d);
    } else { // 물건이 있는 경우
      if (visited[y][x][d] == 1) return;
      visited[y][x][d] = 1;
      int nd = get_direction(d, map[y][x]);
      int ny = y + dy[nd];
      int nx = x + dx[nd];
      dfs(ny, nx, nd);
    }
  }

  // 상0, 우1, 하2, 좌3
  public static int get_direction(int originalD, int thing) {
    int newD = originalD;

    switch(thing) {
      case 1:
        if (originalD == 0 || originalD == 2) { // 상하
          newD = originalD;
        } else if (originalD == 1 || originalD == 3) { // 좌우
          newD = (originalD + 2) % 4;
        }
        break;
      case 2:
        if (originalD == 0 || originalD == 2) { // 상하
          newD = (originalD + 2) % 4;
        } else if (originalD == 1 || originalD == 3) { // 좌우
          newD = originalD;
        }
        break;
      case 3:
        if (originalD == 0) { // 상
          newD = 1;
        } else if (originalD == 1) { // 우
          newD = 0;
        } else if (originalD == 2) { // 하
          newD = 3;
        } else if (originalD == 3) { // 좌
          newD = 2;
        }
        break;
      case 4:
        if (originalD == 0) { // 상
          newD = 3;
        } else if (originalD == 1) { // 우
          newD = 2;
        } else if (originalD == 2) { // 하
          newD = 1;
        } else if (originalD == 3) { // 좌
          newD = 0;
        }
        break;
      default:
        break;
    }

    return newD;
  }
  
}
