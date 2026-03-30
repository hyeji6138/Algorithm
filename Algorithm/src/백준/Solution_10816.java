package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution_10816 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<Integer, Integer> card = new HashMap<>();
		for (int i = 0; i < N; i++) {
			int value = Integer.parseInt(st.nextToken());
			card.put(value, card.getOrDefault(value, 0) + 1);
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			sb.append(card.getOrDefault(Integer.parseInt(st.nextToken()), 0)).append(" ");
		}
		System.out.println(sb);
	}

	public static void solution() throws NumberFormatException, IOException { // 배열
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int MAX_SIZE = 20_000_001;
		int SIZE = 10_000_000;
		int[] arr = new int[MAX_SIZE];
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[Integer.parseInt(st.nextToken()) + SIZE]++;
		}
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			sb.append(arr[Integer.parseInt(st.nextToken()) + SIZE]).append(' ');
		}
		System.out.println(sb.toString());
	}

	public static void solution2() throws NumberFormatException, IOException { // 이분탐색
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int value = Integer.parseInt(st.nextToken());
			sb.append((upperBound(value, arr) - lowerBound(value, arr)) + " ");
		}
		System.out.println(sb.toString());
	}

	public static int lowerBound(int n, int[] arr) {
		int left = 0;
		int right = arr.length;
		while (left < right) {
			int mid = (left + right) / 2;

			if (n <= arr[mid]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	public static int upperBound(int n, int[] arr) {
		int left = 0;
		int right = arr.length;
		while (left < right) {
			int mid = (left + right) / 2;

			if (n < arr[mid]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	public static void solution1() throws NumberFormatException, IOException { // hashmap
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> hash = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int value = Integer.parseInt(st.nextToken());
			hash.put(value, hash.getOrDefault(value, 0) + 1);
		}
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int value = Integer.parseInt(st.nextToken());
			sb.append(hash.getOrDefault(value, 0)).append(" ");
		}
		System.out.println(sb.toString());
	}
}
