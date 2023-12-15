import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        // [start, end)
        int start = 1;
        int end = distance + 1;
        
        // 맨 마지막 바위도 추가해줘야함
        rocks = Arrays.copyOf(rocks, rocks.length + 1);
        rocks[rocks.length - 1] = distance;
        
        Arrays.sort(rocks);
        
        while (end - start > 1) {
            int d = (start + end) / 2;
            
            // d 조건 검사 후 범위 좁히며 이진탐색 
            if (isValid(d, rocks, n)) {
                start = d;
                continue;
            }
            end = d;
        }
        return start;
    }
    
    // 검사할 거리가 
    private boolean isValid(int d, int[] rocks, int n) {
        // 제거한 바위 개수
        int removed = 0;
        
        // 마지막 바위 위치
        int last = 0;
        for(int rock : rocks) {
            if (rock - last < d) {
                removed ++;
                continue;
            }
            last = rock;
        }
        return removed <= n;
    }
}