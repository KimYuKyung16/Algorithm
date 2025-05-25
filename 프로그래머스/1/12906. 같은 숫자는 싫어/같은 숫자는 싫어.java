import java.util.*;

public class Solution {
    public ArrayList<Integer> solution(int []arr) {
        int current = -1;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i<arr.length; i++) {
            if (current == arr[i]) continue;
            else {
                current = arr[i];
                list.add(arr[i]);
            }
        }
        return list;
    }
}