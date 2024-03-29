package bronze5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_10807 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] array = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		int v = Integer.parseInt(br.readLine());
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (array[i] == v) {
				count++;
			}
		}
		System.out.println(count);
	}

}
