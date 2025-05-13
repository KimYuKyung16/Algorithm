import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static int N, M;
  static int max = 0, min = 0, answer = 0;
  static int[] trees;
  public static void main(String[] args) throws Exception {
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // 나무의 수
    M = Integer.parseInt(st.nextToken()); // 가져가야하는 나무 길이
    trees = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i=0; i<N; i++) {
      int num = Integer.parseInt(st.nextToken());
      max = Math.max(max, num);
      trees[i] = num;
    }
    search();
    System.out.println(answer);
  }

  public static void search() {
    while(min <= max) {
      int middle = (min + max) / 2;
      if(is_possible(middle)) {
        answer = middle;
        min = middle + 1;
      } else {
        max = middle - 1;
      }
    }
  }
  // 절단 가능?
  public static boolean is_possible(int length) {
    long sum = 0;
    for (int h : trees) {
      int count = h - length > 0 ? h - length : 0;
      sum += count;
    }
    return sum >= M;
  }
}
