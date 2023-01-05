class Solution {
    static int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        int totalSize = arr.length;
        dp(0,0,totalSize,arr);
        
        return answer;
    }
    
    private static boolean check(int x, int y, int size, int[][] arr){
        for(int i= x; i< x+size; i++){
            for(int j=y; j<y+size; j++){
                if(arr[x][y] != arr[i][j]){ // 값이 하나라도 같지 않는다면
                    return false; // false 리턴
                }
            }
        }
        return true; // 값이 모두 다 같으면 true 리턴
    }
    private static void dp(int startX, int startY, int size, int[][] arr){
        if(check(startX,startY,size,arr)){ //모두 같은 값이면
            answer[arr[startX][startY]]++; // answer배열에 추가
            return;  
        }
        dp(startX,startY,size/2,arr);
        dp(startX+(size/2),startY,size/2,arr);
        dp(startX,startY+(size/2),size/2,arr);
        dp(startX+(size/2),startY+(size/2),size/2,arr);
    }
}