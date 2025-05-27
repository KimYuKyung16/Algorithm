class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i=0; i<n; i++) {
            String map1 = Integer.toString(arr1[i], 2);
            String map2 = Integer.toString(arr2[i], 2);
            map1 = "0".repeat(n-map1.length()) + map1;
            map2 = "0".repeat(n-map2.length()) + map2;
            
            String line = "";
            for (int j=0; j<n; j++) {
                line += Integer.parseInt(""+map1.charAt(j)) | Integer.parseInt(""+map2.charAt(j));
            }
            line = line.replaceAll("1", "#");
            line = line.replaceAll("0", " ");
            answer[i] = line;
            
        }
        return answer;
    }
}