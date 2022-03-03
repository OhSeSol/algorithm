import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++){
            System.out.println(solution(arr[i]));
        }
    }

    private static int solution(int x) {
        int[] arr = new int[11];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        if(x>3){
            for(int i=4; i<x+1; i++){
                arr[i] = arr[i-3]+arr[i-2]+arr[i-1];
            }
        }
        return arr[x];
    }
}
