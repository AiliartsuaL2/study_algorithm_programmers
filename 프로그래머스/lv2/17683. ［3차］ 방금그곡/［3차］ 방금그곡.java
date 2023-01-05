import java.util.*;
class Solution {
    public String changeMelody(String oldMelody){
        oldMelody = oldMelody.replaceAll("C#","H");
        oldMelody = oldMelody.replaceAll("D#","I");
        oldMelody = oldMelody.replaceAll("F#","J");
        oldMelody = oldMelody.replaceAll("G#","K");
        String newMelody = oldMelody.replaceAll("A#","L");
        return newMelody;
    }
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        m = changeMelody(m);
        int maxTime = -1;
        LinkedList<String> melodyList = new LinkedList<>();
        for(String musicInfo : musicinfos){
            String[] info = musicInfo.split(",");
            String[] startMusic = info[0].split(":");
            String[] endMusic = info[1].split(":");
            int start = (Integer.parseInt(startMusic[0])*60)+Integer.parseInt(startMusic[1]);
            int end = (Integer.parseInt(endMusic[0])*60)+Integer.parseInt(endMusic[1]);
            int play = end-start;
            String title = info[2];
            String melody = changeMelody(info[3]);
            if(play>melody.length()){
                StringBuilder newMelody = new StringBuilder();
                for(int i=0; i<play/melody.length();i++){ //몫 만큼 반복해서
                    newMelody.append(melody); // 멜로디를 붙여주고
                }
                newMelody.append(melody.substring(0,play%melody.length()));
                melody = newMelody.toString();
                //나머지만큼 추가로 붙여줌.
            }
            else{ // 멜로디보다 작거나 같으면 
                melody = melody.substring(0, play); // 재생시간만큼 재생시킴
            }
            
            // 조건이 일치하는 음악이 여러개면
            // 재생된 시간이 제일 긴 음악 제목을 반환해야 하기 때문에
            // 조건에 멜로디 포함뿐만 아니라, 재생된 시간가지 비교
            if(melody.contains(m) && play>maxTime){
                answer = title;
                maxTime = play;
            }
            
        }
        return maxTime != -1 ? answer : "(None)";
    }
}