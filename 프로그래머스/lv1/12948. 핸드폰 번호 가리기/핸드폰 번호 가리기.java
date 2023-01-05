class Solution {
    public String solution(String phone_number) {
        String answer = "";
        String phone1 = "";
        String phone2 = phone_number.substring((phone_number.length()-4),phone_number.length());
        for(int i=0; i<phone_number.length()-4;i++){
            phone1 += "*";
        }
        answer = phone1 + phone2;  
        return answer;
    }
}