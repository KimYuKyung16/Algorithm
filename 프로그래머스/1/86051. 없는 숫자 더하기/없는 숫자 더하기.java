class Solution {
    public int solution(int[] numbers) {
        boolean[] states = new boolean[10];
        for (int n : numbers) {
            states[n] = true;
        }
        int answer = 0;
        for (int i=0; i<10; i++) {
            if (!states[i]) answer += i;
        }
        return answer;
    }
}