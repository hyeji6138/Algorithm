package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2178 {
	static int[] di = { 0, 1, 0, -1 }, dj = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp[j] - '0';
			}
		}

		Queue<int[]> queue = new ArrayDeque<int[]>();
		boolean[][] visit = new boolean[N][M];
		int[][] dist = new int[N][M];
		dist[0][0] = 1;

		queue.add(new int[] { 0, 0 });
		visit[0][0] = true;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				int[] p = queue.poll();
				if (p[0] == N - 1 && p[1] == M - 1) {
					System.out.println(dist[N - 1][M - 1]);
					return;
				}

				for (int d = 0; d < di.length; d++) {
					int ni = p[0] + di[d];
					int nj = p[1] + dj[d];

					if (0 <= ni && ni < N && 0 <= nj && nj < M && map[ni][nj] == 1 && !visit[ni][nj]) {
						visit[ni][nj] = true;
						dist[ni][nj] = dist[p[0]][p[1]] + 1;
						queue.add(new int[] { ni, nj });
					}
				}
			}
		}
	}

	public static void solution1() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp[j] - '0';
			}
		}

		Queue<int[]> queue = new ArrayDeque<int[]>();
		boolean[][] visit = new boolean[N][M];
		int answer = 0;
		boolean exit = false;
		queue.add(new int[] { 0, 0 });
		visit[0][0] = true;
		while (!queue.isEmpty() && !exit) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				int[] p = queue.poll();
				if (p[0] == N - 1 && p[1] == M - 1) {
					exit = true;
					break;
				}

				for (int d = 0; d < di.length; d++) {
					int ni = p[0] + di[d];
					int nj = p[1] + dj[d];

					if (0 <= ni && ni < N && 0 <= nj && nj < M && map[ni][nj] == 1 && !visit[ni][nj]) {
						visit[ni][nj] = true;
						queue.add(new int[] { ni, nj });
					}
				}
			}
			answer += 1;
		}
		System.out.println(answer);
	}

}
