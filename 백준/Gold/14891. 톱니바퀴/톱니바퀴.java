import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// N극은 0, S극은 1
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Integer>[] gearList = new ArrayList[4];
	static int answer = 0;

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < gearList.length; i++) {
			gearList[i] = new ArrayList<>();
		}

		for (int i = 0; i < 4; i++) {
			String tmp = br.readLine();

			for (int j = 0; j < 8; j++) {
				gearList[i].add(tmp.charAt(j) - '0');
			}
		}

		int k = Integer.parseInt(br.readLine()); // 회전 횟수
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()) - 1; // 톱니바퀴 번호
			int dir = Integer.parseInt(st.nextToken()); // 방향 (1: 시계, -1: 반시계)
			int[] rotateList = new int[4];

			int current_num = num;
			int current_dir = dir;
			rotateList[current_num] = dir;
			current_num++;
			// 오른쪽
			while (true) {
				if (current_num > 3)
					break;
				if (gearList[current_num - 1].get(2) != gearList[current_num].get(6)) {
					current_dir = current_dir * -1;
					rotateList[current_num] = current_dir;
					current_num++;
				} else {
					break;
				}
			}

			current_num = num;
			current_dir = dir;
			current_num--;
			// 왼쪽
			while (true) {
				if (current_num < 0)
					break;
				if (gearList[current_num + 1].get(6) != gearList[current_num].get(2)) {
					current_dir = current_dir * -1;
					rotateList[current_num] = current_dir;
					current_num--;
				} else {
					break;
				}
			}

			for (int j = 0; j < 4; j++) {
				if (rotateList[j] == 1) {
					rotate_right(j, rotateList[j]);
				} else if (rotateList[j] == -1) {
					rotate_left(j, rotateList[j]);
				}
			}
		}

		answer += gearList[0].get(0) == 0 ? 0 : 1;
		answer += gearList[1].get(0) == 0 ? 0 : 2;
		answer += gearList[2].get(0) == 0 ? 0 : 4;
		answer += gearList[3].get(0) == 0 ? 0 : 8;

		System.out.println(answer);
	}

	public static void rotate_left(int num, int dir) {
		int first = gearList[num].get(0);
		gearList[num].remove(0);
		gearList[num].add(first);

	}

	public static void rotate_right(int num, int dir) {
		int last = gearList[num].get(7);
		gearList[num].remove(7);
		gearList[num].add(0, last);
	}
}
