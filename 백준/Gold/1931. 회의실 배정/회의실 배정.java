import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        int[][] meetings = new int[N][2];
        int count = 1;

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            meetings[i] = new int[]{start, end};
        }

        Arrays.sort(meetings, (a, b) -> {
            int cmp = Integer.compare(a[1], b[1]);
            if (cmp != 0) {
                return cmp;
            }
            return Integer.compare(a[0], b[0]);
        });

        int selected_index = 0;
        int index = 1;
        while(index < N) {
            int last_time = meetings[selected_index][1];

            if (meetings[index][0] >= last_time) {
                selected_index = index;
                count++;
            }

            index++;
        }

        System.out.println(count);
    }
}
