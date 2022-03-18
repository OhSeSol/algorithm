//벽을 하나씩 지워보면서 bfs -> 예상대로 시간 초과
import java.util.*;

class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n, m;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        int[][] graph = new int[n][m];
        for(int i=0; i<n; i++){
            String str = sc.nextLine();
            for(int j=0; j<m; j++){
                graph[i][j] = str.charAt(j)-'0';
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(graph[i][j]==1){
                    graph[i][j] = 0;
                    int[][] temp = copyArray(graph);
                    graph[i][j] = 1;
                    bfs(temp);
                }
            }
        }

        if(answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);

    }

    private static void bfs(int[][] temp) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0));
        while(!q.isEmpty()){
            Node node = q.poll();
            int x = node.getX();
            int y = node.getY();
            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m){
                    if(temp[nx][ny]==0){
                        temp[nx][ny] += temp[x][y]+1;
                        q.offer(new Node(nx, ny));
                    }
                }
            }
        }
        if(temp[n-1][m-1]>0) answer = Math.min(answer, temp[n-1][m-1]+1);
    }

    public static int[][] copyArray(int[][] graph){
        int[][] result = new int[n][m];
        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[0].length; j++){
                result[i][j] = graph[i][j];
            }
        }

        return result;
    }

}

class Node{
    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}


//코드 참고 : https://moonsbeen.tistory.com/125
//핵심 풀이 : 벽을 부쉈을 때의 visited와 부수지 않았을 때의 visited를 구분
