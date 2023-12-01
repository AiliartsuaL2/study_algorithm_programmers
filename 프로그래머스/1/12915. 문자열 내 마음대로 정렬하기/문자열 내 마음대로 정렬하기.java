import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (s1, s2) -> {
            if(s1.charAt(n) != s2.charAt(n)) {
                // 다르면 n번째 문자열 비교
                return s1.charAt(n) - s2.charAt(n);
            }
            // 같으면 직접비교
            return s1.compareTo(s2);
        });
        return strings;
    }
}