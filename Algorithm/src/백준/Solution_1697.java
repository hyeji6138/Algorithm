package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1697 {
	public static void main(String[] args) throws IOException {
//		solution();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] dist = new int[Math.max(N, K) * 2 + 1];
		Arrays.fill(dist, -1);
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(N);
		dist[N] = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				int n = queue.poll();
				if (n == K) {
					System.out.println(dist[K]);
					return;
				}

				if (n * 2 < dist.length && dist[n * 2] == -1) {
					queue.add(n * 2);
					dist[n * 2] = dist[n] + 1;
				}
				if (n + 1 < dist.length && dist[n + 1] == -1) {
					queue.add(n + 1);
					dist[n + 1] = dist[n] + 1;
				}
				if (0 <= n - 1 && dist[n - 1] == -1) {
					queue.add(n - 1);
					dist[n - 1] = dist[n] + 1;
				}
			}
		}

	}

	public static void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] visit = new boolean[Math.max(N, K) * 2 + 1];

		int answer = 0;
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(N);
		visit[N] = true;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				int n = queue.poll();
				if (n == K) {
					System.out.println(answer);
					return;
				}

				if (n * 2 < visit.length && !visit[n * 2]) {
					queue.add(n * 2);
					visit[n * 2] = true;
				}
				if (n + 1 < visit.length && !visit[n + 1]) {
					queue.add(n + 1);
					visit[n + 1] = true;
				}
				if (0 <= n - 1 && !visit[n - 1]) {
					queue.add(n - 1);
					visit[n - 1] = true;
				}

			}
			answer += 1;
		}
	}
}
