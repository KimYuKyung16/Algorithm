import java.io.*;
import java.util.*;
public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static int N, S, answer = 0;
  static int[] nums;
  public static void main(String[] args) throws Exception {
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());
    nums = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i=0; i<N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }
    dfs(0, 0);
    if (S == 0) answer--;
    System.out.println(answer);
  }

  public static void dfs(int index, int sum) {
    if (index == N) {
      if (sum == S) answer++;
      return;
    }
    dfs(index+1, sum + nums[index]);
    dfs(index+1, sum);
  }
}
