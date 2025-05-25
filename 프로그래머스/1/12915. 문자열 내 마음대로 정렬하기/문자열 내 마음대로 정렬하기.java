import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        List<String> list = new ArrayList<>(Arrays.asList(strings));
        list.sort((a, b) -> {
            if (a.charAt(n) == b.charAt(n)) {
                return a.compareTo(b);
            } else {
                return a.charAt(n) - b.charAt(n);
            }
        });
        return list.toArray(new String[0]);
    }
}