class Solution {
    boolean[] visited = new boolean[11];
    int[] result = new int[11];
    int[] maxResult = new int[11];
    int maxDiff = 0;

    public int[] solution(int n, int[] info) {
        dfs(n, info);
        if(maxDiff>0) return maxResult;
        else return new int[] {-1};
    }

    public void dfs(int n, int[] info){
        if(n==0){
            int sum = 0;
            for(int i=0; i<info.length; i++){
                if(info[i]!=0&&info[i]>=result[i]) sum -= 10-i; //어피치가 맞힌 화살의 수가 더 많을 때
                else if(info[i]<result[i]) sum+= 10-i; //라이언이 맞힌 화살의 수가 더 많을 때
            }
            if(sum>maxDiff){
                maxDiff = sum;
                maxResult = result.clone();
            }else if(sum==maxDiff){ //점수차가 같을 때
                for(int i=10; i>=0; i--){
                    if(maxResult[i]!=result[i]){
                        maxResult = (maxResult[i]>result[i]) ? maxResult : result.clone(); //가장 낮은 점수를 더 많이 맞힌 경우를 선택
                    }
                }
            }

            return;
        }

        for(int i=0; i<result.length; i++){
            if(!visited[i]){ //
                if(n>=info[i]+1){
                    visited[i] = true;
                    result[i] = info[i] + 1;
                    n -= info[i]+1;
                    dfs(n, info);
                    n += info[i]+1;
                    result[i] = 0;
                    visited[i] = false;
                }else{
                    visited[i] = true;
                    result[i] = n;
                    dfs(0, info);
                    result[i] = 0;
                    visited[i] = false;
                }
            }
        }

    }
}
