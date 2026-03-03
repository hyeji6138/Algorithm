package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2110 {
	static int[] house;
	static int N, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		house = new int[N];

		for (int i = 0; i < N; i++) {
			house[i] = Integer.parseInt(br.readLine()); // 좌표
		}
		Arrays.sort(house);

		int left = 1;
		int right = house[N - 1] - house[0];
		int answer = 0;

		while (left <= right) {
			int mid = (left + right) / 2; // 공유기 사이 최소 거리

			if (canInstall(mid)) {
				answer = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(answer);
	}

	public static boolean canInstall(int mid) { // C개 이상 설치 가능한지
		int cnt = 1;
		int lastInstalled = house[0];

		for (int i = 1; i < N; i++) {
			if (mid <= house[i] - lastInstalled) {
				cnt += 1;
				lastInstalled = house[i];
			}
		}

		return C <= cnt;
	}
}
