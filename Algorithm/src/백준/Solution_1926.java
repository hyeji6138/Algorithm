package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1926 {
	static int[] di = { 0, 1, 0, -1 }, dj = { 1, 0, -1, 0 };
	static boolean[][] visit;
	static int[][] map;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visit = new boolean[N][M];
		int p_cnt = 0, p_size = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visit[i][j] && map[i][j] == 1) {
					p_cnt += 1;
					p_size = Math.max(p_size, bfs(i, j));
				}
			}
		}
		System.out.println(p_cnt + "\n" + p_size);
	}

	public static int bfs(int i, int j) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[] { i, j });
		visit[i][j] = true;
		int size = 1;
		while (!queue.isEmpty()) {
			int[] p = queue.poll();

			for (int d = 0; d < di.length; d++) {
				int ni = p[0] + di[d];
				int nj = p[1] + dj[d];

				if (0 <= ni && ni < N && 0 <= nj && nj < M && !visit[ni][nj] && map[ni][nj] == 1) {
					queue.add(new int[] { ni, nj });
					visit[ni][nj] = true;
					size += 1;
				}
			}
		}
		return size;
	}
}
