class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] list = s.toCharArray();
        
        char start = list[0];
        int count1 = 0;
        int count2 = 0;
        for (int i=0; i<list.length; i++) {
            if (list[i] == start) count1++;
            else count2++;
            
            if (count1 == count2) {
                answer++;
                if (i+1 >= list.length) continue;
                start = list[i+1];
                count1 = 0;
                count2 = 0;
            }
        }
        if (count1 != count2) answer++;
        return answer;
    }
}