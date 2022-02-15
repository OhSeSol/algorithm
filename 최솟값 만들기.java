import java.util.Arrays;

//가장 큰 값과 가장 작은 값이 곱해져야 최솟값을 만들 수 있다

class Solution{
     public static int solution(int []A, int []B){
        Arrays.sort(A);
        Arrays.sort(B);
        int sum = 0;
        for(int i=0; i<A.length; i++){
            sum += A[i]*B[A.length-i-1];
        }
        return sum;
    }
}
