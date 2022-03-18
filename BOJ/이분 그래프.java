//풀이 참고 : https://toastfactory.tistory.com/115
//처음엔 그래프 탐색 다 해놓고 visited를 통해 이분 그래프인지 확인하려고 했으나 그럴 필요 없음

import java.util.*;

class Main {
    static int v, e;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[][] visited;
    static String answer = "YES";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseNum = sc.nextInt();
        visited = new int[caseNum][];
        for(int i=0; i<caseNum; i++){
            v = sc.nextInt();
            visited[i] = new int[v+1];
            for(int j=0; j<v+1; j++){
                graph.add(new ArrayList<>());
            }
            e = sc.nextInt();
            for(int j=0; j<e; j++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
            for(int j=1; j<=v; j++){
                if(visited[i][j]==0){
                    if(!bfs(j, visited[i])){
                        break;
                    }
                }
            }
            System.out.println(answer);
            answer = "YES";
            graph.clear();
        }

    }

    private static boolean bfs(int x, int[] visit) {
        Queue<Integer> q = new LinkedList<>();
        visit[x] = 1;
        q.offer(x);
        while(!q.isEmpty()){
            int a = q.poll();
            for(Integer i : graph.get(a)){
                if(visit[i]==0){
                    visit[i] = visit[a]*-1;
                    q.offer(i);
                }else if(visit[i]==visit[a]){
                    answer = "NO";
                    return false;
                }
            }
        }
        return true;
    }

}


