package 정보올림피아드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 소수구하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (isPrime(num)) {
                sb.append(num).append("\n");
            } else {
                boolean findPrime = false;
                for (int tmp = 1; tmp <= Math.max(num, 1000000 - num) && !findPrime; tmp++) {
                    if (num - tmp > 0 && isPrime(num - tmp)) {
                        sb.append(num - tmp).append(" ");
                        findPrime = true;
                    }
                    if (num + tmp < 1000000 && isPrime(num + tmp)) {
                        sb.append(num + tmp);
                        findPrime = true;
                    }
                }
                sb.append("\n");
            }
        }
        System.out.print(sb.toString());
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
