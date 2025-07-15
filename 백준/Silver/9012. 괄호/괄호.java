import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  public static void main(String[] args) throws Exception {
    int T = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    for (int i=0; i<T; i++) {
      char[] list = br.readLine().toCharArray();
      String answer = "YES";
      int count = 0;

      for (char c : list) {
        if (c == '(') {
          count++;
        } else {
          if (count > 0) {
            count--;
          } else {
            answer = "NO";
            break;
          }
        }
      }

      if (count != 0) answer = "NO";
      sb.append(answer).append("\n");
    }

    System.out.println(sb);
  }
}
