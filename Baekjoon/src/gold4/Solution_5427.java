package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5427 {
	static int T, R, C;
	static int[] di = { -1, 1, 0, 0 }, dj = { 0, 0, -1, 1 };
	static char[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());

			map = new char[R][C];
			boolean[][] fireVisit = new boolean[R][C];
			boolean[][] jihoonVisit = new boolean[R][C];
			Queue<int[]> fire = new LinkedList<>();
			Queue<int[]> jihoon = new LinkedList<>();
			for (int i = 0; i < R; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < C; j++) {
					if (map[i][j] == '*') {
						fire.add(new int[] { i, j });
						fireVisit[i][j] = true;
					} else if (map[i][j] == '@') {
						jihoon.add(new int[] { i, j });
						jihoonVisit[i][j] = true;
					}
				}
			}
			// =======================================
			int time = 0;
			int answer = Integer.MAX_VALUE;
			boolean exit = false;

			while (true) {
				int size = fire.size();
				for (int s = 0; s < size; s++) {
					int[] firePoint = fire.poll();

					for (int d = 0; d < di.length; d++) {
						int ni = firePoint[0] + di[d];
						int nj = firePoint[1] + dj[d];

						if (ni >= 0 && ni < R && nj >= 0 && nj < C && !fireVisit[ni][nj] && map[ni][nj] != '#') {
							fireVisit[ni][nj] = true;
							map[ni][nj] = '*';
							fire.add(new int[] { ni, nj });
						}
					}
				}
				
				size = jihoon.size();
				for (int s = 0; s < size; s++) {
					int[] jihoonPoint = jihoon.poll();

					for (int d = 0; d < di.length; d++) {
						int ni = jihoonPoint[0] + di[d];
						int nj = jihoonPoint[1] + dj[d];

						if (ni >= 0 && ni < R && nj >= 0 && nj < C) {
							if (!fireVisit[ni][nj] && !jihoonVisit[ni][nj] && map[ni][nj] != '#') {
								jihoonVisit[ni][nj] = true;
								map[ni][nj] = '@';
								jihoon.add(new int[] { ni, nj });
							}
						} else {
							exit = true;
							answer = Math.min(answer, time);
						}
					}
				}
				if (exit || jihoon.isEmpty())
					break;
				time++;
			}
			if (answer == Integer.MAX_VALUE) {
				sb.append("IMPOSSIBLE"+"\n");
			} else {
				sb.append((answer + 1)+"\n");
			}
		}
		System.out.println(sb.toString());

	}

	public static void printArray() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
