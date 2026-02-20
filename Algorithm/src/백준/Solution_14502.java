package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_14502 {
	static List<int[]> virus, empty;
	static int[][] select, map;
	static int[] di = { 0, 1, 0, -1 }, dj = { 1, 0, -1, 0 };
	static int N, M, answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		virus = new ArrayList<int[]>();
		empty = new ArrayList<int[]>();
		select = new int[3][2];
		map = new int[N][M];
		answer = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					virus.add(new int[] { i, j });
				} else if (map[i][j] == 0) {
					empty.add(new int[] { i, j });
				}
			}
		}
		comb(3, 0, 0);
		System.out.println(answer);
	}

	public static int bfs(int[][] lab) {
		int cnt = 0;
		Queue<int[]> queue = new LinkedList<int[]>();
		for (int i = 0; i < virus.size(); i++) {
			queue.add(virus.get(i));
		}
		while (!queue.isEmpty()) {
			int[] p = queue.poll();

			for (int d = 0; d < di.length; d++) {
				int ni = p[0] + di[d];
				int nj = p[1] + dj[d];

				if (0 <= ni && ni < N && 0 <= nj && nj < M && lab[ni][nj] == 0) {
					lab[ni][nj] = 2;
					queue.add(new int[] { ni, nj });
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (lab[i][j] == 0) {
					cnt += 1;
				}
			}
		}
		return cnt;
	}

	public static void comb(int n, int cnt, int cur) {
		if (n == cnt) {
			int[][] lab = new int[N][M];
			for (int i = 0; i < N; i++) { // 복사
				lab[i] = map[i].clone();
			}
			for (int i = 0; i < select.length; i++) {
				lab[select[i][0]][select[i][1]] = 1;
			}
			answer = Math.max(answer, bfs(lab));
			return;
		}

		for (int i = cur; i < empty.size(); i++) {
			select[cnt][0] = empty.get(i)[0];
			select[cnt][1] = empty.get(i)[1];
			comb(n, cnt + 1, i + 1);
		}
	}
}
