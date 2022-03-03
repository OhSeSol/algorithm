import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stairs = new int[n];
        for(int i=0; i<n; i++){
            stairs[i] = sc.nextInt();
        }

        System.out.println(solution(stairs));

    }

    private static int solution(int[] stairs) {
        if(stairs.length==1) return stairs[0];
        int[][] answer = new int[stairs.length][2];
        answer[0][0] = stairs[0];
        answer[0][1] = stairs[0];
        answer[1][0] = stairs[0]+stairs[1];
        answer[1][1] = stairs[1];
        for(int i=2; i<stairs.length; i++){
            answer[i][0] = answer[i-1][1]+stairs[i];
            answer[i][1] = Math.max(answer[i-2][0],answer[i-2][1])+stairs[i];
        }

        return Math.max(answer[stairs.length-1][0],answer[stairs.length-1][1]);
    }
}
