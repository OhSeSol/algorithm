import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println(solution(x));
    }

    public static int solution(int x){
        int[] arr = new int[x+1];
        for(int i=2; i<x+1; i++){
            arr[i] = arr[i-1]+1;
            if(i%2==0){
                arr[i] = Math.min(arr[i], arr[i/2]+1);
            }
            if(i%3==0){
                arr[i] = Math.min(arr[i], arr[i/3]+1);
            }
        }
        return arr[x];
    }
}
