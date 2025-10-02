import java.util.*;

class Solution {
    static int[][] map = new int[101][101];
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for (int[] location : rectangle) {
            int sx = location[0] * 2;
            int sy = location[1] * 2;
            int ex = location[2] * 2;
            int ey = location[3] * 2;
            
            for (int y=sy; y<=ey; y++) {
                for (int x=sx; x<=ex; x++) {
                    map[y][x] = 1;
                }
            }
        }
        
        for (int[] location : rectangle) {
            int sx = location[0] * 2;
            int sy = location[1] * 2;
            int ex = location[2] * 2;
            int ey = location[3] * 2;
            
            for (int y=sy+1; y<ey; y++) {
                for (int x=sx+1; x<ex; x++) {
                    map[y][x] = 0;
                }
            }
        }
        
        int answer = bfs(characterY * 2, characterX * 2, itemY * 2, itemX * 2);
        return answer/2;
    }
    
    public int bfs(int sy, int sx, int ey, int ex) {
        int[] dy = new int[] {-1, 0, 1, 0};
        int[] dx = new int[] {0, 1, 0, -1};
        boolean[][] visited = new boolean[101][101];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { sy, sx, 0 });
        visited[sy][sx] = true;
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            
            for (int i=0; i<4; i++) {
                int ny = current[0] + dy[i];
                int nx = current[1] + dx[i];
                
                if (ny == ey && nx == ex) {
                    return current[2] + 1;
                }
                
                if (ny < 0 || ny >= 101 || nx < 0 || nx >= 101) continue;
                if (map[ny][nx] == 0) continue;
                if (visited[ny][nx]) continue;
                visited[ny][nx] = true;
                queue.add(new int[] {ny, nx, current[2]+1});
            }
        }
        
        return 0;
    }
}