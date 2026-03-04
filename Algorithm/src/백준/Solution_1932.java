package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1932 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// solution();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] sum = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				int value = Integer.parseInt(st.nextToken());
				if (i == 0) {
					sum[i][j] = value;
				} else if (j == 0) {
					sum[i][j] = sum[i - 1][j] + value;
				} else {
					sum[i][j] = Math.max(sum[i - 1][j - 1], sum[i - 1][j]) + value;
				}
			}
		}
		int answer = 0;
		for (int i = 0; i < N; i++) {
			answer = Math.max(answer, sum[N - 1][i]);
		}
		System.out.println(answer);
	}

	public static void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] triangle = new int[N][N];
		int[][] sum = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				triangle[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		sum[0][0] = triangle[0][0];
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j <= i; j++) {
				if (sum[i + 1][j] < sum[i][j] + triangle[i + 1][j]) {
					sum[i + 1][j] = sum[i][j] + triangle[i + 1][j];
				}
				if (sum[i + 1][j + 1] < sum[i][j] + triangle[i + 1][j + 1]) {
					sum[i + 1][j + 1] = sum[i][j] + triangle[i + 1][j + 1];
				}
			}
		}
		int answer = 0;
		for (int i = 0; i < N; i++) {
			answer = Math.max(answer, sum[N - 1][i]);
		}
		System.out.println(answer);
	}
}
