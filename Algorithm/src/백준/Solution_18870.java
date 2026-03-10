package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution_18870 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] sorted = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sorted[i] = arr[i];
		}
		Arrays.sort(sorted);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0, order = 0; i < N; i++) {
			if (!map.containsKey(sorted[i])) {
				map.put(sorted[i], order++);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(map.get(arr[i])).append(" ");
		}
		System.out.println(sb.toString());
	}

	public static void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = i;
		}
//		Arrays.sort(arr, new MySort());
		Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
		int[] answer = new int[N];
		int prev = arr[0][0];
		for (int i = 0, order = 0; i < N; i++) {
			if (prev != arr[i][0]) {
				order++;
				prev = arr[i][0];
			}
			answer[arr[i][1]] = order;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(answer[i] + " ");
		}
		System.out.println(sb.toString());
	}

	static class MySort implements Comparator<int[]> {

		@Override
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		}

	}
}
