import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
    
  public static void main(String[] args) throws Exception{
    int N = Integer.parseInt(br.readLine());
    ArrayList<int[]> lecture_list = new ArrayList<>();
    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]); 
    int answer = 0;

    for (int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      int num = Integer.parseInt(st.nextToken());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      lecture_list.add(new int[] {start, end});
    }

    lecture_list.sort((a, b) -> a[0] - b[0]);

    for (int i=0; i<N; i++) {
      if (pq.isEmpty()) {
        pq.add(lecture_list.get(0));
        lecture_list.remove(0);
      } else {
        int[] first = pq.peek();
        int[] current = lecture_list.get(0);

        if (first[1] <= current[0]) { // 강의실 이용 가능
          pq.poll();
          pq.add(lecture_list.get(0));
          lecture_list.remove(0);
        } else {
          pq.add(lecture_list.get(0));
          lecture_list.remove(0);
        }
      }

      answer = Math.max(pq.size(), answer);
    }

    System.out.println(answer);
  }
}
