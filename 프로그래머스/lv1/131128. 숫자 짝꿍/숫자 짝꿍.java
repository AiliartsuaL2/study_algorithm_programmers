import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        
        int[] cntX = new int[10];
        int[] cntY = new int[10];
        
        for (String tmpX : X.split("")) cntX[Integer.parseInt(tmpX)]++; // 0~9 해당하는값에 카운트를 추가함.
        for (String tmpY : Y.split("")) cntY[Integer.parseInt(tmpY)]++;
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 9; i >= 0; i--){ // 내림차순으로 넣어서 큰 정수 찾기.
            while(cntX[i] > 0 && cntY[i] > 0){ // 카운트가 동일한 값만 제거가 됨
                sb.append(i);
                cntX[i]--;
                cntY[i]--;
            }
        }
        String answer = "";
        
        if ("".equals(sb.toString())) {
            answer = "-1";
        } else if ("0".equals(sb.toString().substring(0,1))) { //큰값부터 추가했으니까 1번에 0이 들어가면 안됨.
            answer = "0";
        } else {
            answer = sb.toString();
        }

        return answer;
    }
}