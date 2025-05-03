import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static int N, M;
  static int[] expenses;
  public static void main(String[] args) throws IOException {
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    expenses = new int[N];

    int maxExpense = 0;
    int totalExpenses = 0;
    for (int i = 0; i < N; i++) {
        expenses[i] = Integer.parseInt(br.readLine());
        maxExpense = Math.max(maxExpense, expenses[i]);
        totalExpenses += expenses[i];
    }
    
    int low = maxExpense;
    int high = totalExpenses;
    int result = high;
    
    while (low <= high) {
        int mid = (low + high) / 2;
        if (isPossible(mid)) {
            result = mid;
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    
    System.out.println(result);
  }
  
  static boolean isPossible(int k) {
    int count = 1;
    int sum = 0;
    for (int i = 0; i < N; i++) {
        if (sum + expenses[i] > k) {
            count++;
            sum = 0;
        }
        sum += expenses[i];
    }
    return count <= M;
  }
}