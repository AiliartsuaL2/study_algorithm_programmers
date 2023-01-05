import java.util.*;
class Solution {
    HashMap<String,Integer> hashMap = new HashMap<>();
    List<String> answerList = new ArrayList<>();
    //각 order 정렬
    // 각 order를 기준으로 courseLength만큼의 조합을 만든다.
    // 해시맵에 저장해서 가장 많은 조합을 answer에 저장한다.
    public String[] solution(String[] orders, int[] course) {
        for(int i=0 ;i<orders.length; i++){
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr); //내부 메뉴 순서 정렬해서
            orders[i] = String.valueOf(arr); // 다시 넣음
        }
        
        for (int courseLength : course) {
            for (String order : orders)
                combination("", order, courseLength);

            // 3. 가장 많은 조합 answer에 저장
            if (!hashMap.isEmpty()) {
                List<Integer> countList = new ArrayList<>(hashMap.values());
                int max = Collections.max(countList);

                if (max > 1)
                    for (String key : hashMap.keySet())
                        if (hashMap.get(key) == max)
                            answerList.add(key);
                hashMap.clear();
            }
        }
        Collections.sort(answerList);
        String[] answer = new String[answerList.size()];
        for(int i=0; i<answer.length; i++){
                answer[i] = answerList.get(i);
            }
        return answer;
    }
    public void combination(String order, String others, int count){
        // 재귀함수 ,, 1. 탈출조건
        // 2. 수행동작 : 0부터 length까지의 조합
        if(count == 0){
            hashMap.put(order,hashMap.getOrDefault(order,0)+1);
        }
        for(int i=0; i<others.length(); i++){
            combination(order+others.charAt(i),others.substring(i+1),count-1);
        }
        
    }
}