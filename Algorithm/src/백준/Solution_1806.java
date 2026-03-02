package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1806 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] array = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		int left = 0, right = 0, sum = 0, answer = Integer.MAX_VALUE;
//		while (right < N && left <= right) {
//			if (S <= sum) { // 조건 만족
//				answer = Math.min(answer, right - left);
//				sum -= array[left++];
//			} else {
//				sum += array[right++];
//			}
//		}
		while (true) {
			if (S <= sum) { // 조건 만족
				answer = Math.min(answer, right - left);
				sum -= array[left++];
			} else if (right == N) {
				break;
			} else {
				sum += array[right++];
			}
		}
		while (S <= sum) {
			answer = Math.min(answer, right - left);
			sum -= array[left++];
		}
		if (answer == Integer.MAX_VALUE) {
			answer = 0;
		}
		System.out.println(answer);
	}
}
