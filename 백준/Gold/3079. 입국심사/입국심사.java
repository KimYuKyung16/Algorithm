import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static long min = 1, max = 0, answer = 0;
  static int N, M;
  static long[] times;
  public static void main(String[] args) throws Exception {
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // 심사대 수
    M = Integer.parseInt(st.nextToken()); // 사람 수
    times = new long[N];
    for (int i=0; i<N; i++) {
      long time = Integer.parseInt(br.readLine());
      max = Math.max(max, time);
      times[i] = time;
    }
    search();
    System.out.println(answer);
  }
  public static void search() {
    long left = min;
    long right = max * M;
    while(left <= right) {
      long middle = (left + right) / 2;
      if (is_possible(middle)) {
        answer = middle;
        right = middle - 1;
      } else {
        left = middle + 1;
      }
    }
  }
  // 모든 사람들이 심사받을 수 있는가?
  public static boolean is_possible(long time) {
    long sum = 0;
    for (long t : times) {
      long count = time / t;
      sum += count;
      if (sum >= M) return true;
    }
    return false;
  }
}
