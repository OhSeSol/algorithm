import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) throws ParseException {
        HashMap<String, String> map = new HashMap<>();  //입차 기록 저장 map
        HashMap<String, Long> timeMap = new HashMap<>(); //누적 주차 시간 저장 map
        SimpleDateFormat f = new SimpleDateFormat("HH:mm");
        for(String record : records){
            String[] arr = record.split(" ");
            if(arr[2].equals("IN")){ //입차시 입차 기록 map에 저장
                map.put(arr[1], arr[0]);
            }else{ //출차시
                long diff = (f.parse(arr[0]).getTime()-f.parse(map.get(arr[1])).getTime())/60000; //입차 시간 확인 후 출차 시간과의 차이 계산
                timeMap.put(arr[1], timeMap.getOrDefault(arr[1],0L)+diff); //누적 주차 시간 map에 저장
                map.remove(arr[1]); //입차 기록 map에서 삭제
            }
        }
        
        //입차 기록 map에 남아있는 차들은 출차 시간을 23:59으로 설정하여 누적 시간 계산
        for (String s : map.keySet()) {
            long diff = (f.parse("23:59").getTime()-f.parse(map.get(s)).getTime())/60000;
            timeMap.put(s, timeMap.getOrDefault(s,0L)+diff);
        }
        
        //주차 요금 계산
        List<String> keyList = new ArrayList<>(timeMap.keySet());
        int[] answer = new int[keyList.size()];
        Collections.sort(keyList);
        for(int i=0; i<answer.length; i++){
            if(timeMap.get(keyList.get(i))<=fees[0]){
                answer[i] = fees[1];
            }else{
                answer[i] = (int) (fees[1]+Math.ceil((double) (timeMap.get(keyList.get(i))-fees[0])/fees[2])*fees[3]);
            }
        }
        return answer;
    }

}
