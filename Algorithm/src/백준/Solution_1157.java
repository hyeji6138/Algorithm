package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1157 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] alpha = br.readLine().toCharArray();
		int maxCnt = 0;
		int[] cnt = new int[26];
		for (int i = 0; i < alpha.length; i++) {
			cnt[Character.toUpperCase(alpha[i]) - 'A']++;
		}
		int idx = 0;
		for (int i = 0; i < cnt.length; i++) {
			if (maxCnt < cnt[i]) {
				maxCnt = cnt[i];
				idx = i;
			} else if (maxCnt == cnt[i]) {
				idx = -1;
			}
		}
		if (idx < 0) {
			System.out.println("?");
		} else {
			System.out.println((char) ('A' + idx));
		}
	}
}
