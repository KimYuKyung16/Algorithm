import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 차의 대수
		HashMap<Integer, String> car_input_order = new HashMap<Integer, String>(); // <순서, 차번호>
		HashMap<String, Integer> car_input = new HashMap<String, Integer>(); // <차번호, 순서>
		HashMap<Integer, String> car_output_order = new HashMap<Integer, String>(); // <차번호, 순서>
		HashMap<String, Integer> car_output = new HashMap<String, Integer>(); // <차번호, 순서>
		int answer = 0;

		for (int i = 0; i < n; i++) {
			String car = br.readLine();
			car_input_order.put(i, car);
			car_input.put(car, i);
		}
		for (int i = 0; i < n; i++) {
			String car = br.readLine();
			car_output_order.put(i, car);
			car_output.put(car, i);
		}

		// 값이 더 작을 수록 앞쪽에 있음.
		for (String car : car_output.keySet()) {
			int inIndex = car_input.get(car); // 들어가는 순서
			int outIndex = car_output.get(car); // 나오는 순서

			if (inIndex > outIndex) {
				answer++;
			} else {
				for (int i = 0; i < inIndex; i++) {
					// 내 앞쪽에 있던 차들이
					String carNum = car_input_order.get(i); // 결과값: 인덱스에 해당하는 차량 번호 (내 앞쪽에 있던 차의 차량 번호)
					int index = car_output.get(carNum); // 내 앞쪽에 있던 차들의 나간 순서

					if (index > outIndex) {
						answer++;
						break;
					}
				}
			}
		}

		System.out.println(answer);
	}
}
