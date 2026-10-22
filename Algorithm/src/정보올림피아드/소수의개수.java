package 정보올림피아드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수의개수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
        boolean[] primeNum = new boolean[N + 1];
        for (int i = 2; i <= N; i++) {
            primeNum[i] = true;
        }
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (!isPrime(i)) {
                primeNum[i] = false;
            }
            for (int j = i * i; j <= N; j += i) { // 다음에 나오는 배수들 제거
                primeNum[j] = false;
            }
        }
        int cnt = 0;
        for (int i = M; i <= N; i++) {
            if (primeNum[i]) {
                cnt++;
            }
        }
        System.out.print(cnt);
    }

    public static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
