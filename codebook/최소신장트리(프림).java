import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//시간복잡도O(ElogV) -> 간선이 많을 때 유용
public class 프림 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //그래프
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();


        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int[] d = new int[v + 1];
        boolean[] visited = new boolean[v + 1];
        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            graph.get(cur).add(new Node(num, distance));
            graph.get(num).add(new Node(cur, distance));
        }

        int INF = 987654321;
        int start = 1;
        Arrays.fill(d, INF);
        int cost = prim(graph, d, visited,start);
        System.out.println(cost);


    }

    static int prim(ArrayList<ArrayList<Node>> graph, int[] d, boolean[] visited, int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));
        d[start] = 0;
        int result = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.idx]) continue;

            result += cur.dist;
            visited[cur.idx] = true;

            for (int i = 0; i < graph.get(cur.idx).size(); i++) {
                Node next = graph.get(cur.idx).get(i);

                if (!visited[next.idx] && d[next.idx] > next.dist) {
                    d[next.idx] = next.dist;
                    pq.offer(new Node(next.idx, d[next.idx]));
                }

            }
        }
        return result;
    }

    static class Node implements Comparable<Node> {
        int idx;
        int dist;

        public Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }
}
