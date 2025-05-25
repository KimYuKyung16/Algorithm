class Solution {
    int answer = 0;
    public int solution(int left, int right) {
        for (int i=left; i<=right; i++) {
            get(i);
        }
        return answer;
    }
    public void get(int num) {
        int count = 0;
        for (int i=1; i<=num; i++) {
            if (num%i == 0) count++;
        }
        if (count%2 == 0) answer += num;
        else answer -= num;
    }
}