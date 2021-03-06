//코드 출처: https://codeung.tistory.com/120

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr= new int[n];
        int[] dp = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        dp[0] = 1;
        for(int i=0; i<n; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(arr[j]>arr[i] && dp[j]+1>dp[i]){
                    dp[i] = dp[j]+1;
                }
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
