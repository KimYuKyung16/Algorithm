class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] dy = {-1,0,1,0};
        int[] dx = {0,1,0,-1};
        
        String selected = board[h][w];
        for (int i=0; i<4; i++) {
            int ny = h + dy[i];
            int nx = w + dx[i];
            if (ny >= board.length || ny < 0 || nx >= board.length || nx < 0) continue;
            if (selected.equals(board[ny][nx])) answer++;
        }
        
        return answer;
    }
}