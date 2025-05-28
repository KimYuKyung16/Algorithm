class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        char[] list = s.toCharArray();
        for (char c : list) {
            int idx = 0;
            while(idx < index) {
                ++c;
                if (c > 'z') c -= 26;
                if (!skip.contains("" + (char)c)) idx++;
            }
            answer.append(c);
        }
        return answer.toString();
    }
}