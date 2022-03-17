import java.util.*;

class Main{
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n,m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] graph = new int[n][m];
        sc.nextLine();
        for(int i=0; i<n; i++){
            String str = sc.nextLine();
            for(int j=0; j<m; j++){
                graph[i][j] = str.charAt(j)-'0';
            }
        }

        bfs(0,0, graph);
        System.out.println(graph[n-1][m-1]);
    }

    private static void bfs(int x, int y, int[][] graph) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        while(!q.isEmpty()){
            Node node = q.poll();
            for(int i=0; i<4; i++){
                int nx = node.getX()+dx[i];
                int ny = node.getY()+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m){
                    if(graph[nx][ny] == 1){
                        graph[nx][ny] += graph[node.getX()][node.getY()];
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

