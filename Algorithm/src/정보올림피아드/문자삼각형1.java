package 정보올림피아드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자삼각형1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0, value = i, tmp = N - 1; j < N; j++) {
                if (j < N - i - 1) {
                    sb.append(" ");
                } else {
                    sb.append((char) ('A' + value % 26));
                    value += tmp;
                    tmp--;
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
