/*1.처음 풀이법은 dfs로 모든 경우의 수를 조사하여 최댓값을 구하는 방법이었으나, 시간초과로 두 번째 방법을 사용
class Solution {
    int max;
    int solution(int[][] land) {
        for(int i=0; i<4; i++){
            dfs(1,i,land[0][i], land);
        }
        return max;
    }
    
    public void dfs(int n,int prev, int sum, int[][] land){
        if(n==land.length-1){
            for(int i=0; i<4; i++){
                max = Math.max(max, sum+land[n][i]);
            }
            return;
        }
        
        for(int i=0; i<4; i++){
            if(i!=prev){
                dfs(n+1, i, sum+land[n][i], land);
            }
        }
    }
}
*/

import java.util.Arrays;

class Solution {
    int solution(int[][] land) {
        int[][] answer = new int [land.length][4]; //각 경우마다 최댓값을 저장할 배열 생성
        answer[0] = land[0].clone();
        for(int i=1; i<land.length; i++){
            for(int j=0; j<4; j++){
                for(int k=0; k<4; k++){
                    if(j!=k){
                        answer[i][j] = Math.max(land[i][j]+answer[i-1][k],answer[i][j]); //n행에서 n-1행의 값을 돌면서 같은 열의 값을 제외한 나머지 열 중 최댓값을 찾음
                    }
                }
            }
        }
        Arrays.sort(answer[land.length-1]);
        return answer[land.length-1][3];
    }
}
