package 정보올림피아드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 각자리수의역과합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            int sum = 0;
            for (int i = N; i > 0; i /= 10) {
                if (sum == 0 && i % 10 == 0) {
                    continue;
                }
                sb.append(i % 10);
                sum += i % 10;
            }
            sb.append(" ").append(sum).append("\n");
        }
        System.out.print(sb.toString());
    }

}
