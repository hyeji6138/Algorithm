package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1149 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[][] cost = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] dp = new int[N][3];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				if (0 < i) {
					dp[i][j] = cost[i][j] + Math.min(dp[i - 1][(3 + (j - 1)) % 3], dp[i - 1][(j + 1) % 3]);
				} else {
					dp[i][j] = cost[i][j];
				}
			}
		}
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			answer = Math.min(answer, dp[N - 1][i]);
		}
		System.out.println(answer);
	}
	
	public static int solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] prev = new int[3];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 3; i++) {
		    prev[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < N; i++) {
		    st = new StringTokenizer(br.readLine());
		    int r = Integer.parseInt(st.nextToken());
		    int g = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());

		    int[] curr = new int[3];
		    curr[0] = r + Math.min(prev[1], prev[2]);
		    curr[1] = g + Math.min(prev[0], prev[2]);
		    curr[2] = b + Math.min(prev[0], prev[1]);

		    prev = curr;
		}
		return Math.min(prev[0], Math.min(prev[1], prev[2]));
	}
}
