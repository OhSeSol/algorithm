class Solution {
  public String solution(int n, int t, int m, int p) {
    StringBuffer sb = new StringBuffer();
    
    //튜브가 말할 마지막 숫자까지 n진법으로 변환해놓기
    for(int i=0; i<m*t; i++){
      sb.append(conversion(i, n));
    }
    StringBuffer answer = new StringBuffer();
    //튜브가 말해야할 숫자만 고르기
    for(int i=1; i<t+1; i++){
      answer.append(sb.charAt(m*(i-1)+(p-1)));
    }
    return answer.toString();
  }
    
  
  //진수 변환 함수
  public String conversion(int number, int N){
   StringBuilder sb = new StringBuilder();
	   int current = number;
     if(current==0) return "0";
	 
     while(current > 0){
          
       if(current % N < 10){
         sb.append(current % N);
       } else {
         sb.append((char)(current % N - 10 + 'A'));
       }
       current /= N;
     }
        
     return sb.reverse().toString();
   }
}
