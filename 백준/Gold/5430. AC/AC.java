import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static StringTokenizer st;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    int T = Integer.parseInt(br.readLine());

    for (int i=0; i<T; i++) {
      run();
    }

    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  public static void run() throws Exception {
    String p = br.readLine(); // 함수
    int n = Integer.parseInt(br.readLine());
    String inputList = br.readLine();
    String[] numList = inputList.substring(1, inputList.length()-1).split(",");

    ArrayList<String> list = new ArrayList<>();
    for (String num : numList) {
      if (num.equals("[") || num.equals("]")) continue;
      if (num.length() == 0) continue;
      list.add(num);
    }

    int direction = 0;
    for (char cmd : p.toCharArray()) {
      if (cmd == 'R') { // 뒤집기
        direction = direction == 1 ? 0 : 1;
      } else if (cmd == 'D') { // 버리기
        if (list.size() == 0) {
          sb.append("error").append("\n");
          return;
        }
        if (direction == 0) {
          list.remove(0);
        } else {
          list.remove(list.size()-1);
        }
      }
    }
    if (direction == 1) Collections.reverse(list);
    sb.append("["+String.join(",", list)+"]").append("\n");
  }
}
