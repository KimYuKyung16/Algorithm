import java.util.*;
import java.io.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static int N, answer = Integer.MAX_VALUE;
  static int[][] S;
  static boolean[] visited;
  static ArrayList<Integer> startTeam = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    N = Integer.parseInt(br.readLine());
    S = new int[N][N];
    visited = new boolean[N];

    for (int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j=0; j<N; j++) {
        S[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i=1; i<=N/2; i++) {
      pick(i, 0, 0);
    }

    System.out.println(answer);
  }

  public static void pick(int c, int count, int index) {
    if (c == count) {
      calc();
    }

    for (int i=index; i<N; i++) {
      if (visited[i]) continue;
      startTeam.add(i);
      visited[i] = true;
      pick(c, count+1, i+1);
      startTeam.remove(startTeam.size()-1);
      visited[i] = false;
    }
  }

  public static void calc() {
    ArrayList<Integer> linkTeam = new ArrayList<>();

    for (int i=0; i<visited.length; i++) {
      if (!visited[i]) {
        linkTeam.add(i);
      }
    }

    int startScore = 0;
    int linkScore = 0;
    for (int i=0; i<startTeam.size(); i++) {
      int p1 = startTeam.get(i);
      for (int j=i+1; j<startTeam.size(); j++) {
        int p2 = startTeam.get(j);
        startScore += (S[p1][p2] + S[p2][p1]);
      }
    }

    for (int i=0; i<linkTeam.size(); i++) {
      int p1 = linkTeam.get(i);
      for (int j=i+1; j<linkTeam.size(); j++) {
        int p2 = linkTeam.get(j);
        linkScore += (S[p1][p2] + S[p2][p1]);
      }
    }

    answer = Math.min(answer, (Math.abs(startScore - linkScore)));
  }
}
