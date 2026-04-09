package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4153 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] len = new int[3];
			for (int i = 0; i < 3; i++) {
				len[i] = Integer.parseInt(st.nextToken());
			}
			if (len[0] + len[1] + len[2] == 0) {
				break;
			}
			Arrays.sort(len);
			if (len[0] * len[0] + len[1] * len[1] == len[2] * len[2]) {
				sb.append("right\n");
			} else {
				sb.append("wrong\n");
			}
		}
		System.out.print(sb);
	}
}
