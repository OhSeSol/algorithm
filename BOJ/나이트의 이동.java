import java.util.*;

class Main {
    static int[] dx = {2, 2, -2, -2, 1, 1, -1,-1};
    static int[] dy = {-1, 1, -1, 1, 2, -2, 2, -2};
    static int n;
    static ArrayList<Integer> answerList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseNum = sc.nextInt();
        int[][][] graph = new int[caseNum][][];
        for(int i=0; i<caseNum; i++){
            n =sc.nextInt();
            graph[i] = new int[n][n];
            Node startNode = new Node(sc.nextInt(), sc.nextInt());
            Node goalNode = new Node(sc.nextInt(), sc.nextInt());
            if(startNode.getX()== goalNode.getX() && startNode.getY()== goalNode.getY()) answerList.add(0);
            else bfs(startNode, goalNode, graph[i]);
        }
        for (Integer integer : answerList) {
            System.out.println(integer);
        }



    }

    private static void bfs(Node start, Node goal, int[][] graph) {
        Queue<Node> q = new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()){
            Node node = q.poll();
            int x = node.getX();
            int y = node.getY();
            for(int i=0; i<8; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<n){
                    if(graph[nx][ny]==0){
                        graph[nx][ny] += graph[x][y]+1;
                        if(nx==goal.getX() && ny==goal.getY()){
                            answerList.add(graph[nx][ny]);
                            break;
                        }else q.offer(new Node(nx, ny));
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
