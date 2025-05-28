import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<keymap.length; i++) {
            for (int j=0; j<keymap[i].length(); j++){
                char current = keymap[i].charAt(j);
                if (!map.containsKey(current) || (map.containsKey(current) && map.get(current) > j+1)) {
                    map.put(current, j+1);
                }
            }
        }
        int[] answer = new int[targets.length];
        for (int i=0; i<targets.length; i++) {
            String target = targets[i];
            int count = 0;
            for (char c : target.toCharArray()) {
                if (map.containsKey(c)) {
                    count += map.get(c);
                } else {
                    count = -1;
                    break;
                }
            } 
            answer[i] = count;
        }
        return answer;
    }
}