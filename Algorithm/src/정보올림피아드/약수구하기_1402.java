package 정보올림피아드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 약수구하기_1402 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        int cnt = 0, result = 0;
        for (int i = 1; i <= N && cnt != K; i++) {
            if (N % i == 0) {
                cnt++;
                result = i;
            }
        }
        if(cnt != K){
            result = 0;
        }
        System.out.println(result);
    }

}