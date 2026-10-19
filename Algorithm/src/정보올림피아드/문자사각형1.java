package 정보올림피아드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자사각형1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                //         
                sb.append((char) ('A' + (N * j + i) % 26)).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
