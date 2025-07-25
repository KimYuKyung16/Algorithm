import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
    
  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine()); // 크레인
    int[] limits = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i=0; i<N; i++) {
      limits[i] = Integer.parseInt(st.nextToken());
    }
    
    int M = Integer.parseInt(br.readLine()); // 박스
    ArrayList<Integer> boxes = new ArrayList<>();
    st = new StringTokenizer(br.readLine());
    for (int i=0; i<M; i++) {
      boxes.add(Integer.parseInt(st.nextToken()));
    }

    Arrays.sort(limits);
    boxes.sort((a,b) -> b-a);
    int time = 0;
    while(boxes.size() > 0) {
      if (limits[limits.length-1] < boxes.get(0)) {
        time = -1;
        break;
      }

      for (int i=limits.length-1; i>=0; i--) {
        for (int j=0; j<boxes.size(); j++) {
          if (boxes.get(j) <= limits[i]) {
            boxes.remove(j);
            break;
          }
        }
      }

      time++;
    }

    System.out.println(time);
  }
}
