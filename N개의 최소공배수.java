class Solution {
    public int solution(int[] arr) {
        int result = arr[0];
        for(int i=1; i<arr.length; i++){
            result = lcm(result, arr[i]);
        }
        return result;
    }
    
    public int gcd(int x, int y){ //최대공약수 함수
        if(y==0) return x;
        else return gcd(y, x%y);
    }
    
    public int lcm(int x, int y){ //최소공배수 
        return gcd(x,y)*x/gcd(x,y)*y/gcd(x,y);
    }
}
