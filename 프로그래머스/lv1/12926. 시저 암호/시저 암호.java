class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++){
            char sc = s.charAt(i);
            
            if(sc == ' '){
                sb.append(" ");
                continue;                
            }
            char transedSc = (char) (sc + n);
            
            // 46이 z 인경우, 20으로 돌려야하니까, (z-a)만큼 빼줌
            if(sc <= 'z' && transedSc > 'z'){
                transedSc -= ('z'-'a'+1);
            }else if(sc <= 'Z' && transedSc > 'Z'){
                transedSc -= ('Z'-'A'+1);
            }
            sb.append(transedSc);
        }
        return sb.toString();
    }
}