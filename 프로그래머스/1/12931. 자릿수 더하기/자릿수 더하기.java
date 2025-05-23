public class Solution {
    public int solution(int n) {
        int answer = 0;
        char[] list = Integer.toString(n).toCharArray();
        for (char c : list) {
            answer += c - '0';
        }
        return answer;
    }
}