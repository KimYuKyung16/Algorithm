import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N; // 편의점 개수
    static Position[] places;
    static Position festival;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());

            places = new Position[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                places[i] = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            festival = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            System.out.println(bfs(sx, sy));
        }
    }

    public static String bfs(int x, int y) {
        Queue<Position> q = new LinkedList<>();
        q.add(new Position(x, y));
        boolean[] visited = new boolean[N];

        while(!q.isEmpty()) {
            Position c = q.poll();

            if (Math.abs(c.x - festival.x) + Math.abs(c.y - festival.y) <= 1000) {
                return "happy";
            }

            for (int i=0; i<N; i++) {
                if (visited[i]) continue;
                if (Math.abs(c.x - places[i].x) + Math.abs(c.y - places[i].y) <= 1000) {
                    visited[i] = true;
                    q.add(new Position(places[i].x, places[i].y));
                }
            }
        }

        return "sad";
    }
}

class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


