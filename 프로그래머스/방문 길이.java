import java.util.*;

class Solution {
    Character[] dir = {'U', 'R', 'D', 'L'};
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0 ,-1};
    
    public int solution(String dirs) {
        int answer = 0;
        List<String> records = new ArrayList<>();
        int x = 0;
        int y = 0;
        for(int i=0; i<dirs.length(); i++){
          //이동할 x, y좌표가 범위 내에 존재하면
            if(x+dx[Arrays.asList(dir).indexOf(dirs.charAt(i))]>=-5&&x+dx[Arrays.asList(dir).indexOf(dirs.charAt(i))]<=5&&y+dy[Arrays.asList(dir).indexOf(dirs.charAt(i))]>=-5&&y+dy[Arrays.asList(dir).indexOf(dirs.charAt(i))]<=5){
              //방문했던 길인지 확인. 처음 방문하는 길이면
                if(!records.contains(Integer.toString(x)+Integer.toString(y)+dirs.charAt(i))){
                  //방문 기록에 이동 경로 추가
                    records.add(Integer.toString(x)+Integer.toString(y)+dirs.charAt(i));
                  //반대에서 오는 경로도 추가
                    records.add(Integer.toString(x+dx[Arrays.asList(dir).indexOf(dirs.charAt(i))])+Integer.toString(y+dy[Arrays.asList(dir).indexOf(dirs.charAt(i))])+dir[((Arrays.asList(dir).indexOf(dirs.charAt(i))+2)%4)]);
                    answer++;
                }
              //좌표 이동
                x += dx[Arrays.asList(dir).indexOf(dirs.charAt(i))];
                y += dy[Arrays.asList(dir).indexOf(dirs.charAt(i))];
            }
        }
        return answer;
    }
}
