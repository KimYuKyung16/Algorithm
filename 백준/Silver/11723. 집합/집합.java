import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  public static void main(String[] args) throws Exception {
    int M = Integer.parseInt(br.readLine());
    int S = 0;

    StringBuilder sb = new StringBuilder();
    for (int i=0; i<M; i++) {
      String input = br.readLine();

      if (input.equals("all")) {
        S = S | ((1 << 21) - 1);
      } else if (input.equals("empty")) {
        S = S & ((1 << 21));
      } else {
        st = new StringTokenizer(input);
        String command = st.nextToken();
        int num = Integer.parseInt(st.nextToken());
        switch(command) {
          case "add": 
            S = S | (1 << num);
            break;
          case "remove":
            S = S & ~(1 << num);
            break;
          case "check":
            sb.append(1 & (S >> num)).append("\n");
            break;
          case "toggle":
            S = S ^ (1 << num);
            break;
        }
      }
    }
    System.out.println(sb);
  }
}
