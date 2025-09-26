class Solution {
    static char[] wlist = {'A', 'E', 'I', 'O', 'U'};
    static int count = 0;
    static int answer = 0;
    
    public int solution(String word) {
        dfs("", word);
        return answer;
    }
    
    public void dfs(String str, String word) {
        if (str.length() > 5 || answer != 0) return;
        if (str.equals(word)) {
            answer = count;
            return;
        }
        count++;
        
        for (int i=0; i<wlist.length; i++) {
            dfs(str+wlist[i], word);
        }
    }
}