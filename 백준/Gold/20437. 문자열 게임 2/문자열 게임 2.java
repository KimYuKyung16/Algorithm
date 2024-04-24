import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        
        int t = Integer.parseInt(br.readLine());long ttt = System.currentTimeMillis();
        Map<Character, ArrayList<Integer>> map;
        for (int tc = 0; tc < t; tc++) {
            String w = br.readLine(); // 문자열
            int k = Integer.parseInt(br.readLine());
            map = new HashMap<Character, ArrayList<Integer>>();
            for(int i = 0; i < 26; i++) {
                char te = (char) ('a' + i);
                map.put(te, new ArrayList<>());
            }
            for (int i = 0; i < w.length(); i++) {
                map.get(w.charAt(i)).add(i);
            }
            getResult(map, k);
        }
    }
    static int cc;
    // 1. 어떤 문자를 정확히 K개를 포함하는 가장 짧은 연속 문자열의 길이
    // 2. 어떤 문자를 정확히 K개를 포함하고, 문자열의 첫 번쨰와 마지막 글자가 해당 문자로 가장 긴 문자열의 길이
    public static void getResult(Map<Character, ArrayList<Integer>> map, int k) {
        int result1 = Integer.MAX_VALUE;
        int result2 = Integer.MIN_VALUE;

        for (java.util.Map.Entry<Character, ArrayList<Integer>> entry : map.entrySet()) {
            char key = entry.getKey();
            ArrayList<Integer> arr = entry.getValue();

            if (arr.size() < k) {
                continue;
            }

            for (int i = 0; i + k - 1 < arr.size(); i++) {
                int first = arr.get(i); // 첫 번쨰 값
                int second = arr.get(i + k - 1); // 두 번째 값

                result1 = Math.min(result1, second - first + 1);
                result2 = Math.max(result2, second - first + 1);
            }
        }

        if (result1 == Integer.MAX_VALUE || result2 == Integer.MIN_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result1 + " " + result2);
        }
    }
}