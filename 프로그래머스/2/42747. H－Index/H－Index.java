import java.util.Arrays;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        for(int h = citations.length; h >= 1; h--) {
            // 큰 값부터 확인,
            if(isValid(citations, h)) {
                return h;
            }
        }    
        return 0;
    }
    
    private boolean isValid(int[] citations, int h) {
        int index = citations.length - h;
        // 오름차순으로 구현했기 때문에, 뒤에서 h번째 있는 값이 h보다 큰지만 확인, 
        return citations[index] >= h;
    }
    
}
