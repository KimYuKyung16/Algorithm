import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dy = {-1, 0, 1, 0};  // 북, 동, 남, 서
    static int[] dx = {0, 1, 0, -1};
    static int ry, rx, rd; // 로봇 상태
    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        ry = Integer.parseInt(st.nextToken());
        rx = Integer.parseInt(st.nextToken());
        rd = Integer.parseInt(st.nextToken());

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            // 1.현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소
            if (map[ry][rx] == 0) {
                map[ry][rx] = 2;
                answer++;
            }
            
            boolean isClean = true;
            for (int i=0; i<4; i++) {
                // 3.현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
                int ny = ry + dy[i];
                int nx = rx + dx[i];
                if (map[ny][nx] == 0) {
                    isClean = false;
                    // 3-1.반시계 방향으로 90도 회전
                    rd = (rd + 3) % 4;
                    // 3-2.바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진
                    int nry = ry + dy[rd];
                    int nrx = rx + dx[rd];
                    if (map[nry][nrx] == 0) {
                        ry = nry;
                        rx = nrx;
                    }
                    break;
                }
            }

            // 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
            if (isClean) {
                // 2-1.바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아감.
                // 2-2.바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춤.
                int ny = ry - dy[rd];
                int nx = rx - dx[rd];
                if (ny < 0 || ny >= N || nx < 0 || nx >= M) break;
                if (map[ny][nx] == 1) break;
                ry = ny;
                rx = nx;
            }
        }

        System.out.println(answer);
    }
}
