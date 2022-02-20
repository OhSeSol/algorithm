/*
시간초과 코드
1.2진수로 변환한 수에서 뒤쪽부터 반복문을 돌며 가장 먼저 나오는 '01'을 찾음
2.01 -> 10으로 바꾼 뒤
3.끝자리가 0인 경우 10으로 바꾼 자리 뒤부터 역순으로 붙임
4.끝자리가 1인 경우 자리만 바꿔줌
5.반복문 다 돌아도 '01'을 찾지 못하면 두 번째 자리에 0 삽입 후
6.3,4 경우와 동일하게 처리
*/
class Solution {
    public int solution(int n) {
        StringBuffer bin = new StringBuffer(Integer.toBinaryString(n));
        for(int i=bin.length()-2; i>0; i--){
            if(bin.charAt(i)=='0'&&bin.charAt(i+1)=='1'){
                if(bin.charAt(bin.length()-1)=='0'){
                    bin.replace(i,i+2,"10");
                    StringBuffer sb = new StringBuffer(bin.substring(i+2));
                    String str = sb.reverse().toString();
                    bin.replace(i+2, bin.length(), str);
                    return Integer.parseInt(bin.toString(), 2);
                }else{
                    bin.replace(i, i+2, "10");
                    return Integer.parseInt(bin.toString(), 2);
                }
            }
        }
        if(bin.charAt(bin.length()-1)=='0'){
                    bin.insert(1,'0');
                    StringBuffer sb = new StringBuffer(bin.substring(2));
                    String str = sb.reverse().toString();
                    bin.replace(2, bin.length(), str);
                    return Integer.parseInt(bin.toString(), 2);
                }else{
                    bin.insert(1,'0');
                    return Integer.parseInt(bin.toString(), 2);
                }
        
    }
}


//그냥 1씩 증가시켜 확인하는 방법은 시간 통과
class Solution {
    public int solution(int n) {
        int answer = 0;
        int count = binary(n);
        int index = 1;
        while (true) {
            int number = n + index;
            if (count == binary(number)) {
                answer = number;
                break;
            }
            index++;
        }
        return answer;
    }

    public int binary(int x) {
        String str = Integer.toBinaryString(x);
        int sum = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='1'){
                sum++;
            }
        }
        return sum;
    }
}
