import java.util.*;

class Solution {
    static boolean[] visited;
    static int answer = 0;
    static Set<List<String>> answerSet = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];
        ArrayList<String> arr = new ArrayList<>();
        dfs(0, arr, user_id, banned_id);  
    
        return answerSet.size();
    }
    
    public void dfs(int index, ArrayList<String> arr, String[] user_id, String[] banned_id) {
        if(index == banned_id.length) {
            ArrayList<String> tmpList = new ArrayList<>(arr);
            tmpList.sort(String::compareTo);
            answerSet.add(tmpList);
            return;
        }
        
        for (int i=0; i<user_id.length; i++) {
            if (visited[i]) continue;
            if (isSame(banned_id[index], user_id[i])) {
                visited[i] = true;
                arr.add(user_id[i]);
                dfs(index+1, arr, user_id, banned_id);
                visited[i] = false;
                arr.remove(arr.size()-1);
            }
        }

    }
    
    public boolean isSame(String banned_id, String user_id) {
        char[] bannedIdList = banned_id.toCharArray();
        char[] useIdList = user_id.toCharArray();
        
        if (bannedIdList.length != useIdList.length) return false;
        
        boolean flag = true;
        for (int i=0; i<bannedIdList.length; i++) {
            if (bannedIdList[i] == '*') continue;
            if (bannedIdList[i] != useIdList[i]) {
                flag = false;
                break;
            }
        }
        
        return flag;
    }
}