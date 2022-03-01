import java.util.Scanner;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fibo(n));

    }
    public static BigInteger fibo(int n){
        BigInteger[] arr = new BigInteger[n+1];
        arr[0] = BigInteger.valueOf(0);
        arr[1] = BigInteger.valueOf(1);
        for(int i=2; i<n+1; i++){
            arr[i] = arr[i-2].add(arr[i-1]);
        }
        return arr[n];
    }
}
