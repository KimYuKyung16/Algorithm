class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<food.length; i++) {
            for (int j=0; j<food[i]/2; j++) {
                sb.append(i);
            }
        }
        sb.append(new StringBuilder(sb).reverse());
        sb.insert(sb.length()/2, 0);
        return sb.toString();
    }
}