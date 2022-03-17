import java.util.*;

class Main {
    static int[] dh = {1, -1, 0, 0, 0, 0};
    static int[] dx = {0, 0, 0, 1, 0, -1};
    static int[] dy = {0, 0, 1, 0, -1, 0};
    static int m,n,h;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        h = sc.nextInt();
        int[][][] graph = new int[h][n][m];
        sc.nextLine();
        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    graph[i][j][k] = sc.nextInt();
                }
            }
        }


        Queue<Node> q = new LinkedList<>();

        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    if(graph[i][j][k] == 1){
                        q.offer(new Node(i,j,k));
                    }
                }
            }
        }
        bfs(q, graph);
        int answer = check(graph);
        if(answer>0) System.out.println(answer-1);
        else System.out.println(answer);
    }

    private static int check(int[][][] graph) {
        int max = 0;
        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    if(graph[i][j][k]==0) return -1;
                    else{
                        max = Math.max(max, graph[i][j][k]);
                    }
                }
            }
        }
        return max;
    }

    private static void bfs(Queue<Node> q, int[][][] graph) {
        while(!q.isEmpty()){
            Node node = q.poll();
            for(int i=0; i<6; i++){
                int nh = node.getH()+dh[i];
                int nx = node.getX()+dx[i];
                int ny = node.getY()+dy[i];
                if(nh>=0 && nh<h &&nx>=0 && nx<n && ny>=0 && ny<m){
                    if(graph[nh][nx][ny] == 0){
                        graph[nh][nx][ny] += graph[node.getH()][node.getX()][node.getY()]+1;
                        q.offer(new Node(nh, nx, ny));
                    }
                }
            }
        }

    }


}

class Node{
    private int h;
    private int x;
    private int y;

    public Node(int h, int x, int y) {
        this.h = h;
        this.x = x;
        this.y = y;
    }

    public int getH() {
        return h;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

