import java.util.*;
import java.io.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());
    int[] num_list = new int[N];
    int[] answer = new int[] { Integer.MAX_VALUE, 0, 0 }; // [특성값, 숫자1, 숫자2]

    st = new StringTokenizer(br.readLine());
    for (int i=0; i<N; i++) {
      int num = Integer.parseInt(st.nextToken());
      num_list[i] = num;
    }
    Arrays.sort(num_list);

    int start = 0;
    int last = num_list.length-1;

    while(true) {
      if (start >= last) break;
      if (num_list[start] + num_list[last] == 0) {
        answer = new int[] {Math.abs(num_list[start] + num_list[last]), num_list[start], num_list[last]};
        break;
      }

      if (Math.abs(num_list[start] + num_list[last]) < answer[0]) {
        answer = new int[] {Math.abs(num_list[start] + num_list[last]), num_list[start], num_list[last]};
      }
      if (num_list[start] + num_list[last] > 0) {
        last--;
      } else if (num_list[start] + num_list[last] < 0) {
        start++;
      }
    }

    System.out.println(answer[1] + " " + answer[2]);
  }
}
