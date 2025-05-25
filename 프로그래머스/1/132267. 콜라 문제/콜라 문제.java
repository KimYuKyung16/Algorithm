class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(n>=a) {
            int get = (n/a) * b;
            answer += get;
            n = get + (n%a);
        }
        return answer;
    }
}