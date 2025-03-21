import java.util.*;
import java.io.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  public static void main(String[] args) throws Exception {
    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a-b);
    ArrayList<Integer> arr = new ArrayList<>();
    int time = 0;

    st = new StringTokenizer(br.readLine());
    for (int i=0; i<N; i++) {
      int t = Integer.parseInt(st.nextToken());
      arr.add(t);
    }

    arr.sort((a,b) -> b-a);

    while(true) {
      if (pq.size() < M) {
        int size = pq.size();
        for (int i=0; i<M-size; i++) {
          if (arr.size() == 0) break;
          pq.add(arr.get(0));
          arr.remove(0);
        }
      } 

      if (pq.size() == 0) break;
      int current = pq.poll();

      while(!pq.isEmpty() && pq.peek() == current) {
        pq.poll();
      }

      ArrayList<Integer> temp = new ArrayList<>();
      for (int num : pq) {
        temp.add(num);
      }
      pq.clear();
      for (int num : temp) {
        pq.add(num - current);
      }

      time += current;
    }
      
    System.out.println(time);
  }
}
