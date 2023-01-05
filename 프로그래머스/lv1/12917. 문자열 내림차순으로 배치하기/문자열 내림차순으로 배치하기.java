
import java.util.Arrays;
import java.util.Collections;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = new String[s.length()];
        for(int i =0; i<s.length();i++){
            arr[i] = String.valueOf(s.charAt(i));
        }
        Arrays.sort(arr,Collections.reverseOrder());
        for(int i =0; i<s.length();i++){
            answer += arr[i];
        }
        return answer;
    }
}
/*
import java.util.Arrays;

public class Solution {
    public String solution(String str) {
    char[] sol = str.toCharArray();
    Arrays.sort(sol);
    return new StringBuilder(new String(sol)).reverse().toString();
    }
}
*/