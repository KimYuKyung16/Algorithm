import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
    
  public static void main(String[] args) throws Exception {
    String line;
    StringBuilder sb = new StringBuilder();

    String mo = "aeiou";

    while(!(line = br.readLine()).equals("end")) {
      if (line.contains("eee") || line.contains("ooo")) {
        sb.append("<"+line+">" + "is not acceptable.").append("\n");
        continue;
      }

      boolean result = true;

      int jaCount = 0;
      int moCount = 0;
      boolean isMo = false;
      char prev = ' ';
      for (char c : line.toCharArray()) {
        if (mo.contains(String.valueOf(c))) {
          isMo = true;
          jaCount = 0;
          moCount++;
        } else {
          moCount = 0;
          jaCount++;
        }

        if (jaCount == 3 || moCount == 3) {
          result = false;
          break;
        }

        if (c == prev) {
          if (c != 'e' && c != 'o') {
            result = false;
            break;
          }
        }

        prev = c;
      }

      if (isMo && result) {
        sb.append("<"+line+">" + " is acceptable.").append("\n");
      } else {
        sb.append("<"+line+">" + " is not acceptable.").append("\n");
      }
    }

      System.out.println(sb);
  }
}
