import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static int INF = Integer.MAX_VALUE;
    
  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());

    int[][] dists = new int[N+1][N+1];

    for (int i=1; i<=N; i++) {
      for (int j=1; j<=N; j++) {
        if (i == j) dists[i][j] = 0;
        else dists[i][j] = INF;
      }
    }

    for (int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      dists[a][b] = Math.min(dists[a][b], c); 
    }

    for (int k=1; k<=N; k++) { // 중간 경유
      for (int i=1; i<=N; i++) { // 시작점
        for (int j=1; j<=N; j++) { // 끝지점
          if (dists[i][k] == INF || dists[k][j] == INF) continue;
          dists[i][j] = Math.min(dists[i][j], dists[i][k] + dists[k][j]);
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i=1; i<=N; i++) {
      for (int j=1; j<=N; j++) {
        if (dists[i][j] == INF) {
          sb.append("0" + " ");
        } else {
          sb.append(dists[i][j] + " ");
        }
      }
      sb.append("\n");
    }

    System.out.println(sb.toString());
  }
}
