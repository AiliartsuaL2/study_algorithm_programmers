class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int a = 0;
        int b = 0;
        a = countChar(s,'p');
        b = countChar(s,'y');
        
        if(a == b){
            answer = true;
        }
        else{
            answer = false;
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
    int countChar(String s,char b){
        int num = 0;
        String sLow = "";
        sLow =  s.toLowerCase();
        for(int i = 0; i<sLow.length(); i++){
            if(sLow.charAt(i) == b){
              num++;  
            } 
        }    
        return num;
    }
}