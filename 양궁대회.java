class Solution {
    static boolean[] visited = new boolean[11];
    static int[] result = new int[11];
    static int[] maxResult = new int[11];
    static int maxDiff = 0;

    public int[] solution(int n, int[] info) {
        dfs(n, info);
        System.out.println(maxDiff);
        if(maxDiff>0) return maxResult;
        else return new int[] {-1};
    }

    public void dfs(int n, int[] info){
        if(n==0){
            int sum = 0;
            for(int i=0; i<info.length; i++){
                if(info[i]!=0&&info[i]>=result[i]) sum -= 10-i;
                else if(info[i]<result[i]) sum+= 10-i;
            }
            if(sum>maxDiff){
                maxDiff = sum;
                maxResult = result.clone();
            }else if(sum==maxDiff){
                for(int i=10; i>=0; i--){
                    if(maxResult[i]!=result[i]){
                        maxResult = (maxResult[i]>result[i]) ? maxResult : result.clone();
                    }
                }
            }

            return;
        }

        for(int i=0; i<result.length; i++){
            if(!visited[i]){
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
