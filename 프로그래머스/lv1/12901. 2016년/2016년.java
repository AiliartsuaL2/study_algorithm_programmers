class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int[] day = {31,29,31,30,31,30,31,31,30,31,30,31};
        int total = 0;
        for(int i=1; i<a; i++){
            total += day[i-1];
        }
        total += b - 1;
        total %= 7;
        switch(total){
            case 0 : answer = "FRI";
                break;
            case 1 : answer = "SAT";
                break;
            case 2 : answer = "SUN";
                break;
            case 3 : answer = "MON";
                break;
            case 4 : answer = "TUE";
                break;
            case 5 : answer = "WED";
                break;
            case 6 : answer = "THU";
                break;
        }
        return answer;
    }
}