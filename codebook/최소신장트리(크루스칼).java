import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//시간복잡도 O(ElogE) -> 간선이 적을 때 유용
public class 크루스칼 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int[] parent = new int[v+1];
        // 부모 테이블상에서, 부모를 자기 자신으로 초기화
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        // 모든 간선에 대한 정보를 입력 받기
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(a, b, cost));
        }

        System.out.println(kruskal(pq, parent));
    }

    // 특정 원소가 속한 집합을 찾기
    public static int findParent(int[] parent, int x) {
        // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
        if (x != parent[x]) {
            return parent[x] = findParent(parent, parent[x]);
        }else{
            return x;
        }
    }

    // 두 원소가 속한 집합을 합치기
    public static void unionParent(int[] parent, int a, int b) {
        a = findParent(parent, a);
        b = findParent(parent, b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    static int kruskal(PriorityQueue<Edge> pq, int[] parent) {
        int result = 0;

        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            int cost = edge.distance;
            int a = edge.nodeA;
            int b = edge.nodeB;
            // 사이클이 발생하지 않는 경우에만 집합에 포함
            if (findParent(parent, a) != findParent(parent, b)) {
                unionParent(parent, a, b);
                result += cost;
            }
        }
        return result;
    }

    static class Edge implements Comparable<Edge> {
        int nodeA;
        int nodeB;
        int distance;

        public Edge(int nodeA, int nodeB, int distance) {
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.distance = distance;
        }


        // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
        @Override
        public int compareTo(Edge other) {
            return this.distance - other.distance;
        }

    }
}
