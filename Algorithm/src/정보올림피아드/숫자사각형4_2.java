package 정보올림피아드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자사각형4_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < N; j++) {
                if (i % 2 != 0) {//홀수번째줄
                    sb.append(j + 1).append(" ");
                } else {
                    sb.append(N - j).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
