//왜 틀린지 이유를 모름
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][][] dp = new long[n][n][3];
        for(int i=0; i<n; i++){
            dp[i][i][0] = sc.nextInt();
            dp[i][i][1] = sc.nextInt();
        }
        
        if(n==1){
            System.out.println(0);
        }
        
        for(int i=0; i<n-1; i++){
            dp[i][i+1][0] = dp[i][i][0];
            dp[i][i+1][1] = dp[i+1][i+1][1];
            dp[i][i+1][2] = dp[i][i][0]*dp[i][i][1]*dp[i+1][i+1][1];
        }
        for(int i=2; i<n; i++){
            for(int j=i-2; j>-1; j--){
                dp[j][i][0] = dp[j][i-(i-j)][0];
                dp[j][i][1] = dp[j+1][i][1];
                dp[j][i][2] = Math.min(dp[j][i-(i-j)][0]*dp[j][i-(i-j)][1]*dp[j+1][i][1]+dp[j+1][i][2],dp[j][i-1][0]*dp[j][i-1][1]*dp[j+(i-j)][i][1]+dp[j][i-1][2]);
            }
        }


        System.out.println(dp[0][n-1][2]);

    }
}
