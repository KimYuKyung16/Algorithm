import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static int N, M;
  static int[] nums;
  static int[] sums;
  public static void main(String[] args) throws Exception {
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    nums = new int[N+1];
    sums = new int[N+1];

    st = new StringTokenizer(br.readLine());
    for (int i=1; i<=N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    getAllSum();

    StringBuilder sb = new StringBuilder();
    for (int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int sum = sums[e] - sums[s-1];
      sb.append(sum).append('\n');
    }

    System.out.println(sb.toString());
  }

  public static void getAllSum() {
    sums[1] = nums[1];
    for (int i=2; i<=N; i++) {
      sums[i] = sums[i-1] + nums[i];
    }
  }
}
