package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1717 {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (op == 0) { // 집합 합치기
				union(a, b);
			} else { // 집합 확인 후 출력
				if (findParent(a) == findParent(b)) {
					sb.append("YES");
				} else {
					sb.append("NO");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}

	static int findParent(int a) {
		if (parent[a] != a) {
			parent[a] = findParent(parent[a]);
		}
		return parent[a];
	}

	static void union(int a, int b) {
		int parentA = findParent(a);
		int parentB = findParent(b);

		if (parentA < parentB) {
			parent[parentB] = parentA;
		} else if (parentB < parentA) {
			parent[parentA] = parentB;
		}
		return;
	}
}
