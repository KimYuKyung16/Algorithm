import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> cards_pq = new PriorityQueue<>();
        int answer = 0;

        for (int i=0; i<N; i++) {
            cards_pq.add(Integer.parseInt(br.readLine()));
        }

        while (cards_pq.size() != 1) {
            int pick1 = cards_pq.poll();
            int pick2 = cards_pq.poll();
            int sum = pick1 + pick2;

            answer += sum;
            cards_pq.add(sum);
        }

        System.out.println(answer);
    }
}
