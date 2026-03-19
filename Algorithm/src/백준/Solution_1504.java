package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1504 {
	static int N, E, V1, V2;
	static int[][] dist;
	static List<Edge>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[u].add(new Edge(v, c));
			graph[v].add(new Edge(u, c));
		}
		st = new StringTokenizer(br.readLine());
		V1 = Integer.parseInt(st.nextToken());
		V2 = Integer.parseInt(st.nextToken());
		// ================입력 끝====================
		int[] d1 = dijkstra(1);
		int[] dv1 = dijkstra(V1);
		int[] dv2 = dijkstra(V2);
		int answer = Integer.MAX_VALUE;
		if (d1[V1] != Integer.MAX_VALUE && dv1[V2] != Integer.MAX_VALUE && dv2[N] != Integer.MAX_VALUE) {
			answer = Math.min(answer, d1[V1] + dv1[V2] + dv2[N]);
		}
		if (d1[V2] != Integer.MAX_VALUE && dv2[V1] != Integer.MAX_VALUE && dv1[N] != Integer.MAX_VALUE) {
			answer = Math.min(answer, d1[V2] + dv2[V1] + dv1[N]);
		}
		if (answer == Integer.MAX_VALUE) {
			answer = -1;
		}
		System.out.println(answer);
	}

	public static int[] dijkstra(int start) {
		int[] cost = new int[N + 1];
		Arrays.fill(cost, Integer.MAX_VALUE);
		PriorityQueue<Edge> queue = new PriorityQueue<>((a, b) -> a.cost - b.cost);
		queue.add(new Edge(start, 0));
		cost[start] = 0;
		while (!queue.isEmpty()) {
			Edge cur = queue.poll();

			if (cost[cur.node] < cur.cost) {
				continue;
			}

			for (Edge next : graph[cur.node]) {
				if (cur.cost + next.cost < cost[next.node]) {
					cost[next.node] = cur.cost + next.cost;
					queue.add(new Edge(next.node, cost[next.node]));
				}
			}
		}
		return cost;
	}

	static class Edge {
		int node, cost;

		Edge(int node, int cost) {
			this.node = node;
			this.cost = cost;
		}
	}

	public static void solution2() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		dist = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
			dist[i][i] = 0;
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			dist[u][v] = Integer.parseInt(st.nextToken());
			dist[v][u] = dist[u][v];
		}
		st = new StringTokenizer(br.readLine());
		V1 = Integer.parseInt(st.nextToken());
		V2 = Integer.parseInt(st.nextToken());
		// ================입력 끝====================
		int answer = Integer.MAX_VALUE;
		int cost1 = dijkstra2(1, V1);
		int cost2 = dijkstra2(V1, V2);
		int cost3 = dijkstra2(V2, N);
		if (cost1 != Integer.MAX_VALUE && cost2 != Integer.MAX_VALUE && cost3 != Integer.MAX_VALUE) {
			answer = Math.min(answer, cost1 + cost2 + cost3);
		}
		cost1 = dijkstra2(1, V2);
		cost2 = dijkstra2(V2, V1);
		cost3 = dijkstra2(V1, N);
		if (cost1 != Integer.MAX_VALUE && cost2 != Integer.MAX_VALUE && cost3 != Integer.MAX_VALUE) {
			answer = Math.min(answer, cost1 + cost2 + cost3);
		}
		if (answer == Integer.MAX_VALUE) {
			answer = -1;
		}
		System.out.println(answer);
	}

	public static int dijkstra2(int u, int v) {
		int[] totalCost = new int[N + 1];
		Arrays.fill(totalCost, Integer.MAX_VALUE);
		PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> a.cost - b.cost);
		queue.add(new Node(u, 0));

		while (!queue.isEmpty()) {
			Node cur = queue.poll();

			if (totalCost[cur.num] < cur.cost) {
				continue;
			}

			for (int i = 1; i <= N; i++) {
				if (dist[cur.num][i] != Integer.MAX_VALUE && cur.cost + dist[cur.num][i] < totalCost[i]) {
					totalCost[i] = cur.cost + dist[cur.num][i];
					queue.add(new Node(i, totalCost[i]));
				}
			}
		}
		return totalCost[v];
	}

	static class Node {
		int num, cost;

		Node(int num, int cost) {
			this.num = num;
			this.cost = cost;
		}
	}

	public static void solution1(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		dist = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
			dist[i][i] = 0;
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			dist[u][v] = Integer.parseInt(st.nextToken());
			dist[v][u] = dist[u][v];
		}
		st = new StringTokenizer(br.readLine());
		V1 = Integer.parseInt(st.nextToken());
		V2 = Integer.parseInt(st.nextToken());
		// ================입력 끝====================
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE
							&& dist[i][k] + dist[k][j] < dist[i][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		int answer = Integer.MAX_VALUE;
		if (dist[1][V1] != Integer.MAX_VALUE && dist[V1][V2] != Integer.MAX_VALUE && dist[V2][N] != Integer.MAX_VALUE) {
			answer = Math.min(answer, dist[1][V1] + dist[V1][V2] + dist[V2][N]);
		}
		if (dist[1][V2] != Integer.MAX_VALUE && dist[V2][V1] != Integer.MAX_VALUE && dist[V1][N] != Integer.MAX_VALUE) {
			answer = Math.min(answer, dist[1][V2] + dist[V2][V1] + dist[V1][N]);
		}
		if (answer == Integer.MAX_VALUE) {
			answer = -1;
		}
		System.out.println(answer);
	}

}
