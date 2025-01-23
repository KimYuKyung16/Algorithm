import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();
        int answer = 0;

        while(true) {
            if (B.equals(A)) {
                System.out.println(answer + 1);
                break;
            }
            if (Integer.parseInt(B) < Integer.parseInt(A)) {
                System.out.println(-1);
                break;
            }
            if (B.charAt(B.length()-1) == '1') {
                String new_B = B.substring(0, B.length()-1);
                B = new_B;
                answer++;
            } else {
                if (Integer.parseInt(B) % 2 == 0) {
                    B = Integer.toString(Integer.parseInt(B) / 2);
                    answer++;
                } else {
                    System.out.println(-1);
                    break;
                }
            }
        }
    }
}
