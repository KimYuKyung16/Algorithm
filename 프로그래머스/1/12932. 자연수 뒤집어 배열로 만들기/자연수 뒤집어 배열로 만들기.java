import java.util.*;
class Solution {
    public ArrayList<Integer> solution(long n) {
        char[] list = Long.toString(n).toCharArray();
        ArrayList<Integer> answer = new ArrayList<>();     
        for (char c : list) {
            answer.add(c - '0');
        }
        Collections.reverse(answer);
        return answer;
    }
}