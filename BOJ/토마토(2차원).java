import java.util.*;

class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n,m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        int[][] graph = new int[n][m];
        sc.nextLine();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                graph[i][j] = sc.nextInt();
            }
        }

        Queue<Node> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(graph[i][j]==1) q.offer(new Node(i,j));
            }
        }
        bfs(q, graph);
        int answer = check(graph);
        if(answer>0) System.out.println(answer-1);
        else System.out.println(answer);
    }

    private static int check(int[][] graph) {
        int max = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(graph[i][j] == 0) return -1;
                else{
                    max = Math.max(max, graph[i][j]);
                }
            }
        }
        return max;
    }

    private static void bfs(Queue<Node> q, int[][] graph) {
        while(!q.isEmpty()){
            Node node = q.poll();
            for(int i=0; i<4; i++){
                int nx = node.getX()+dx[i];
                int ny = node.getY()+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m){
                    if(graph[nx][ny] == 0){
                        graph[nx][ny] += graph[node.getX()][node.getY()]+1;
                        q.offer(new Node(nx, ny));
                    }
                }
            }
        }

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

