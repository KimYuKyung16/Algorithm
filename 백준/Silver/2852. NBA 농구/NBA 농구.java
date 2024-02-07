import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int team1_goalCnt = 0;
		int team2_goalCnt = 0;
		int team1_winTime = 0;
		int team2_winTime = 0;

		int preTime = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int team = Integer.parseInt(st.nextToken());

			String[] time = st.nextToken().split(":");

			int min = Integer.parseInt(time[0]);
			int sec = Integer.parseInt(time[1]);
			int totalTime = (min * 60) + sec;

			if (team1_goalCnt > team2_goalCnt) { // 1번 팀이 이기고 있는 경우
				team1_winTime += totalTime - preTime;
			}
			if (team2_goalCnt > team1_goalCnt) { // 2번 팀이 이기고 있는 경우
				team2_winTime += totalTime - preTime;
			}
			preTime = totalTime;

			if (team == 1) {
				team1_goalCnt++;
			} else {
				team2_goalCnt++;
			}
		}

		if (team1_goalCnt > team2_goalCnt) { // 1번 팀이 이기고 있는 경우
			team1_winTime += 2880 - preTime;
		}
		if (team2_goalCnt > team1_goalCnt) { // 2번 팀이 이기고 있는 경우
			team2_winTime += 2880 - preTime;
		}

		divide_minSec(team1_winTime);
		divide_minSec(team2_winTime);
	}

	public static void divide_minSec(int time) {
		String min = (time / 60 < 10) ? "0" + (time / 60) : "" + (time / 60);
		String sec = (time % 60 < 10) ? "0" + (time % 60) : "" + (time % 60);

		System.out.println(min + ":" + sec);
	}
}
