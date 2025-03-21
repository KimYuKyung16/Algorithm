import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  public static void main(String[] args) throws Exception{
    int N = Integer.parseInt(br.readLine());
    int[] U = new int[N];

    for (int i=0; i<N; i++) {
      U[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(U);

    for (int i=N-1; i>=0; i--) {
      int pick = U[i]; // 만들 숫자

      for (int j=i; j>=0; j--) {
        int third = U[j];

        int start = 0;
        int last = j;
        while(true) {
          if (start > last) break;
          if (third + U[start] + U[last] < pick) {
            start++;
          } else if (third + U[start] + U[last] == pick) {
            System.out.println(pick);
            return;
          } else {
            last--;
          }
        }
      }
    }
  }
}
