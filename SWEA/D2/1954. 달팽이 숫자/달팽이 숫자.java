/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    static BufferedReader br;
	static int n;
	static int[] dy = { 0, 1, 0, -1 }; // 오, 아, 왼, 위
	static int[] dx = { 1, 0, -1, 0 };
	static int[][] map;
	static int cy;
	static int cx;
	static int currentD = 0;
    
	public static void main(String args[]) throws Exception
	{
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine()); // 테스트 케이스
        
		for (int testcase = 1; testcase < t + 1; testcase++) {
			n = Integer.parseInt(br.readLine()); // 달팽이 크기
			map = new int[n][n];
			cy = 0;
			cx = -1;
			int currentNum = 1; // 현재 들어가는 값

			while (currentNum != (n * n) + 1) {
				int ny = cy + dy[currentD];
				int nx = cx + dx[currentD];

				if (ny < 0 || ny >= n || nx < 0 || nx >= n) { // 넘어갈 경우
					currentD = (currentD + 1) % 4;
					continue;
				}
				if (map[ny][nx] != 0) { //
					currentD = (currentD + 1) % 4;
					continue;
				}
				cy += dy[currentD];
				cx += dx[currentD];
				map[ny][nx] = currentNum;
				currentNum++;
			}

			System.out.println("#" + testcase);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}