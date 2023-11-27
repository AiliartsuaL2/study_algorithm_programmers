import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final char[] CHARS = "AEIOU".toCharArray();
    
    public int solution(String word) {
        // 모든 단어의 경우의 수를 구하고 그 중에 몇번째인지 확인
        // 재귀를 이용하여 모든 단어의 경우의 수를 구함
        // 모든 단어의 경우의 수 중 index를 가져오면 된다.
        return generate("").indexOf(word);
    }
    
    private List<String> generate(String word) {
        List<String> words = new ArrayList<>();
        words.add(word);
        
        if(word.length() == 5) {
            return words;
        }
        for(char c : CHARS) {
            words.addAll(generate(word + c));
        }
        return words;
    }
}