package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_13549 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] dist = new int[Math.max(N, K) * 2 + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[N] = 0;
		Deque<Integer> dq = new ArrayDeque<Integer>();
		dq.add(N);
		while (!dq.isEmpty()) {
			int cur = dq.pollFirst();

			if (cur * 2 < dist.length && dist[cur * 2] > dist[cur]) {
				dist[cur * 2] = dist[cur];
				dq.addFirst(cur * 2);
			}

			if (cur - 1 >= 0 && dist[cur - 1] > dist[cur] + 1) {
				dist[cur - 1] = dist[cur] + 1;
				dq.addLast(cur - 1);
			}

			if (cur + 1 < dist.length && dist[cur + 1] > dist[cur] + 1) {
				dist[cur + 1] = dist[cur] + 1;
				dq.addLast(cur + 1);
			}
		}
		System.out.println(dist[K]);
	}

	public static void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] cnt = new int[Math.max(N, K) * 2 + 1];
		Arrays.fill(cnt, Integer.MAX_VALUE);
		cnt[N] = 0;
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(N);
		while (!queue.isEmpty()) {
			int p = queue.poll();
			if (p == K) {
				System.out.println(cnt[K]);
				return;
			}

			if (0 <= p - 1 && cnt[p] + 1 < cnt[p - 1]) {
				cnt[p - 1] = cnt[p] + 1;
				queue.add(p - 1);
			}
			if (p + 1 < cnt.length && cnt[p] + 1 < cnt[p + 1]) {
				cnt[p + 1] = cnt[p] + 1;
				queue.add(p + 1);
			}
			if (p * 2 < cnt.length && cnt[p] < cnt[p * 2]) {
				cnt[p * 2] = cnt[p];
				queue.add(p * 2);
			}

		}
	}
}
