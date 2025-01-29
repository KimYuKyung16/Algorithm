import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static ArrayList<int[]> chickens = new ArrayList<>();
    static ArrayList<int[]> homes = new ArrayList<>();
    static boolean[] picks;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int current = Integer.parseInt(st.nextToken());
                if (current == 2) { // 치킨집일 경우
                    chickens.add(new int[]{ i, j });
                } else if (current == 1) { // 집일 경우
                    homes.add(new int[]{ i, j });
                }
            }
        }

        picks = new boolean[chickens.size()];
        pickChickens(0, 0);

        System.out.println(answer);
    }

    // 치킨집 선택
    public static void pickChickens(int depth, int ni) {
        // 치킨집은 최대 M개까지 선택 가능
        if (depth == M) {
            int sum = 0;
            for (int i=0; i<homes.size(); i++) {
                int chicken_distance = Integer.MAX_VALUE;
                for (int j=0; j<chickens.size(); j++) {
                    if (!picks[j]) continue;
                    int distance = Math.abs(chickens.get(j)[0] - homes.get(i)[0]) + Math.abs(chickens.get(j)[1] - homes.get(i)[1]);
                    chicken_distance = Math.min(chicken_distance, distance);
                }
                sum += chicken_distance;
            }

            answer = Math.min(answer, sum);
            return;
        }

        for (int i = ni; i < picks.length; i++) {
            if (picks[i]) continue;
            picks[i] = true;
            pickChickens(depth + 1, i+1);
            picks[i] = false;
        }
    }
}
