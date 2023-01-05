// 0,1,2,3,4가 뭔지 확인하고, 공백이면 카운트를 안하고, 문자면 카운트를 한다음에
// 카운트된 문자 홀수에만 대문자를 적용./
class Solution {
    public String solution(String s) {
        String answer = "";
        String arr[] = new String[s.length()];
        int x = 1; 
        for(int i =0; i<s.length(); i++){
            if(String.valueOf(s.charAt(i)).equals(" ")){
                arr[i] = String.valueOf(s.charAt(i));
                x=1;
            }
            else{
                if(x % 2 == 1){
                    arr[i] = String.valueOf(s.charAt(i)).toUpperCase();
                }
                else{
                    arr[i] = String.valueOf(s.charAt(i)).toLowerCase();
                }
                x++;
            }
        }
        for(int i=0; i<arr.length; i++){
            answer += arr[i];
        }
        return answer;
    }
}