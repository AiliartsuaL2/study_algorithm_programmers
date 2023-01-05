import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        //1. info를 기반으로 Hashmap으로 만든다
        HashMap<String, ArrayList<Integer>> hashMap = new HashMap<>();
        for(String i : info){
            String[] data = i.split(" ");
            String[] languages = {data[0], "-"};
            String[] jobs = {data[1], "-"};
            String[] exps = {data[2], "-"};
            String[] foods = {data[3], "-"};
            Integer value = Integer.parseInt(data[4]);
            for(String lang : languages) // 모든 경우의 수 빼옴
                for(String job : jobs)
                    for(String exp : exps)
                        for(String food: foods){
                            String[] keyData = {lang,job,exp,food};
                            String key = String.join(" ", keyData);
                            ArrayList<Integer> arr = hashMap.getOrDefault
                                                     (key, new ArrayList<Integer>());
                            arr.add(value);
                            hashMap.put(key, arr);
                        }
        }
        //2. hashmap의 value를 오름차순으로 정렬
        for(ArrayList<Integer> arr : hashMap.values()){
            arr.sort(null);
        }     
        //3. query 조건의 맞는 지원자를 가져온다.
        int[] answer = new int[query.length];
        int i=0;
        for(String q: query){
            String[] data = q.split(" and ");
            int target = Integer.parseInt(data[3].split(" ")[1]); //점수
            data[3] = data[3].split(" ")[0]; // 실제 음식
            String key = String.join(" ",data);
            
            if(hashMap.containsKey(key)){
                ArrayList<Integer> list = hashMap.get(key);
                //4. binary search를 통해 lower-bound를 찾는다ㅣ.
                int left = 0;
                int right = list.size();
                while(left < right){ // 2진 탐색
                   int mid = (left + right) / 2;
                    if(list.get(mid) >= target){
                        right = mid; // 타겟값보다 크면 왼쪽을 탐색하고
                    }
                    else{
                        left = mid+1; // 타겟값보다 작으면 오른쪽을 탐색해야함 
                    }
                } // while문이 끝나면 left값 = right값이 되고, 해당 target 점수가 시작하는 위치,,
                // 전체크기에서 시작 위치를 빼면 원하는 점수 이상의 해당하는 인원이 들어감 
                answer[i] = list.size() - left;
            }
            i++;
        }
        return answer;
    }
}