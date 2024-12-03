import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String[] participant, String[] completion) {        
        HashMap<String,Integer> map = new HashMap<>();
        
        for(int i=0; i<participant.length; i++){
            if(map.get(participant[i]) == null){
                map.put(participant[i], 1);
                continue;
            }
            map.put(participant[i], map.get(participant[i])+1);
        }
        
        for(int i=0; i<completion.length; i++){
            map.put(completion[i], map.get(completion[i])-1);
        }
    
        return map.entrySet().stream()
            .filter(m -> m.getValue() >0)
            .map(m -> m.getKey())
            .findFirst().get();
    }
}