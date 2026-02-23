package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1389 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		int answer = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			Queue<Integer> queue = new ArrayDeque<Integer>();
			boolean[] visit = new boolean[N + 1];
			int[] dist = new int[N + 1];
			queue.add(i);
			visit[i] = true;
			int sum = 0;
			while (!queue.isEmpty()) {
				int size = queue.size();
				for (int s = 0; s < size; s++) {
					int p = queue.poll();

					for (int next : graph[p]) {
						if (!visit[next]) {
							dist[next] = dist[p] + 1;
							sum += dist[next];
							visit[next] = true;
							queue.add(next);
						}
					}
				}
			}
			if (sum < min) {
				answer = i;
				min = sum;
			}
		}
		System.out.println(answer);
//		solution1();
	}

	public static void solution1() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] link = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i != j) {
					link[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			link[a][b] = 1;
			link[b][a] = 1;
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (link[i][k] != Integer.MAX_VALUE && link[k][j] != Integer.MAX_VALUE
							&& link[i][k] + link[k][j] < link[i][j]) {
						link[i][j] = link[i][k] + link[k][j];
					}
				}
			}
		}
		int answer = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= N; j++) {
				sum += link[i][j];
			}
			if (sum < min) {
				answer = i;
				min = sum;
			}
		}
		System.out.println(answer);
	}

}
