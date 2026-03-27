package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1197 {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		PriorityQueue<Edge> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			queue.add(new Edge(A, B, C));
		}
		parent = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
		int answer = 0;
		int edgeCnt = 0;
		while (!queue.isEmpty() && edgeCnt < V - 1) {
			Edge pos = queue.poll();

			if (findParent(pos.u) != findParent(pos.v)) {
				union(pos.u, pos.v);
				answer += pos.cost;
				edgeCnt += 1;
			}
		}
		System.out.println(answer);
	}

	public static int findParent(int a) {
		if (parent[a] != a) {
			parent[a] = findParent(parent[a]);
		}
		return parent[a];
	}

	public static void union(int a, int b) {
		int parentA = findParent(a);
		int parentB = findParent(b);

		if (parentA < parentB) {
			parent[parentB] = parentA;
		} else {
			parent[parentA] = parentB;
		}
	}

	static class Edge {
		int u, v;
		int cost;

		Edge(int u, int v, int cost) {
			this.u = u;
			this.v = v;
			this.cost = cost;
		}
	}
}
