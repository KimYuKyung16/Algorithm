import java.util.Scanner;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//테스트 케이스만큼 반복
//	덤프 횟수 입력 받기
//	상자의 높이값 배열로 받기(int형으로)
//	
//  오름차순 정렬
//	덤프 횟수만큼 반복
//		상자의 높이값 배열을 정렬하기
//		제일 마지막 값에서 +1하고 제일 첫번쨰 값에서 -1
//		다시 오름차순 정렬
//	
//	제일 마지막값 - 제일 첫번째값 반환

class Solution
{
    static BufferedReader br;
	static StringTokenizer st;
    
	public static void main(String args[]) throws Exception
	{
		br = new BufferedReader(new InputStreamReader(System.in));

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int dump = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			int[] boxes = new int[100];
			for (int j = 0; j < 100; j++) {
				boxes[j] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(boxes);
			for (int j = 0; j < dump; j++) {

				boxes[boxes.length - 1] = boxes[boxes.length - 1] - 1;
				boxes[0] = boxes[0] + 1;
				Arrays.sort(boxes);
			}

			int answer = boxes[boxes.length - 1] - boxes[0];

			System.out.printf("#%d %d\n", test_case, answer);
		}
	}
}