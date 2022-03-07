/*
테스트 케이스 10, 19, 30이 계속 오답이라 생각하지 않은 경우를 찾아보니 다음과 같은 경우를 생각하지 않았다.
네오가 들은 멜로디 : ABCD
곡의 멜로디 : ABCD 재생된 시간 3
라디오에서는 3분동안만 재생되었기때문에 네오는 D라는 음을 들을 수 없다. 따라서 정답 후보 리스트에 들어갈 수 없다.
위의 경우를 해결해주니 오답이었던 테스트 케이스도 해결되었다.
*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


class Solution {
    public String solution(String m, String[] musicinfos) throws ParseException {
        SimpleDateFormat f = new SimpleDateFormat("hh:mm");
        m = conversion(m);
        Music[] arr = new Music[musicinfos.length];
        List<Music> answerList = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            Date d1 = f.parse(musicinfos[i].split(",")[0]);
            Date d2 = f.parse(musicinfos[i].split(",")[1]);
            long playTime = (d2.getTime()-d1.getTime())/60000;
            String melody = musicinfos[i].split(",")[3];
            melody = conversion(melody);
            arr[i] = new Music(i, playTime, musicinfos[i].split(",")[2], melody);
        }

        for (Music music : arr) {
            if(music.melody.contains(m)) answerList.add(music);
        }

        Collections.sort(answerList);

        if(answerList.isEmpty()){
            return "(None)";
        }else return answerList.get(0).name;

    }

    public String conversion(String str){
        str = str.replaceAll("C#", "c");
        str = str.replaceAll("D#", "d");
        str = str.replaceAll("A#", "a");
        str = str.replaceAll("F#", "f");
        str = str.replaceAll("G#", "g");

        return str;
    }


}

class Music implements Comparable<Music>{

    int number;
    long playTime;
    String name;
    String melody;

    public Music(int number, long playTime, String name, String melody){
        this.number = number;
        this.playTime = playTime;
        this.name = name;
        if(playTime>melody.length()){
            StringBuffer sb = new StringBuffer(melody);
            for(int i=0; i<playTime/melody.length(); i++){
                sb.append(melody);
                this.melody = sb.toString();
            }
        }else if(playTime<melody.length()){
            this.melody = melody.substring(0,(int) playTime);
        }else this.melody = melody;
    }

    @Override
    public int compareTo(Music o) {
        if(this.playTime > o.playTime){
            return -1;
        }else if(this.playTime == o.playTime){
            if(this.number > o.number){
                return 1;
            }
        }
        return 1;
    }
}
