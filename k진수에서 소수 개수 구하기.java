class Solution {
    public int solution(int n, int k) {
        String str = conversion(n,k);
        String[] arr = str.split("0");
        int answer = 0;
        for(String s : arr){
            if(!s.isEmpty()&&isPrime(Long.parseLong(s))) answer++;
        }
        return answer;
    }
    
    //진수 변환 함수
    public String conversion(int n, int k){
      StringBuilder sb = new StringBuilder();
	    int current = n;
	 
      while(current > 0){      
        sb.append(current % k);   
        current /= k;
      }
        
      return sb.reverse().toString();
    }
    
    //소수 판별 함수
    public boolean isPrime(long number) {

        // 0 과 1 은 소수가 아니다
        if(number < 2) {
            return false;
        }

        // 2 는 소수다
        if(number == 2) {
            return true;
        }

        // 제곱근 함수 : Math.sqrt()
        for(int i = 2; i <= Math.sqrt(number); i++) {

            // 소수가 아닐경우
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
