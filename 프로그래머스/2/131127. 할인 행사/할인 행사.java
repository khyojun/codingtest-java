import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<want.length; i++){
            map.put(want[i], number[i]);
        }
        
        for(int i=0; i<discount.length-9; i++){
            boolean isRegister=false;
            for(int j=0; j<want.length; j++){
                map.put(want[j], number[j]);
            }
            
            for(int j=i; j<i+10; j++){
                if(map.get(discount[j])==null || map.get(discount[j])==0)
                    break;
                map.put(discount[j], map.get(discount[j])-1);
                if(j==i+9)
                    isRegister=true;
            }
            if(isRegister)
                answer++;
        }
        
        
        
        
        return answer;
    }
}