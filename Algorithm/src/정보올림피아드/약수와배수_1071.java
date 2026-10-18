package 정보올림피아드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 약수와배수_1071 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		int target = Integer.parseInt(br.readLine());
		int divisor = 0, multiple = 0;
		for (int i = 0; i < N; i++) {
			if (target % numbers[i] == 0) {
				divisor += numbers[i];
			}
			if (numbers[i] % target == 0) {
				multiple += numbers[i];
			}
		}
		System.out.println(divisor);
		System.out.println(multiple);
	}
}
