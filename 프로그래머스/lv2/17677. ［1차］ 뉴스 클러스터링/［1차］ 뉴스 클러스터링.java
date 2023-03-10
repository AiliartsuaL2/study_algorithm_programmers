import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        Map<String, Integer> map1 = new HashMap<>(); //str1
        Map<String, Integer> map2 = new HashMap<>(); //str2
        Set<String> set = new HashSet<>(); // 합집합용

        int ans = 0, total = 0;

        for(int i = 0; i < str1.length() - 1 ; i ++){
            String temp = str1.substring(i, i + 2);
            if(Character.isAlphabetic(temp.charAt(0)) //알파벳이면 추가
            && Character.isAlphabetic(temp.charAt(1))){
                map1.put(temp, map1.getOrDefault(temp, 0) + 1);
                set.add(temp);
            }
        }

        for(int i = 0; i < str2.length() - 1 ; i ++){
            String temp = str2.substring(i, i + 2);
            if(Character.isAlphabetic(temp.charAt(0)) //알파벳이면 추가
            && Character.isAlphabetic(temp.charAt(1))){
                map2.put(temp, map2.getOrDefault(temp, 0) + 1);
                set.add(temp);
            }
        }

        for(String s : set) //합집합 구하기
            total += Math.max(map1.getOrDefault(s, 0) , map2.getOrDefault(s, 0));

        for(String s : map2.keySet()) //교집합 구하기
            if(map1.containsKey(s))
                ans += Math.min(map1.get(s), map2.get(s));


        if(total == 0) return 65536;
        return ans * 65536 / total;
    }
}