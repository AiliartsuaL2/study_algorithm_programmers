class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        int[][] map = new int[board.length + 1][board[0].length + 1];
        int maxLen = 0;
        
        for(int i=0; i<board.length; i++)
            for(int j=0; j<board[i].length; j++)
                map[i+1][j+1] = board[i][j];
        
        for(int i=1; i<map.length; i++){
            for(int j=1; j<map[i].length; j++){
                if(map[i][j] == 1) {
                    int left = map[i-1][j];    // 좌측 값
                    int up = map[i][j-1];      // 상단 값
                    int leftUp = map[i-1][j-1];// 좌측상단(대각선) 값
                    int min = Math.min(left, Math.min(up, leftUp)); // 최솟값을찾고
                    map[i][j] = min+1; // 최솟값에 1을 더함
                    maxLen = Math.max(maxLen, min+1);
                }
            }
        }
        answer = maxLen * maxLen;

        return answer;
    }
}