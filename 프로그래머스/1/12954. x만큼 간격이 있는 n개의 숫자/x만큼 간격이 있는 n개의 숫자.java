class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        int index = 1;
        while(index <= n) {
            answer[index-1] = (long)x * (long)index;
            index++;
        }
        return answer;
    }
}