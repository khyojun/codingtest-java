import java.util.*;
import java.lang.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        Map<String, Integer> map = new HashMap<>();
        
        int index = 0;
        for(String player : players){
            map.put(player, index++);
        }
        
        for(String calling : callings){
            int targetIndex=map.get(calling);
            int changeIndex = targetIndex-1;
            
            String targetPlayer = players[targetIndex];
            players[targetIndex] = players[changeIndex];
            players[changeIndex] = targetPlayer;
            
            map.put(targetPlayer, changeIndex);
            map.put(players[targetIndex], targetIndex);
        }        
        
        return players;
    }
}