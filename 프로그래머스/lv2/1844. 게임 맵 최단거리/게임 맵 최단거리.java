import java.util.*;
class Solution {
int n ;
int m ;
int[][] visit;
  public boolean check(int y, int x, int[][] maps){
      if(y<0||x<0||y>=n||x>=m){
          return false;
      }
      if(maps[y][x] == 0){
         return false;
      }
      if(visit[y][x] == 1){
          return false;
      }
      return true;
  }
    public int solution(int[][] maps) {
        int answer = 0;
        Queue<Integer> xQ = new LinkedList<>();
        Queue<Integer> yQ = new LinkedList<>();
        Queue<Integer> countQ = new LinkedList<>();
        
        n = maps.length;
        m = maps[0].length;
        
        visit = new int[n][m];
    
        xQ.offer(0);
        yQ.offer(0);
        countQ.offer(1);
        
        while(yQ.isEmpty() == false){
            int xC = xQ.poll();
            int yC = yQ.poll();
            int cC = countQ.poll();
            
            if(visit[yC][xC] == 1){
                continue;
            }
            
            visit[yC][xC] = 1;
            
            if(yC == n-1 && xC == m-1){ // 목표 좌표 도착시
                answer = cC;
                break;
            }
            
            //상
            if(check(yC-1, xC, maps)){
                yQ.offer(yC-1);
                xQ.offer(xC);
                countQ.offer(cC+1);
            }
            //하
            
            if(check(yC+1, xC, maps)){
                yQ.offer(yC+1);
                xQ.offer(xC);
                countQ.offer(cC+1); // 거리기록
            }
            //좌
            
            if(check(yC, xC-1,maps)){
                yQ.offer(yC);
                xQ.offer(xC-1);
                countQ.offer(cC+1);
            }
            //우
            if(check(yC, xC+1,maps)){
                yQ.offer(yC);
                xQ.offer(xC+1);
                countQ.offer(cC+1);
            }
        }
        if(answer == 0){
            answer = -1;
        }
        return answer;
    }
  
}