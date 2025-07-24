import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static int N, M;
  static char[][] map;
  static int answer = -1;
  
  public static void main(String[] args) throws Exception {
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new char[N][M];

    for (int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      char[] tmp = st.nextToken().toCharArray();
      for (int j=0; j<M; j++) {
        map[i][j] = tmp[j];
      }
    }

    for (int y=0; y<N; y++) {
      for (int x=0; x<M; x++) {
        for (int i=-N; i<=N; i++) {
          for (int j=-M; j<=M; j++) {
            if (i == 0 && j == 0) continue;
            getNum(y, x, i, j, new StringBuilder().append(map[y][x]));
          }
        }
      }
    }

    System.out.println(answer);
  }

  public static void getNum(int y, int x, int dy, int dx, StringBuilder sb) {
    while(true) {
      if (sb.charAt(0) == 0) {
        answer = Math.max(answer, 0);
        break;
      } else {
        // 완전 제곱수인가?
        int num = Integer.parseInt(sb.toString());
        int sNum = (int) Math.sqrt(num);

        if (sNum * sNum == num) {
          answer = Math.max(answer, num);
        }
      }

      y += dy;
      x += dx;

      if (y < 0 || y >= N || x < 0 || x >= M) break;
      sb.append(map[y][x]);
    }
  }
}
