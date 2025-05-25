class Solution {
    public boolean solution(int x) {
        String str = String.valueOf(x);
        String[] list = str.split("");
        int sum = 0;
        for (String s : list) {
            sum += Integer.parseInt(s);
        }
        System.out.println(sum);
        return x%sum==0;
    }
}