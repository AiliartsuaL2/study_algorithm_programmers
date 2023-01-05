class Solution {
    public String solution(String number, int k) {
        
        StringBuilder answer = new StringBuilder();
        // 가장 큰 값의 인덱스 정보.
        int idx=0;
        // 만들어야 하는 자리 수, 고정된 값.
        int scope = number.length() - k; 
        
        // 1. 각 자리 수를 반복하는 반복문
        for(int i =1;i<=scope;i++){
            // 2. 최댓값 변수.
            int max = Integer.MIN_VALUE;
            // 3. 각 자리 수를 정하기 위해 정해진 범위를 탐색하는 반복문, 현재 문자열의 길이 - (만들어야 하는 자리 수 - 현재 만들고 있는 자리 수)
            for(int j = 0; j<number.length() - (scope -i);j++){
                // 4. 9는 바로 최댓값 갱신.
                if((number.charAt(j) - '0') == 9) {
                    max = 9;
                    idx = j;
                    break;
                }
                
                // 5. 최댓값을 찾는다.
                if(max < (number.charAt(j) - '0')){
                    max = number.charAt(j) - '0';
                    idx = j;
                }                    
            }
            // 6. 찾은 최댓값을 StringBuilder에 이어 붙인다.
            answer.append(max);
            // 7. 최댓값의 인덱스 ~ 현재 문자열의 마지막까지의 범위를 새로운 문자열로 갱신한다.
            number = number.substring(idx+1,number.length());                       
        }
        
        return answer.toString();
    }
}