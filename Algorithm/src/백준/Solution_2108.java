package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution_2108 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		// ==================입력 끝=======================
		Arrays.sort(numbers);
		System.out.println(avg(numbers));
		System.out.println(center(numbers));
		System.out.println(maxFrequency(numbers));
		System.out.println(range(numbers));
	}

	public static int avg(int[] numbers) { // 산술 평균
		return (int) Math.round(Arrays.stream(numbers).average().getAsDouble());
	}

	public static int center(int[] numbers) { // 중앙값
		return numbers[numbers.length / 2];
	}

	public static int maxFrequency(int[] numbers) { // 최빈값
		Map<Integer, Long> frequency = Arrays.stream(numbers).boxed()
				.collect(Collectors.groupingBy(n -> n, Collectors.counting()));
		Long maxCount = frequency.values().stream().mapToLong(Long::longValue).max().getAsLong();
		List<Integer> findNumbers = frequency.entrySet().stream().filter(e -> e.getValue().equals(maxCount))
				.map(Map.Entry::getKey).sorted().collect(Collectors.toList());
		return findNumbers.size() > 1 ? findNumbers.get(1) : findNumbers.get(0);
	}

	public static int range(int[] numbers) { // 범위
		return numbers[numbers.length - 1] - numbers[0];
	}
}
