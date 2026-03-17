package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_13913 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int MAX = Math.max(N, K) * 2 + 1;

		int[] dist = new int[MAX];
		int[] parent = new int[MAX];
		Arrays.fill(dist, Integer.MAX_VALUE);
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(N);
		dist[N] = 0;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			if (cur == K) {
				break;
			}
			int[] next = { cur + 1, cur - 1, cur * 2 };
			for (int n : next) {
				if (0 <= n && n < MAX && dist[cur] + 1 < dist[n]) {
					dist[n] = dist[cur] + 1;
					parent[n] = cur;
					queue.add(n);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
		int pos = K;
		while (pos != N) {
			stack.push(pos);
			pos = parent[pos];
		}
		stack.push(N);
		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		System.out.println(dist[K]);
		System.out.println(sb.toString());
	}
}
