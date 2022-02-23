//정확성 통과, 효율성 테스트 모두 시간 초과
/*
board에서 1을 발견했을 때 우측 대각선 방향으로 늘려가며 정사각형이 되는지 확인하는 방식으로 접근
시간 단축을 위해 1 발견 후 보드 길이에서 발견 위치의 좌표를 빼, 지금까지 구한 정사각형 한 변의 길이 최댓값보다 큰 경우에만 연산 진행
*/
class Solution{
    public int solution(int [][]board){
        int answer = 0;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]==1&&(board.length-i>answer||board[0].length-j>answer)){
                    int k = 1;
                    while(check(board, i, j, k)){
                        k++;
                    }
                    answer = Math.max(answer, k);
                }
            }
        }
        return answer*answer;
    }
    
    public boolean check(int[][] board, int x, int y, int len){
        //가로
        for(int i=0; i<len; i++){
            if(x+len>=board.length||board[x+len][y+i]!=1) return false;
        }
        //세로
        for(int i=0; i<len; i++){
            if(y+len>=board[0].length||board[x+i][y+len]!=1) return false;
        }
        //대각선
        if(board[x+len][y+len]!=1) return false;
        
        return true;
    }
}
