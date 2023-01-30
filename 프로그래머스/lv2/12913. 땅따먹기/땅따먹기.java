class Solution {
    int solution(int[][] land) {
        int answer = 0;
        for(int i=1; i<land.length; i++){
            land[i][0] += Math.max(land[i-1][1],Math.max(land[i-1][2],land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0],Math.max(land[i-1][2],land[i-1][3]));
            land[i][2] += Math.max(land[i-1][0],Math.max(land[i-1][1],land[i-1][3]));
            land[i][3] += Math.max(land[i-1][0],Math.max(land[i-1][1],land[i-1][2]));
        }
            int one = land[land.length-1][0];
            int two = land[land.length-1][1];
            int three = land[land.length-1][2];
            int four = land[land.length-1][3];
            answer = Math.max(one,Math.max(two,Math.max(three,four)));

        return answer;
    }
}