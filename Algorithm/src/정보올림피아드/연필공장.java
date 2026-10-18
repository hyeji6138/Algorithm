package 정보올림피아드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연필공장 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int P = Integer.parseInt(st.nextToken()), V = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        int A, B, C, D;
        int gcd = getGCD(P + 1, V + 1);
        if(gcd != 1){
            // 도색도 광택도 되지 않은 연필 수
            // (p+1)과 (v+1)의 최소공배수의 배수
            int lcm = (P + 1) / getGCD(P + 1, V + 1) * (V + 1);
            B = K / lcm;
        }else{
            B = 0; // 둘다 안된 연필이 나올 수 없는 경우
        }
        D = K / (P + 1) - B; // 광택은 되었으나 도색이 되지 않은 연필 수
        C = K / (V + 1) - B; // 도색은 되었으나 광택이 되지 않은 연필 수
        A = K - (B + C + D); // 도색과 광택이 완료된 연필 수
        System.out.print(A + " " + B + " " + C + " " + D);
    }

    public static int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }
}
