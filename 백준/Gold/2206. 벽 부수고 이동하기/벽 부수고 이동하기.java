import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][][] map;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int N, M;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M][2];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j][0] = input.charAt(j) - '0'; // 벽 여부
                map[i][j][1] = Integer.MAX_VALUE; // 최소값 초기화
            }
        }

        int result = bfs(0, 0);
        System.out.println(result);
    }

    public static int bfs(int sy, int sx) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {sy, sx, 1, 0}); // y, x, count, isCrack
        boolean[][][] visited = new boolean[N][M][2];
        visited[sy][sx][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];
            int count = current[2];
            int isCrack = current[3];

            // 도착 시 최단 거리 출력
            if (y == N - 1 && x == M - 1) {
                return count;
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                // 범위 체크
                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;

                // 벽이 없는 경우
                if (map[ny][nx][0] == 0 && !visited[ny][nx][isCrack]) {
                    visited[ny][nx][isCrack] = true;
                    queue.add(new int[] {ny, nx, count + 1, isCrack});
                }

                // 벽이 있고 아직 벽을 부수지 않은 경우
                if (map[ny][nx][0] == 1 && isCrack == 0 && !visited[ny][nx][1]) {
                    visited[ny][nx][1] = true;
                    queue.add(new int[] {ny, nx, count + 1, 1});
                }
            }
        }

        return -1; // 도착하지 못한 경우
    }
}
