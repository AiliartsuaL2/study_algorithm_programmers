class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int zeroCount = removeZero(s);
        int sLength = s.length() - zeroCount;
        int count = 1;
        
        while(sLength > 1){
            String transedStr = Integer.toString(sLength,2);
            int tmp = removeZero(transedStr);
            zeroCount += tmp;
            sLength = transedStr.length()-tmp;
            count ++;
        }
        answer[0] = count;
        answer[1] = zeroCount;
        return answer;
    }
    private int removeZero(String word){
        int count = 0;
        for(int i=0; i<word.length();i++){
            if(word.charAt(i) == '0')
                count++;
        }
        return count;
    }
}