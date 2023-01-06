import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for(int i=1; i<phone_book.length; i++){
            if(phone_book[i].startsWith(phone_book[i-1])){
                answer = false;
                break;
            }
        }
//         HashSet<String> bookSet = new HashSet<>();
//         for(phone : phone_book){
//             bookSet.add(phone);
//         }
//         for(String phone : bookSet){
            
//         }
        return answer;
    }
}