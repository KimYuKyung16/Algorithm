import java.util.*;
import java.io.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;

  public static void main(String[] args) throws Exception {
    int n = Integer.parseInt(br.readLine());
    int[] num_list = new int[n];
    int answer = 0;

    st = new StringTokenizer(br.readLine());
    for (int i=0; i<n; i++) {
      num_list[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(num_list);

    int x = Integer.parseInt(br.readLine());

    int start = 0;
    int last = num_list.length-1;
    while(true) {
      if (last <= start) break;
      if (num_list[start] + num_list[last] < x) {
        start++;
      } else if (num_list[start] + num_list[last] == x) {
        answer++;
        start++;
        last--;
      } else {
        last--;
      }
    }

    System.out.println(answer);
  }
}
