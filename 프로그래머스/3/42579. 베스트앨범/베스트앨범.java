import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, PriorityQueue<int[]>> map = new HashMap<>();
        ArrayList<String[]> orders = new ArrayList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (int i=0; i<genres.length; i++) {
            if (map.containsKey(genres[i])) {
               PriorityQueue<int[]> pq = map.get(genres[i]);
                pq.add(new int[] {i, plays[i]});
                map.put(genres[i], pq);
            } else {
                PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
                    if (a[1] == b[1]) {
                        return a[0]-b[0];
                    } else {
                        return b[1]-a[1];
                    }
                });
                pq.add(new int[] {i, plays[i]});
                map.put(genres[i], pq);
            }
        }
        
        for (String str : map.keySet()) {
            int total = 0;
            for (int[] song : map.get(str)) {
                total += song[1];
            }
            orders.add(new String[] {str, String.valueOf(total)});
        }
        
        orders.sort((a, b) -> Integer.parseInt(b[1]) - Integer.parseInt(a[1]));
        
        for (String[] order : orders) {
            for (int i=0; i<2; i++) {
                if (map.get(order[0]).isEmpty()) {
                    continue;
                } else {
                    int[] current = map.get(order[0]).poll();
                    answer.add(current[0]);
                }
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}