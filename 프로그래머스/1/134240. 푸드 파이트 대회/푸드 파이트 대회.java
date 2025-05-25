class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<food.length; i++) {
            sb.append(String.valueOf(i).repeat(food[i]/2));
        }
        sb.append(new StringBuilder(sb).reverse());
        sb.insert(sb.length()/2, 0);
        return sb.toString();
    }
}