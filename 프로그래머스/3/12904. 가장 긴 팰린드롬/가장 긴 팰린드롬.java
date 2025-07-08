class Solution
{
    static int answer = 0;
    
    public int solution(String s)
    {
        for (int i=0; i<s.length(); i++) {
            expand(s, i, i);
            if (i+1 < s.length() && s.charAt(i) == s.charAt(i+1)) {
                expand(s, i, i+1);
            }
        }
        return answer;
    }
    
    public void expand(String s, int left, int right) {
        while(true) {
            if (left < 0 || right >= s.length()) break;
            if (s.charAt(left) != s.charAt(right)) break;
            left--;
            right++;
        }
        
      answer = Math.max(answer, right - left - 1);
    }
} 