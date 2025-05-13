import java.util.*;
import java.io.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static int[] cards1;

  public static int get_first(int num) {
    int left = 0;
    int right = cards1.length;

    while(left < right) {
      int middle = (left + right) / 2;
      if (cards1[middle] < num) {
        left = middle + 1;
      } else {
        right = middle;
      }
    }

    return left;
  }

  public static int get_last(int num) {
    int left = 0;
    int right = cards1.length;

    while (left < right) {
      int middle = (left + right) / 2;
      if (cards1[middle] <= num) {
        left = middle + 1;
      } else {
        right = middle;
      }
    }

    return left;
  }

  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());
    cards1 = new int[N];
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

    Arrays.sort(cards1);

    StringBuilder sb = new StringBuilder(); 
    for (int num : cards2) {
      int count = get_last(num) - get_first(num);
      sb.append(count).append(" ");
    }
    System.out.println(sb); 
  }
}
