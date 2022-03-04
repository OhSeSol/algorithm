import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        StringBuffer lcs = new StringBuffer();
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for(int i=1; i<str1.length()+1; i++){
            for(int j=1; j<str2.length()+1; j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int i = str1.length();
        int j = str2.length();
        while(true){
            if(i==0||j==0) break;
            if(dp[i][j]==dp[i-1][j]) {
                i--;
            }
            else if(dp[i][j]==dp[i][j-1]) {
                j--;
            }
            else {
                lcs.append(str1.charAt(i-1));
                i--;
                j--;
            }
        }


        System.out.println(dp[str1.length()][str2.length()]);
        if(dp[str1.length()][str2.length()]!=0){
            System.out.println(lcs.reverse());    
        }
        

    }
}
