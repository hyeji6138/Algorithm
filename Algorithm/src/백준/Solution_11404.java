package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_11404 {
	static final int INF = 1_000_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] dist = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				dist[i][j] = i == j ? 0 : INF;
			}
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			dist[a][b] = Math.min(dist[a][b], c);
		}
		// ======================= 입력 끝 =====================
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				sb.append(dist[i][j] == INF ? 0 : dist[i][j]);
				if (j < N) sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

	public static void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] answer = new int[N + 1][N + 1];
		int[][] edge = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i != j) {
					edge[i][j] = Integer.MAX_VALUE;
					answer[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edge[a][b] = Math.min(edge[a][b], c);
		}
		// ======================= 입력 끝 =====================
		for (int start = 1; start <= N; start++) {
			PriorityQueue<Edge> queue = new PriorityQueue<>((a, b) -> (a.cost - b.cost));
			queue.add(new Edge(start, answer[start][start]));
			while (!queue.isEmpty()) {
				Edge cur = queue.poll();

				for (int next = 1; next <= N; next++) {
					if (edge[cur.node][next] != Integer.MAX_VALUE
							&& answer[start][next] > cur.cost + edge[cur.node][next]) {
						answer[start][next] = cur.cost + edge[cur.node][next];
						queue.add(new Edge(next, answer[start][next]));
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (answer[i][j] == Integer.MAX_VALUE) {
					sb.append("0 ");
				} else {
					sb.append(answer[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

	static class Edge {
		int node;
		int cost;

		Edge(int node, int cost) {
			this.node = node;
			this.cost = cost;
		}
	}
}
