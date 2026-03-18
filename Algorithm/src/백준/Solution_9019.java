package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_9019 {
	static char[] op = { 'D', 'S', 'L', 'R' };
	static final int MAX_VALUE = 10000;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			boolean[] visit = new boolean[MAX_VALUE];
			int[] parent = new int[MAX_VALUE];
			char[] cmd = new char[MAX_VALUE];
			Queue<Integer> queue = new ArrayDeque<>();
			queue.add(A);
			visit[A] = true;
			while (!queue.isEmpty()) {
				int cur = queue.poll();
				if (cur == B) {
					break;
				}
				for (int i = 0; i < op.length; i++) {
					int next = getNextNum(cur, i);

					if (!visit[next]) {
						visit[next] = true; // 방문 체크
						parent[next] = cur; // 부모 저장
						cmd[next] = op[i]; // 명령어 저장
						queue.add(next);
					}
				}
			}
			StringBuilder result = new StringBuilder();
			ArrayDeque<Character> stack = new ArrayDeque<>();
			int cur = B;
			while (cur != A) {
				stack.push(cmd[cur]);
				cur = parent[cur];
			}
			while (!stack.isEmpty()) {
				result.append(stack.pop());
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static int getNextNum(int num, int d) {
		if (d == 0) { // D
			return (num * 2) % MAX_VALUE ;
		} else if (d == 1) {
			return num - 1 < 0 ? MAX_VALUE - 1 : num - 1;
		} else if (d == 2) {
			return (num % 1000) * 10 + (num / 1000);
		}
		return (num % 10) * 1000 + (num / 10);
	}

	public static void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int[] cnt = new int[10000];
			Arrays.fill(cnt, Integer.MAX_VALUE);
			int[][] parent = new int[10000][2];
			Queue<Integer> queue = new ArrayDeque<Integer>();
			queue.add(A);
			cnt[A] = 0;
			while (!queue.isEmpty()) {
				int cur = queue.poll();
				if (cur == B) {
					break;
				}
				int[] nextNum = { cur * 2, cur - 1, (cur % 1000) * 10 + (cur / 1000), (cur % 10) * 1000 + (cur / 10) };
				for (int i = 0; i < nextNum.length; i++) {
					if (9999 < nextNum[i]) {
						nextNum[i] %= 10000;
					} else if (nextNum[i] < 0) {
						nextNum[i] = 9999;
					}

					if (cnt[cur] + 1 < cnt[nextNum[i]]) {
						cnt[nextNum[i]] = cnt[cur] + 1; // 최소 횟수 갱신
						parent[nextNum[i]][0] = cur; // 부모 저장
						parent[nextNum[i]][1] = i; // 명령어 저장
						queue.add(nextNum[i]);
					}
				}
			}
			StringBuilder order = new StringBuilder();
			ArrayDeque<Character> stack = new ArrayDeque<Character>();
			int cur = B;
			while (cur != A) {
				stack.push(op[parent[cur][1]]);
				cur = parent[cur][0];
			}
			while (!stack.isEmpty()) {
				order.append(stack.pop());
			}
			sb.append(order).append("\n");
		}
		System.out.println(sb.toString());
	}

}
