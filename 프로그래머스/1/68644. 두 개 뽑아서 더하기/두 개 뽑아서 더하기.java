import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<numbers.length; i++) {
            for (int j=i+1; j<numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        ArrayList<Integer> answer = new ArrayList<>(set);
        answer.sort((a,b) -> a-b);
        return answer;
    }
}