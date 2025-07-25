import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
    
  public static void main(String[] args) throws Exception {
    StringBuilder sb = new StringBuilder();
    
    String line;
    while((line = br.readLine()) != null) {
      st = new StringTokenizer(line);
      String s = st.nextToken();
      char[] t = st.nextToken().toCharArray();

      int count = 0;
      int index = 0;
      for (char c : s.toCharArray()) {
        for (int i=index; i<t.length; i++) {
          if (c == t[i]) {
            count++;
            index = i+1;
            break;
          }
        }
      }

      if (count == s.length()) {
        sb.append("Yes");
      } else {
        sb.append("No");
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }
}
