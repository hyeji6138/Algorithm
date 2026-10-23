package 정보올림피아드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 십진수를2_8_16진수로 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        while (N > 0) {
            int remainder = N % B;
            if (10 <= remainder) {
                sb.insert(0, (char) ('A' + remainder % 10));
            } else {
                sb.insert(0, remainder);
            }
            N /= B;
        }
        System.out.print(sb.toString());
    }
}
