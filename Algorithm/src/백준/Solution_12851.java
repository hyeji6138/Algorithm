package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_12851 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int MAX = Math.max(N, K) * 2 + 1;

		int[] dist = new int[MAX];
		int[] count = new int[MAX];

		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(N);
		dist[N] = 0;
		count[N] = 1;
		while (!queue.isEmpty()) {
			int cur = queue.poll();

			int[] nextPos = { cur - 1, cur + 1, cur * 2 };
			for (int next : nextPos) {
				if (next < 0 || next > MAX) continue;
				
				if (count[next] == 0) { // 처음 방문
					dist[next] = dist[cur] + 1;
					count[next] = count[cur];
					queue.add(next);
				}else if (dist[next] == dist[cur] + 1) { // 같은 최단거리로 다시 도착
					count[next] += count[cur];
				}
			}
		}

		System.out.println(dist[K]);
		System.out.println(count[K]);
	}

	public static void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] dist = new int[Math.max(N, K) * 2 + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(N);
		dist[N] = 0;
		int cnt = 0;
		while (!queue.isEmpty()) {
			int cur = queue.poll();

			if (dist[cur] > dist[K])
				break;
			if (cur == K) {
				cnt += 1;
			}

			if (cur + 1 < dist.length && dist[cur] + 1 <= dist[cur + 1]) {
				dist[cur + 1] = dist[cur] + 1;
				queue.add(cur + 1);
			}
			if (0 <= cur - 1 && dist[cur] + 1 <= dist[cur - 1]) {
				dist[cur - 1] = dist[cur] + 1;
				queue.add(cur - 1);
			}
			if (cur * 2 < dist.length && dist[cur] + 1 <= dist[cur * 2]) {
				dist[cur * 2] = dist[cur] + 1;
				queue.add(cur * 2);
			}
		}
		System.out.println(dist[K]);
		System.out.println(cnt);
	}
}
