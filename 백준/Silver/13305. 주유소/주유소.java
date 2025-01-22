import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> roads = new ArrayList<>();
        ArrayList<Integer> prices = new ArrayList<>();
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            roads.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            prices.add(Integer.parseInt(st.nextToken()));
        }

        int current_price = prices.get(0);
        int count = 0;
        for (int i=0; i<roads.size(); i++) {
            if (prices.get(i) < current_price) {
                answer += (count * current_price);
                current_price = prices.get(i);
                count = 0;
                count += roads.get(i);
            } else {
                count += roads.get(i);
            }
        }

        answer += (count * current_price);
        System.out.println(answer);
    }
}
