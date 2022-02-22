import java.util.*;

class Solution {
    public List<Integer> solution(String msg) {
        List<String> dic = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();

      //길이 1인 단어를 포함하는 사전 초기화
        for(char a='A'; a<='Z'; a++){
            dic.add(Character.toString(a));
        }

      //단어의 시작 글자
        for(int i=0; i<msg.length(); i++){
          //단어의 끝 글자
            for(int j=i+1; j<=msg.length(); j++){
              //substring이 사전에 포함되어 있으면
                if(dic.contains(msg.substring(i,j))){
                    if(j==msg.length()){
                        answer.add(dic.indexOf(msg.substring(i,j))+1);
                        i = j;
                    }
                  //j만 늘려서 확인
                    continue;
               //사전에 없다면
                }else{
                  //해당 substring 사전에 추가
                    dic.add(msg.substring(i,j));
                  //이전 substring 정답 배열에 추가
                    answer.add(dic.indexOf(msg.substring(i,j-1))+1);
                  //사전에서 찾은 부분 이후로 index  
                    i = j-2;
                    break;
                }
            }
        }

        return answer;
    }
}
