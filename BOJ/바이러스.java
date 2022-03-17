import java.util.*;

class Main {
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
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

        dfs(1, graph, visited);
        System.out.println(count);
    }


    private static void dfs(int x, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
        visited[x] = true;
        for (Integer integer : graph.get(x)) {
            if(!visited[integer]) {
                count++;
                dfs(integer, graph, visited);
            }
        }
    }
}

