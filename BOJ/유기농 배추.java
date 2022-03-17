import java.util.*;

class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseNum = sc.nextInt();
        int[][][] graph = new int[caseNum][][];
        boolean[][][] visited = new boolean[caseNum][][];
        for(int i=0; i<caseNum; i++){
            int m = sc.nextInt();
            int n = sc.nextInt();
            int k = sc.nextInt();
            graph[i] = new int[m][n];
            visited[i] = new boolean[m][n];
            for(int j=0; j<k; j++){
                graph[i][sc.nextInt()][sc.nextInt()] = 1;
            }
        }

        for(int i=0; i<caseNum; i++){
            count = 0;
            for(int j=0; j<graph[i].length; j++){
                for(int k=0; k<graph[i][j].length; k++){
                    if(graph[i][j][k]==1 && !visited[i][j][k]){
                        count++;
                        dfs(j, k, graph[i], visited[i]);
                    }
                }
            }
            System.out.println(count);
        }

    }

    private static void dfs(int x, int y, int[][] graph, boolean[][] visited) {
        visited[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>-1 && nx<graph.length && ny>-1 && ny<graph[0].length){
                if(graph[nx][ny]==1 && !visited[nx][ny]){
                    dfs(nx, ny, graph, visited);
                }
            }
        }
    }


}

