class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for (int i=1; i<=number; i++) {
            int count = yaksu(i);
            if (count > limit) {
                answer += power;
            } else {
                answer += count;
            }
        }
        return answer;
    }
    
    public int yaksu(int n) {
        int count = 0;
        for (int i=1; i<=Math.sqrt(n); i++) {
            if (i == Math.sqrt(n)) {
                count += 1;
                continue;
            }
            if (n%i == 0) count += 2;
        }
        return count;
    }
}