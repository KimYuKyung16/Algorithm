import java.io.*;
import java.util.*;
 
public class Main {
	public static int T, N, M;
	public static StringBuilder sb = new StringBuilder();
	public static int answer = 0;
	public static int[] coin;
	public static int[] dp;
    
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	T = Integer.parseInt(st.nextToken());
    	
    	for(int t=0;t<T;t++) {
    		st = new StringTokenizer(br.readLine());
    		N = Integer.parseInt(st.nextToken());
    		coin = new int[N];
    		
    		st = new StringTokenizer(br.readLine());
    		for(int i=0;i<N;i++) {
    			coin[i] = Integer.parseInt(st.nextToken());
    		}
    		st = new StringTokenizer(br.readLine());
    		M = Integer.parseInt(st.nextToken());
    		dp = new int[M+1];
    		
    		dp[0] = 1;
    		
    		for(int i=0;i<N;i++) {
    			for(int j=coin[i]; j<M+1;j++) {
    				dp[j] = dp[j] + dp[j - coin[i]];
    			}
    		}
    		System.out.println(dp[M]);
    	}
    }     
}