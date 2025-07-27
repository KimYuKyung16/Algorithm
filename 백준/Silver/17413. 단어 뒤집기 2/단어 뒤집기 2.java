import java.io.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    String S = br.readLine();
    StringBuilder result = new StringBuilder();

    StringBuilder sb = new StringBuilder();
    boolean isReverse = true;
    for (char c : S.toCharArray()) {
      if (c == '>') {
        isReverse = true;
        sb.append(c);
        result.append(sb);
        sb.setLength(0);
      } else if (c == '<'){
        isReverse = false;
        sb.reverse();
        result.append(sb);
        sb.setLength(0);
        sb.append('<');
      } else if (c == ' ') {
        if (isReverse) {
          sb.reverse();
        }
        sb.append(' ');
        result.append(sb);
        sb.setLength(0);
      } else {
        sb.append(c);
      }
    }

    if (sb.length() > 0) {
      if (isReverse) {
        sb.reverse();
      }
      result.append(sb);
    }
  
    System.out.println(result);
  }
}