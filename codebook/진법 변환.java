//number: 변환할 수
//N:N진법
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
