import java.util.*;
import java.io.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());
    Integer[] list = new Integer[N];
    st = new StringTokenizer(br.readLine());
    for (int i=0; i<N; i++) {
      list[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(list);

    int M = Integer.parseInt(br.readLine());
    int[] compareList = new int[M];
    st = new StringTokenizer(br.readLine());
    for (int i=0; i<M; i++) {
      compareList[i] = Integer.parseInt(st.nextToken());
    }

    for (int num : compareList) {
      int middle = list.length / 2;
      int left = 0;
      int right = list.length - 1;

      boolean flag = false;
      while(left <= right) {
        if (list[middle] == num) {
          flag = true;
          break;
        } else if (list[middle] > num) {
          right = middle - 1;
          middle = (left + right) / 2;
        } else if (list[middle] < num) {
          left = middle + 1;
          middle = (left + right) / 2;
        }
      }
      if (flag) {
        System.out.println(1);
      } else {
        System.out.println(0);
      }
    }
  }
}