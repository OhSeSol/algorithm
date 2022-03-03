import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println(solution(x));
    }

    private static long solution(int x) {
        long[] arr = new long[x+1];
        arr[1] = 1;
        if(x>1){
            arr[2] = 2;
            for(int i=3; i<x+1; i++){
                arr[i] = (arr[i-2]+arr[i-1])%10007;
            }
        }

        return arr[x]%10007;
    }
}
