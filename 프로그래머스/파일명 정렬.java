import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public String[] solution(String[] files) {
        List<FileName> names = new ArrayList<>();
        for(int i=0; i<files.length; i++){
            names.add(conversion(files[i], i));
        }
        Collections.sort(names);
        String[] answer = new String[names.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = names.get(i).toString();
        }
        return answer;
    }

  //인자로 들어온 파일명을 새로 정의한 객체로 변환해주는 함수
    private FileName conversion(String file, int idx) {
        String[] split = file.split("[0-9]+",2);
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(file);
        String num="";
        if(m.find()){
            num = m.group();
        }

        return new FileName(split[0], num, split[1], idx);
    }

}

//정렬을 위해 comparable을 구현한 파일명 객체 정의
class FileName implements Comparable<FileName>{

    String head;
    String number;
    String tail;
    int idx;

    public FileName(String head, String number, String tail, int idx) {
        this.head = head;
        this.number = number;
        this.tail = tail;
        this.idx = idx;
    }

    @Override
    public int compareTo(FileName o) {
      //head를 사전순으로 정렬
        if(this.head.compareToIgnoreCase(o.head)>0){
            return 1;
        }else if(this.head.compareToIgnoreCase(o.head)==0){
          //head가 같다면 number를 오름차순으로 정렬
            if(Integer.parseInt(this.number)>Integer.parseInt(o.number)){
                return 1;
            }else if(Integer.parseInt(this.number)==Integer.parseInt(o.number)){
              //number도 같다면 index 기준 오름차순으로 정렬
                if(this.idx>o.idx){
                    return 1;
                }else return -1;
            }else return -1;
        }else return -1;
    }

    @Override
    public String toString() {
        return head+number+tail;
    }
}
