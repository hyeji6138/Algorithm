package 정보올림피아드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대공약수최소공배수_1002 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        int gcd = getGCD(numbers[0], numbers[1]);
        int lcm = (numbers[0] * numbers[1]) / gcd;
        for (int i = 2; i < N; i++) {
            gcd = getGCD(gcd, numbers[i]);
            lcm = lcm * (numbers[i] / getGCD(lcm, numbers[i]));
        }
        System.out.print(gcd + " " + lcm);
    }

    public static int getGCD(int a, int b) {
        for (int i = Math.min(a, b); i > 0; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 0;
    }
}
