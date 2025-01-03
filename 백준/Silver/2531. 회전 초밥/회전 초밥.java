import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, D, K, C;
    static int[] sushi;
    // N 접시수, D 초밥의 가짓수, K 연속해서 먹는 접시 수, C 쿠폰 번호

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        sushi = new int[N];
        int answer = 0;

        for(int i=0; i<N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        for (int i=0; i<N; i++) {
            answer = Math.max(eat(i), answer);
        }

        System.out.println(answer);
    }

    public static int eat(int start) {
        Set<Integer> kind = new HashSet<>();

        int end = start + K;

        for (int i=start; i<Math.min(end, N); i++) {
            kind.add(sushi[i]);
        }

        if (Math.min(end, N) == N) {
            for (int i=0; i<end-N; i++) {
                kind.add(sushi[i]);
            }
        }

        kind.add(C);

        return kind.size();
    }
}
