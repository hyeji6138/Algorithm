package 정보올림피아드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자사각형2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < N; j++) {
                if (j % 2 != 0) {// 세로짝수번째줄
                    sb.append((char) ('A' + (N * j + (N - i)) % 26)).append(" ");
                } else {
                    sb.append((char) ('A' + (N * j + (i - 1)) % 26)).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
