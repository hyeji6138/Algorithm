package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solution_1431 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] guitar = new String[N];
		for (int i = 0; i < N; i++) {
			guitar[i] = br.readLine();
		}
		Arrays.sort(guitar, Comparator.comparingInt(String::length)
									.thenComparingInt(Solution_1431::sumNumber)
									.thenComparing(Comparator.naturalOrder()));
		StringBuilder sb = new StringBuilder();
		for(String s: guitar) {
			sb.append(s).append("\n");
		}
		System.out.print(sb);
	}

	public static int sumNumber(String str) {
		int result = 0;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				result += str.charAt(i) - '0';
			}
		}
		return result;
	}
}
