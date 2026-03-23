package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_10217 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			List<Edge>[] ticket = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				ticket[i] = new ArrayList<>();
			}
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				ticket[u].add(new Edge(v, c, d));
			}
			// =============== 입력완료 ==================
			int[][] dist = new int[N + 1][M + 1];
			for (int i = 1; i <= N; i++) {
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			dist[1][0] = 0;
			for (int c = 0; c <= M; c++) {
				for (int u = 1; u <= N; u++) {
					if (dist[u][c] == Integer.MAX_VALUE) {
						continue;
					}

					for (Edge e : ticket[u]) {
						int nextCost = c + e.cost;
						if (nextCost <= M) {
							dist[e.node][nextCost] = Math.min(dist[e.node][nextCost], dist[u][c] + e.dist);
						}
					}
				}
			}
			int answer = Integer.MAX_VALUE;
			for (int c = 0; c <= M; c++) {
				answer = Math.min(answer, dist[N][c]);
			}
			if (answer == Integer.MAX_VALUE) {
				sb.append("Poor KCM\n");
			} else {
				sb.append(answer).append("\n");
			}
		}
		System.out.println(sb.toString());
	}

	public static void solution1() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			List<Edge>[] ticket = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				ticket[i] = new ArrayList<>();
			}
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				ticket[u].add(new Edge(v, c, d));
			}
			// =============== 입력완료 ==================
			int[][] dist = new int[N + 1][M + 1];
			int answer = Integer.MAX_VALUE;
			for (int i = 1; i <= N; i++) {
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			for (int i = 1; i <= N; i++) {
				ticket[i].sort((a, b) -> (a.dist - b.dist));
			}
			PriorityQueue<Edge> pq = new PriorityQueue<Edge>((a, b) -> (a.dist - b.dist));
			pq.add(new Edge(1, 0, 0));
			dist[1][0] = 0;
			while (!pq.isEmpty()) {
				Edge e = pq.poll();
				if (dist[e.node][e.cost] < e.dist) {
					continue;
				} else if (e.node == N) {
					answer = e.dist;
					break;
				}

				for (Edge next : ticket[e.node]) {
					int nextCost = e.cost + next.cost;
					int nextDist = e.dist + next.dist;

					if (nextCost <= M && nextDist < dist[next.node][nextCost]) {
						dist[next.node][nextCost] = nextDist;
						pq.add(new Edge(next.node, next.cost + e.cost, dist[next.node][next.cost + e.cost]));
					}
				}
			}
			if (answer == Integer.MAX_VALUE) {
				sb.append("Poor KCM\n");
			} else {
				sb.append(answer).append("\n");
			}
		}
		System.out.println(sb.toString());
	}

	static class Edge {
		int node;
		int cost;
		int dist;

		Edge(int node, int cost, int dist) {
			this.node = node;
			this.cost = cost;
			this.dist = dist;
		}
	}
}
