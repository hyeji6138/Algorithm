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

public class Solution_1976 {
	static List<Integer>[] edge;
	static int[][] dist;
	static int[] parent;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 도시의 수
		int M = Integer.parseInt(br.readLine()); // 여행 계획에 속한 도시 수
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		StringTokenizer st = null;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					union(i, j);
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		int start = findParent(Integer.parseInt(st.nextToken()));
		while (st.hasMoreTokens()) {
			int city = Integer.parseInt(st.nextToken());
			if (findParent(city) != start) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
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

		if (parentA <= parentB) {
			parent[parentB] = parentA;
		} else {
			parent[parentA] = parentB;
		}
	}

	public static void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 도시의 수
		int M = Integer.parseInt(br.readLine()); // 여행 계획에 속한 도시 수
		edge = new ArrayList[N + 1]; // 연결 정보
		int[] city = new int[M];
		StringTokenizer st = null;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			edge[i] = new ArrayList<>();
			for (int j = 1; j <= N; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					edge[i].add(j);
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			city[i] = Integer.parseInt(st.nextToken());
		}
		// ===================입력 끝======================
		dist = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
			dist[i][i] = 0;
		}

		for (int i = 1; i <= N; i++) {
			dijkstra(i);
		}
		for (int i = 0; i < M - 1; i++) {
			if (dist[city[i]][city[i + 1]] == Integer.MAX_VALUE) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

	public static void dijkstra(int n) {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(n);

		while (!queue.isEmpty()) {
			int cur = queue.poll();

			for (int next : edge[cur]) {
				if (dist[n][cur] + 1 < dist[n][next]) {
					dist[n][next] = dist[n][cur] + 1;
					queue.add(next);
				}
			}
		}
	}

}
