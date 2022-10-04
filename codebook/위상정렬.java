import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TopologySort {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < v+1; i++) {
            graph.add(new ArrayList<>());
        }
        int[] inDegree = new int[v+1];

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int end = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            inDegree[end]++;
            graph.get(start).add(end);
        }

        Queue<Integer> q = new ArrayDeque<>();
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = 1; i < v+1; i++) {
            if(inDegree[i]==0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            Integer idx = q.poll();
            stk.push(idx);

            for (Integer next : graph.get(idx)) {
                inDegree[next]--;
                if(inDegree[next]==0){
                    q.offer(next);
                }
            }
        }

        while(!stk.isEmpty()){
            System.out.print(stk.pop() +" ");
        }
    }
}
