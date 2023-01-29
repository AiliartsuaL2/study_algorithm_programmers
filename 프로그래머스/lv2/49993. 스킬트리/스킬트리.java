import java.util.HashMap;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        HashMap<String,Integer> skillMap = new HashMap<>();
        for(int i=0; i<skill.length(); i++){
            String tmp = String.valueOf(skill.charAt(i));
            skillMap.put(tmp,i);
        }

        for(int i=0; i<skill_trees.length; i++){
            String userSkill = skill_trees[i];
            int count = 0;
            Boolean yesSkill = true;
            for(int j=0; j<userSkill.length(); j++){
                String skillValue = String.valueOf(userSkill.charAt(j));
                int skillIndex = skillMap.getOrDefault(skillValue,-1);
                if(skillIndex == -1) {// 스킬맵에 값이 없는경우
                    continue;
                }
                else if(skillIndex <= count){
                    count++;
                }
                else if(skillIndex > count){// 배우지 못하는 경우
                    yesSkill = false;
                    break;
                }
            }
            if(yesSkill == true){
                answer++;
            }
        }
        return answer;
    }
}