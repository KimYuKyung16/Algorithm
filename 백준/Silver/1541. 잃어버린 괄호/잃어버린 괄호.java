import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception{
        String reg = br.readLine();
        String[] newReg = reg.split("-");
        int answer = 0;

        for (int i=0; i<newReg.length; i++) {
            if (newReg[i].contains("+")) {
                st = new StringTokenizer(newReg[i], "\\+");

                int current = 0;
                while(st.hasMoreTokens()) {
                    int c = Integer.parseInt(st.nextToken());
                    current += c;
                }
                newReg[i] = Integer.toString(current);
            }
        }

        for (int i=0; i<newReg.length; i++) {
            if (i == 0) {
                answer += Integer.parseInt(newReg[0]);
                continue;
            }
            answer -= Integer.parseInt(newReg[i]);
        }

        System.out.println(answer);
    }
}
