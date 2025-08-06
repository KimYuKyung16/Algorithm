import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static int N, M, R;
  static int[][] arr;

  public static void main(String[] args) throws Exception {
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // 행
    M = Integer.parseInt(st.nextToken()); // 열
    R = Integer.parseInt(st.nextToken()); // 회전 횟수
    arr = new int[N][M];

    for (int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j=0; j<M; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // 배열 회전
    for (int i=0; i<R; i++) {
      rotate();
    }

    StringBuilder sb = new StringBuilder();
    for (int i=0; i<arr.length; i++) {
      for (int j=0; j<arr[0].length; j++) {
        sb.append(arr[i][j]).append(" ");
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }

  // N 행, M 열
  public static void rotate() {
    int count = Math.min(N, M) / 2;

    for (int i=0; i<count; i++) {
      int temp = arr[i][i];
      // 위쪽
      for (int j=i+1; j<M-i; j++) { 
        arr[i][j-1] = arr[i][j];
      }
      // 오른쪽
      for (int j=i+1; j<N-i; j++) {
        arr[j-1][M-i-1] = arr[j][M-i-1];
      }
      // 아래쪽
      for (int j=M-i-2; j>=i; j--) {
        arr[N-i-1][j+1] = arr[N-i-1][j]; 
      }
      // 왼쪽
      for (int j=N-2-i; j>i; j--) {
        arr[j+1][i] = arr[j][i];
      }

      arr[i+1][i] = temp;
    }
  }
}
