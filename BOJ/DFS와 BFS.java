import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[n+1];
        for(int i=0; i<n+1; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i=1; i<n+1; i++){
            Collections.sort(graph.get(i));
        }

        dfs(v, graph, visited);
        Arrays.fill(visited, false);
        System.out.println();
        bfs(v, graph, visited);
    }

    private static void bfs(int x, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        visited[x] = true;
        while(!q.isEmpty()){
            int y = q.poll();
            System.out.print(y + " ");
            for (Integer integer : graph.get(y)) {
                if(!visited[integer]){
                    q.offer(integer);
                    visited[integer] = true;
                }
            }
        }
    }

    private static void dfs(int x, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
        visited[x] = true;
        System.out.print(x +" ");
        for (Integer integer : graph.get(x)) {
            if(!visited[integer]) dfs(integer, graph, visited);
        }
    }
}

