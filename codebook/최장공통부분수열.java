/*
최장 공통 부분 수열
수열 A와 B를 각각 행, 열로 가지는 2차원 배열 생성
두 문자열 중 하나의 앞글자부터 나머지 문자열의 전체를 돌면서 같은 문자인지 확인
두 문자가 같으면 dp[i][j] = dp[i-1][j-1]+1
두 문자가 다르면 dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1])
dp의 우측하단이 LCS의 길이
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();
        int[][] dp = new int[str1.length()+1][str2.length()+1];

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[str1.length()][str2.length()]);

    }
}
