import java.util.*;
import java.io.*;

// HashMap 쓰기
class Solution {
    public int solution(String str1, String str2) {
        HashMap<String, Integer> group1 = new HashMap<>();
        HashMap<String, Integer> group2 = new HashMap<>();
        
        getHashMap(str1, group1);
        getHashMap(str2, group2);
        
        int union = 0;
        int intersection = 0;
        Set<String> unionKeySet = new HashSet<>(group1.keySet());
        unionKeySet.addAll(group2.keySet());
        
        for (String key : unionKeySet) {
            int group1_count = group1.getOrDefault(key, 0);
            int group2_count = group2.getOrDefault(key, 0);
            
            union += Math.min(group1_count, group2_count);
            intersection += Math.max(group1_count, group2_count);
        }
        
        if (union == 0 && intersection == 0) {
            return 1 * 65536;
        } else {
            return (int) (((double) union/intersection) * 65536);
        }
    }
    
    public static void getHashMap(String str, HashMap<String, Integer> group) {
         for (int i=0; i<str.length()-1; i++) {
            char left = str.charAt(i);
            char right = str.charAt(i+1);
            String word = "" + left + right;

            if (!isEnglishChar(left) || !isEnglishChar(right)) {
                continue;
            }
             
            if (group.get(word.toLowerCase()) != null) {
                group.put(word.toLowerCase(), group.get(word.toLowerCase())+1);
            } else {
                group.put(word.toLowerCase(), 1);
            }
        }
    }
    
    public static boolean isEnglishChar(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }
}