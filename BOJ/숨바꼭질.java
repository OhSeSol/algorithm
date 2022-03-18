import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        if(n>=k){
            System.out.println(n-k);
        }else{
            int[] dp = new int[k+1];
            dp[n+1] = 1;
            for(int i=n+2; i<k+1; i++){
                if(i%2==1){
                    if((i+1)/2<n){
                        dp[i] = Math.min(dp[i-1]+1, n-(i+1)/2+2);
                    }else{
                        dp[i] = Math.min(dp[i-1]+1, dp[(i+1)/2]+2);
                    }
                }else{
                    if(i/2<n){
                        dp[i] = Math.min(dp[i-1]+1, n-i/2+1);
                    }else{
                        dp[i] = Math.min(dp[i-1]+1, dp[i/2]+1);
                    }
                }
            }
            System.out.println(dp[k]);
        }
    }
}
