package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_1181 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<String> words = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			words.add(br.readLine());
		}
		List<String> result = words.stream().distinct()
				.sorted(Comparator.comparingInt(String::length)
						.thenComparing(Comparator.naturalOrder()))
				.collect(Collectors.toList());
		StringBuilder sb = new StringBuilder();
		for (String word : result) {
			sb.append(word).append("\n");
		}
		System.out.print(sb);
	}
}
