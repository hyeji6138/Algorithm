package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution_1620 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<Integer, String> pocketNumber = new HashMap<>();
		Map<String, Integer> pocketName = new HashMap<>();

		for (int i = 1; i <= N; i++) {
			String name = br.readLine();
			pocketNumber.put(i, name);
			pocketName.put(name, i);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			if (pocketName.containsKey(s)) {
				sb.append(pocketName.get(s)).append("\n");
			} else {
				sb.append(pocketNumber.get(Integer.parseInt(s))).append("\n");
			}
		}
		System.out.print(sb);
	}
}
