import java.util.LinkedList;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> cacheList = new LinkedList<>();
        if(cacheSize == 0){
            return cities.length * 5;
        }
        for(String city : cities){
            city = city.toUpperCase();
            if(cacheList.contains(city)){ // cache hit
                cacheList.remove(city);// 동일한 경우 맨 앞의 값 삭제 ,,   (가장 오래된)
                cacheList.add(city); // 해당 값 추가
                answer ++;  
            } 
            else{ // cache miss
                if(cacheList.size() == cacheSize){ //미스인데 캐시 사이즈가 꽉ㅇ차있는경우 
                    cacheList.removeFirst(); //캐시의 첫값 삭제(가장 오래된)
                    cacheList.add(city); // 캐시에 새로운 데이터 추가
                    answer += 5;
                }
                else{
                    cacheList.add(city);
                    answer += 5; 
                }
            }
        }
        return answer;
    }
}