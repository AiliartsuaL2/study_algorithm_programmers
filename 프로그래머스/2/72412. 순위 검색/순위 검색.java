import java.util.*;
import java.util.function.Consumer;

class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Map<String, List<Integer>> scoresMap = buildScoresMap(info);
        for(int i = 0; i < answer.length; i++) {
            answer[i] = count(query[i], scoresMap);
        }
        return answer;
    }
    
    private int count(String query, Map<String, List<Integer>> scoresMap) {
        String[] tokens = query.split(" (and )?");
        // 해당 쿼리의 조건을 맞춰줌
        String key = String.join("", Arrays.copyOf(tokens, tokens.length - 1));
        // 조건에 맞지않으면 0 반환
        if(!scoresMap.containsKey(key)) {
            return 0;
        }
        List<Integer> scores = scoresMap.get(key);
        int score = Integer.parseInt(tokens[tokens.length - 1]);
        return scores.size() - binarySearch(score, scoresMap.get(key));
    }
    
    // 이진탐색으로 인덱스를 찾고, 해당 인덱스보다 큰 값들은 x 점수 이상
    // 조건을 만족하는 값 중 가장 작은 값 [start, end],, 둘 다 inclusive
    private int binarySearch(int score, List<Integer> scores) {
        int start = 0;
        int end = scores.size() - 1;
        
        while(end > start) {
            int mid = (end + start) / 2;
            
            if(scores.get(mid) >= score) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        if (scores.get(start) < score) {
            return scores.size();
        }
        return start;
    }
    
    private Map<String, List<Integer>> buildScoresMap(String[] info) {
        Map<String, List<Integer>> scoresMap = new HashMap<>();
        // 모든 지원자 정보를 검색 조건에 따라 분류하는 전처리 작업 진행
        for(String s : info) {
            String[] tokens = s.split(" ");
            int score = Integer.parseInt(tokens[tokens.length - 1]);
            forEachKey(0, "", tokens, key -> {
                scoresMap.putIfAbsent(key, new ArrayList<>());
                scoresMap.get(key).add(score);
            });
        }
        // 전처리한 리스트를 정렬
        for(List<Integer> list : scoresMap.values()) {
            Collections.sort(list);
        }
        return scoresMap;
    }
    
    // 재귀를 이용하여 모든 조건을 완전 탐색으로 찾음.
    private void forEachKey(int index, String prefix, String[] tokens, Consumer<String> action) {
        if (index == tokens.length - 1) {
            // prefix가 만들어진 검색 조건
            action.accept(prefix);
            return;
        }
        
        forEachKey(index + 1, prefix + tokens[index], tokens, action);
        forEachKey(index + 1, prefix + "-", tokens, action);
    
    }
}