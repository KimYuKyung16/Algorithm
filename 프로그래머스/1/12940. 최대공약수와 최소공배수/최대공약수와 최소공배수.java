class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        for (int i=n; i>0; i--) {
            if (n%i !=0 || m%i != 0) continue;
            answer[0] = i;
            break;
        }
        for (int i=m; i<=(n*m); i+=m) {
            if (i%n != 0 || i%m != 0) continue;
            answer[1] = i;
            break;
        }        
        return answer;
    }
}