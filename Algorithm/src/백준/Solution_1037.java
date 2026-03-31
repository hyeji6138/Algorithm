package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.StringTokenizer;

public class Solution_1037 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		// ================= 입력 끝 ==================
		int min = Arrays.stream(numbers).min().getAsInt();
		int max = Arrays.stream(numbers).max().getAsInt();
		System.out.println(min * max);
		Arrays.sort(numbers);
		System.out.println(numbers[0] * numbers[N - 1]);
		IntSummaryStatistics stats = Arrays.stream(numbers).summaryStatistics();
		System.out.println(stats.getMin() * stats.getMax());
	}
}
