import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
     public int solution(String str) {
        Pattern pattern = Pattern.compile("([0-9]+)([SDT])([*#]?)");
       //() -> 찾은 패턴에 1부터 번호 매겨줌 
       //[] -> 내부의 문자열과 일치하는 문자 1개
       //+  -> 1회이상 반복
       //?  -> 0또는 1회만 등장
        Matcher matcher = pattern.matcher(dartResult);
        while(matcher.find()){
          matcher.group(); //찾은 패턴 통으로 반환
          matcher.group(1); //찾은 패턴에서 첫번째 그룹. 위의 예에서 숫자부분  
        }
    }
}
