import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static int[] dy = {-1,0,1,0};
  static int[] dx = {0,1,0,-1};
  static int sd = 1; // 오른쪽 방향부터 시작

  public static void main(String[] args) throws Exception {
    int time = 1;
    int N = Integer.parseInt(br.readLine());
    int K = Integer.parseInt(br.readLine());
    int[][] map = new int[N][N];

    Deque<Node> snake = new LinkedList<>();
    snake.add(new Node(0,0));
    map[0][0] = 1;

    for (int i=0; i<K; i++) {
      st = new StringTokenizer(br.readLine());
      int y = Integer.parseInt(st.nextToken())-1;
      int x = Integer.parseInt(st.nextToken())-1;
      map[y][x] = 2;
    }

    int L = Integer.parseInt(br.readLine());
    Map<Integer, String> info = new HashMap<>();
    for (int i=0; i<L; i++) {
      st = new StringTokenizer(br.readLine());
      int X = Integer.parseInt(st.nextToken()); // x초 뒤에 방향 전환
      String C = st.nextToken(); // L은 왼, D는 오 90도 회전
      info.put(X, C);
    }

    while(true) {
      Node head = snake.peekFirst();

      int hny = head.y + dy[sd];
      int hnx = head.x + dx[sd];

      if (hny < 0 || hny >= N || hnx < 0 || hnx >= N) break; // 벽에 부딪힘.
      if (map[hny][hnx] == 1) break; // 자기자신과 부딪힘.  

      snake.addFirst(new Node(hny, hnx));

      if (map[hny][hnx] == 2) { 
        // 1.사과가 있는 경우
        map[hny][hnx] = 1;
      } else { 
        // 2. 사과가 없는 경우
        map[hny][hnx] = 1;
        Node tail = snake.peekLast();
        map[tail.y][tail.x] = 0;
        snake.removeLast();
      }

      // 방향 변환 여부?
      if (info.get(time) != null) {
        change_direction(info.get(time));
      }

      time++;
    }
  
    System.out.println(time);
  }

  public static void change_direction(String c) {
    if (c.equals("L")) {
      sd = (sd + 3) % 4;
    } else if (c.equals("D")) {
      sd = (sd + 1) % 4;
    }
  } 

  static class Node {
    int y;
    int x;

    Node(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }

}

