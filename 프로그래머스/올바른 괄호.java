class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int left = 0;
        int right = 0;
        //첫 문자가 ) 이면 false 반환
        if(s.charAt(0)==')') return false;
        //문자열 돌다가
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                answer = false;
                left++;
            }else{
                answer = true;
                right++;
            }
            //'('보다 ')'의 개수가 많다면 이미 틀린 괄호이기 때문에 반환
            if(left<right) return false;
        }
        //'('와 ')'의 개수가 다르면 false 반환
        if(left!=right) return false;
        return answer;
    }
}
