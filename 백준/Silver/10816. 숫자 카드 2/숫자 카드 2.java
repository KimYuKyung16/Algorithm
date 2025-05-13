import java.util.*;
import java.io.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;

  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());
    int[] cards1 = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i=0; i<N; i++) {
      cards1[i] = Integer.parseInt(st.nextToken());
    }

    int M = Integer.parseInt(br.readLine());
    int[] cards2 = new int[M];
    st = new StringTokenizer(br.readLine());
    for (int i=0; i<M; i++) {
      cards2[i] = Integer.parseInt(st.nextToken());
    }

    Map<Integer, Integer> list = new HashMap<>();

    for (int num : cards1) {
      if (list.containsKey(num)) {
        list.put(num, list.get(num) + 1);
      } else {
        list.put(num, 1);
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int num : cards2) {
      sb.append(list.get(num) != null ? list.get(num) : 0).append(" ");
    }
    System.out.println(sb);
  }
}