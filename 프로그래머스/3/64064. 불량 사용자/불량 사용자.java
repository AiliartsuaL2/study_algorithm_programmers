import java.util.*;

class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        // 정규식 활용..
        // *처리된 문자열을 .으로 변경 (정규식에서 해당 값을 통과시키는 로직)
        String[][] bans = Arrays.stream(banned_id)
            .map(banned -> banned.replace("*","."))
            .map(banned -> Arrays.stream(user_id)
                 .filter(id -> id.matches(banned))
                 .toArray(String[]::new))
            .toArray(String[][]::new);
        
        Set<Set<String>> banSet = new HashSet<>();
        count(0, new HashSet<>(), bans, banSet);
        
        return banSet.size();
    }
    
    // 밴 예상자 순번, 밴 확정자, 용의자 목록, 찾은 조합
    private void count (int index, Set<String> banned, String[][] suspect, Set<Set<String>> banSet) {
        // 베이스조건
        if(index == suspect.length) {
            // 밴 확정자들을 조합에 넣어줌.
            banSet.add(new HashSet<>(banned));
            return;
        }
        
        for(String id : suspect[index]) {
            // 이미 밴된 사용자면
            if(banned.contains(id)) {
                continue;
            }
            // 백트래킹
            banned.add(id);
            count(index+1, banned, suspect, banSet);
            // 다음 루프를 위해 제거
            banned.remove(id);
        }
        
    }
}