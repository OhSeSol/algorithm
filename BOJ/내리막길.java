/*
dfs만 사용한 기존 풀이법 -> 당연히 시간초과
dp와 dfs의 혼합 
풀이 출처:https://hidelookit.tistory.com/171
*/
import java.util.Scanner;

public class Main {
    static int n, m, answer;
    static int[][] dp;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {-1,0,1,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        int[][] map = new int[m][n];
        dp = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                map[i][j] = sc.nextInt();
                dp[i][j] = -1;
            }
        }
        System.out.println(dfs(0,0, map));
    }

    public static int dfs(int x, int y, int[][] map){
        if(x==m-1 && y==n-1){
            return 1;
        }

        if(dp[x][y]!=-1){
            return dp[x][y];
        }else{
            dp[x][y]=0;
            for(int i=0; i<4; i++){
                if(x+dx[i]>=0 && x+dx[i]<=m-1 && y+dy[i]>=0 && y+dy[i]<=n-1 && map[x+dx[i]][y+dy[i]]<map[x][y]){
                    dp[x][y] += dfs(x+dx[i], y+dy[i], map);
                }
            }
        }

        return dp[x][y];

    }
}
