package 정보올림피아드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수와합성수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int N = Integer.parseInt(st.nextToken());
            if (N == 1) {
                sb.append("number one\n");
            } else if (isPrime(N)) {
                sb.append("prime number\n");
            } else {
                sb.append("composite number\n");
            }
        }
        System.out.print(sb.toString());
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) { // 자기 자신 말고 다른 수로 나누어짐
                return false;
            }
        }
        return true;
    }
}
