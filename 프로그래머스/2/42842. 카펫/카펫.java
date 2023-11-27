class Solution {
    public int[] solution(int brown, int yellow) {
        // 가로의 길이 : 3 이상 2500이하
        // 세로의 길이 : 3 이상 , 가로길이 이하
        // 갈색 격자 : 2가로 + 2세로 - 4
        // 노란 격자 : 가로 * 세로 - 갈색
        
        int width = 0;
        int height = 0;
        
        for(int i = 3; i <= 2500; i ++) {
            for(int j = 3; j <= i; j ++) {
                int boundary = 2 * i + 2 * j - 4;
                int center = i * j - boundary;
                if(boundary == brown 
                  && center == yellow) {
                    width = i;
                    height = j;
                }
            }
        }
        
        return new int[] {width, height}; 
    }
}