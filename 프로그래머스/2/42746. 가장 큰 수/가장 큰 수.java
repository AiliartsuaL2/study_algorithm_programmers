import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] numbers) {
        return Arrays.stream(numbers)
            // String으로 변경 
            .mapToObj(String::valueOf)
            // 정렬
            .sorted((s1,s2) -> {
                // 순서를 바꿨을때 더 큰수로 정렬
                int original = Integer.parseInt(s1 + s2);
                int reversed = Integer.parseInt(s2 + s1);
                return reversed - original;
            }).collect(Collectors.joining(""))
            // 맨 앞글자가 0이 연속되면 0 하나로 대체한다
            .replaceAll("^0+", "0");
    }
}