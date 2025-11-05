import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;

  public static void main(String[] args) throws Exception {
    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[][] sums = new int[N+1][M+1];
    for (int i=1; i<=N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j=1; j<=M; j++) {
        sums[i][j] = sums[i-1][j] + sums[i][j-1] - sums[i-1][j-1] + Integer.parseInt(st.nextToken());  
      }
    }

    int answer = Integer.MIN_VALUE;
    for (int i=1; i<=N; i++) {
      for (int j=1; j<=M; j++) {
        for (int k=i; k<=N; k++) {
          for (int l=j; l<=M; l++) {
            int sum = sums[k][l] - sums[i-1][l] - sums[k][j-1] + sums[i-1][j-1];
            answer = Math.max(answer, sum);
          }
        }
      }
    }

    System.out.println(answer);
  }
}
