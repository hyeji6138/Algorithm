package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_18352 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		List<Integer>[] link = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			link[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			link[a].add(b);
		}

		Queue<Integer> queue = new ArrayDeque<Integer>();
		int[] dist = new int[N + 1];
		Arrays.fill(dist, -1);
		queue.add(X);
		dist[X] = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				int p = queue.poll();
				for (int n : link[p]) {
					if (dist[n] < 0) {
						queue.add(n);
						dist[n] = dist[p] + 1;
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if (i != X && dist[i] == K) {
				sb.append(i).append("\n");
			}
		}
		if (sb.length() == 0) {
			sb.append(-1);
		}
		System.out.println(sb.toString());
	}

	public static void solution1() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		List<Integer>[] link = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			link[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			link[a].add(b);
		}
		boolean[] visit = new boolean[N + 1];
		Queue<Integer> queue = new ArrayDeque<Integer>();
		int dist = 0;
		queue.add(X);
		visit[X] = true;
		while (!queue.isEmpty()) {
			if (dist == K) {
				break;
			}
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				int p = queue.poll();
				for (int n : link[p]) {
					if (!visit[n]) {
						queue.add(n);
						visit[n] = true;
					}
				}
			}
			dist++;
		}
		StringBuilder sb = new StringBuilder();
		if (queue.size() == 0 || dist != K) {
			sb.append("-1");
		} else {
			int[] result = new int[queue.size()];
			for (int i = 0; !queue.isEmpty(); i++) {
				result[i] = queue.poll();
			}
			Arrays.sort(result);
			for (int i = 0; i < result.length; i++) {
				sb.append(result[i]).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
