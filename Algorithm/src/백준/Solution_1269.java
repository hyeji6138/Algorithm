package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_1269 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // A의 원소 개수
		int M = Integer.parseInt(st.nextToken()); // B의 원소 개수
		Set<Integer> A = new HashSet<>();
		Set<Integer> B = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			B.add(Integer.parseInt(st.nextToken()));
		}
		// ==================== 입력 끝 ======================
		int answer = 0;
		for (int x : A) {
			if (!B.contains(x)) { // A-B
				answer++;
			}
		}
		for (int x : B) {
			if (!A.contains(x)) { // B-A
				answer++;
			}
		}
		System.out.println(answer);
	}
}
