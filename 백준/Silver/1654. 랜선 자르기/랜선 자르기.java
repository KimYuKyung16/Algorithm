import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static int K, N;
  static long min = 1, max = 0, answer = 0;
  static int[] lines;
  public static void main(String[] args) throws Exception {
    st = new StringTokenizer(br.readLine());
    K = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    lines = new int[K];
    for (int i=0; i<K; i++)  {
      int line = Integer.parseInt(br.readLine());
      max = Math.max(max, line);
      lines[i] = line;
    }
    search();
    System.out.println(answer);
  }

  public static void search() {
    while(min <= max) {
      long middle = (max + min) / 2;
      if (is_possible(middle)) {
        answer = middle;
        min = middle + 1;
      } else {
        max = middle - 1;
      }
    }
  }
  // 랜선을 N개 이상 만들 수 있나?
  public static boolean is_possible(long length) {
    long sum = 0;
    for (int line : lines) {
      long count = line / length;
      sum += count;
    }
    return sum >= N;
  }
}
