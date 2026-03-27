package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_14425 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Set<String> dict = new HashSet<>();
		for (int i = 0; i < N; i++) {
			dict.add(br.readLine());
		}
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			if (dict.contains(s)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
