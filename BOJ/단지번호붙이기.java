import java.util.*;

class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n, count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> answerList = new ArrayList<>();
        n = sc.nextInt();
        int[][] graph = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        sc.nextLine();
        for(int i=0; i<n; i++){
            String str = sc.nextLine();
            for(int j=0; j<n; j++){
                graph[i][j] = str.charAt(j)-'0';
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(graph[i][j]==1 && !visited[i][j]){
                    count = 0;
                    dfs(i, j, graph, visited);
                    answerList.add(count);
                }
            }
        }
        Collections.sort(answerList);
        System.out.println(answerList.size());
        for (Integer integer : answerList) {
            System.out.println(integer);
        }
    }

    private static void dfs(int x, int y, int[][] graph, boolean[][] visited) {
        visited[x][y] = true;
        count++;
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>-1 && nx<n && ny>-1 && ny<n){
                if(graph[nx][ny]==1 && !visited[nx][ny]){
                    dfs(nx, ny, graph, visited);
                }
            }
        }
    }


}

