class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        for (int i=(a>b?b:a); i<=(a>b?a:b); i++) {
            answer += i;
        }
        return answer;
    }
}