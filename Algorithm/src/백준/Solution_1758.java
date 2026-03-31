package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_1758 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] tips = new int[N];
		for (int i = 0; i < N; i++) {
			tips[i] = Integer.parseInt(br.readLine());
		}
		// ================ 입력 끝 ==================
		Arrays.sort(tips);
		long answer = IntStream.range(0, tips.length)
								.mapToLong(i -> tips[i] - ((N - 1) - i))
								.filter(n -> n > 0)
								.sum();
		System.out.println(answer);
	}
}
