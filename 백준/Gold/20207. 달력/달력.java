import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
    
  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());
    int answer = 0;

    int[] days = new int[366];
    for (int i=0; i<N; i++) {
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        for (int j = S; j <= E; j++) {
            days[j]++;
        }
    }

    int totalArea = 0;
    int width = 0;
    int height = 0;
    for (int i = 1; i <= 365; i++) {
        if (days[i] > 0) {
            width++;
            height = Math.max(height, days[i]);
        } else {
            if (width > 0) {
                totalArea += width * height;
                width = 0;
                height = 0;
            }
        }
    }

    if (width > 0) {
        totalArea += width * height;
    }

    System.out.println(totalArea);
  }
}
