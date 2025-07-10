import java.util.*;
import java.io.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static int N, L, R;
  static int[][] map;
  static boolean[][] visited;
  static int[] dy = {-1,0,1,0};
  static int[] dx = {0,1,0,-1};

  public static void main(String[] args) throws Exception {
    init();
    int day = 0;

    while(true) {
      if (open()) {
        day++;
      } else {
        break;
      }
    }

    System.out.println(day);
  }


  public static void init() throws Exception {
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());

    map = new int[N][N];
    for (int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j=0; j<N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
  }

  public static boolean open() {
    visited = new boolean[N][N];
    int available = 0;

    for (int i=0; i<N; i++) {
      for (int j=0; j<N; j++) {
        if (visited[i][j]) continue;
        Map<String, Object> result = bfs(i, j);
        ArrayList<Node> countries = (ArrayList<Node>) result.get("countries");
        int people = (int) result.get("people");

        if (countries.size() > 1) {
          move(countries, people);
          available++;
        }
      }
    }

    if (available == 0) {
      return false;
    } else {
      return true;
    }
  }

  public static void move(ArrayList<Node> countries, int people) {
    for (Node country : countries) {
      map[country.y][country.x] = people;
    }
  }

  public static Map<String, Object> bfs(int y, int x) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(y, x));
    visited[y][x] = true;
    ArrayList<Node> countries = new ArrayList<>(); // 연합 리스트
    int sum = 0; // 인구수 총합

    countries.add(new Node(y, x));
    sum += map[y][x];

    while(!queue.isEmpty()) {
      Node current = queue.poll();
    
      for (int i=0; i<4; i++) {
        int ny = current.y + dy[i];
        int nx = current.x + dx[i];

        if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
        if (visited[ny][nx]) continue;
        
        int diff = Math.abs(map[ny][nx] - map[current.y][current.x]);
        if (diff >= L && diff <= R) {
          queue.add(new Node(ny, nx));
          countries.add(new Node(ny, nx)); // 연합에 추가
          sum += map[ny][nx];
          visited[ny][nx] = true;
        } 
      }
    }

    Map<String, Object> result = new HashMap<>();
    int each = Math.round(sum / countries.size()); // 각 칸의 인구수

    result.put("countries", countries);
    result.put("people", each);

    return result;
  }


  public static class Node {
    int y, x;
    Node(int y, int x) {
      this.y = y;
      this.x = x;
    }

    @Override
    public String toString() {
      return "(" + y + ", " + x + ")";
    }
  }
}
