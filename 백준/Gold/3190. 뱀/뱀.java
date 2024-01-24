import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int[][] board;
	static int[] dx = {1, 0, -1, 0}; // 오, 아, 왼, 위
	static int[] dy = {0, 1, 0, -1};
	static int direction = 0; // 뱀이 이동하고 있는 방향
	static int time = 0; // 경과 시간
	static int cx = 0; // 현재 x좌표
	static int cy = 0; // 현재 y좌표
	static HashMap<Integer, String> dirInfo; // 시간에 따른 변화 map
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 보드의 크기
		int k = Integer.parseInt(br.readLine()); // 사과의 개수
		board = new int[n][n];
		
		for (int i=0; i<k; i++) { // 사과 배치
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken())-1;  
			int x = Integer.parseInt(st.nextToken())-1;
			board[y][x] = 2;
		}
		
		int l = Integer.parseInt(br.readLine()); // 방향 전환 정보 개수
		// 방향 전환 값 저장
		dirInfo = new HashMap<Integer, String>();
		for (int i=0; i<l; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			String rotation = st.nextToken();
			
			dirInfo.put(x, rotation);
		}	
		
		Deque<int[]> snake = new ArrayDeque<>(); // 뱀
		snake.push(new int[] {0, 0});
		
		while (true) {
			time++;
			cy += dy[direction];
			cx += dx[direction];
			
			if (cx < 0 || cx >= n || cy < 0 || cy >= n) break;
			
			if (board[cy][cx] == 0) { // 사과 없는 경우
				board[cy][cx] = 1;
				snake.addLast(new int[] {cy, cx});
				int[] firstVal = snake.getFirst();
				board[firstVal[0]][firstVal[1]] = 0;
				snake.removeFirst();
				if (dirInfo.containsKey(time)) {
					rotate(dirInfo.get(time));
				}
			} else if (board[cy][cx] == 2) { // 사과 있는 경우
				board[cy][cx] = 1;
				snake.addLast(new int[] {cy, cx});
				if (dirInfo.containsKey(time)) {
					rotate(dirInfo.get(time));
				}
			} else break;
		}
		
		System.out.println(time);
	}
	
	// 뱀 방향 전환
	public static void rotate(String rotation) {
		if (rotation.equals("L")) { // 왼쪽 회전
			 direction = (direction - 1 + 4) % 4;
		} else { // 오른쪽 회전
			 direction = (direction + 1 + 4) % 4;
		}
	}
	
}
