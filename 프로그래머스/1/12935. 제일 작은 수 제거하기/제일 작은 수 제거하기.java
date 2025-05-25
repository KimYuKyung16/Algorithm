import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) return new int[] {-1};
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i=0; i<arr.length; i++) {
            if (Math.min(min, arr[i]) == arr[i]) {
                index = i;
                min = Math.min(min, arr[i]);
            }
        }
        int[] answer = new int[arr.length-1];
        for (int i=0, j=0; i<arr.length; i++) {
            if (i == index) continue;
            answer[j++] = arr[i];
            
        }
        return answer;
    }
}