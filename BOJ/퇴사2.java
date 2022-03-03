//시간 초과 코드 -> 가장 긴 감소하는 부분 수열처럼 풂

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] t = new int[n];
        int[] p = new int[n];
        int[] dp = new int[n];
        for(int i=0; i<n; i++){
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        dp[0] = p[0];
        for(int i=1; i<n; i++){
            if(t[i]+i-1>=n){
                continue;
            }
            dp[i] = p[i];
            for(int j=i-1; j>=0; j--){
                if(t[j]+j-1<i && dp[j]+p[i]>dp[i]){
                    dp[i] = dp[j]+p[i];
                }
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}

//풀이 참고: https://loosie.tistory.com/219?category=982577
import java.util.Arrays;
import java.util.Scanner;

public class Main {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] t = new int[n];
        int[] p = new int[n];
        int[] dp = new int[n+1];
        for(int i=0; i<n; i++){
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        int max = 0;
        for(int i=0; i<n; i++){
            if(max < dp[i]) {
                max = dp[i];
            }
            if(t[i]+i<n+1){
                dp[t[i]+i] = Math.max(p[i]+max, dp[t[i]+i]);
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
