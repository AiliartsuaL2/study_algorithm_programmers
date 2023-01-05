import java.util.LinkedList;
class Solution {
    public int[] solution(int n, String[] words) {
        LinkedList<String> wordList = new LinkedList<>();
        int cnt = 1;
        boolean none = true;
        wordList.add(words[0]);
        for(int i=1; i<words.length; i++){
            cnt++;
            String word = words[i];
            if(wordList.contains(word)){ // 중복단어 말할경우
                System.out.println(cnt);
                none = false;
                break;
            }
            String preWord = wordList.get(i-1);
            if(word.charAt(0) != preWord.charAt(preWord.length()-1)){ // 끝말잇기가 아닌경우
                none = false;
                break;
            }
            wordList.add(word);
        }
        int[] answer = new int[2];
        if(none){
            answer[0] = 0;
            answer[1] = 0;
        }
        else{
            answer[0] = cnt%n;
            if(answer[0]==0){
                answer[0] = n;
            }
            answer[1] = (int) Math.ceil((double)cnt/n);
        }
        
        return answer;
    }
}