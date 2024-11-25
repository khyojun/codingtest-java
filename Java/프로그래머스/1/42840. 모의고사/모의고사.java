import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

class Solution {
    public int[] solution(int[] answers) {
        
        
        // 1 : 12345
        // 2: 21232425
        // 3: 3311224455
        // n : 10000
        
        List<Integer> first = List.of(1,2,3,4,5);
        List<Integer> second = List.of(2,1,2,3,2,4,2,5);
        List<Integer> third = List.of(3,3,1,1,2,2,4,4,5,5);
        
        int cnt1=0;
        int cnt2=0;
        int cnt3=0;
        
        for(int i=0; i<answers.length; i++){
            
            if(first.get(i%5)==answers[i]){
                cnt1++;
            }
            if(second.get(i%8)==answers[i]){
                cnt2++;
            }           
            if(third.get(i%10)==answers[i]){
                cnt3++;
            }    
        }    
            
        int middleMax=Math.max(cnt1, cnt2);        
        int realMax=Math.max(middleMax, cnt3);
        List<Integer> answer = new ArrayList<>();
        if(realMax == cnt1){
            answer.add(1);
        }
    
        if(realMax == cnt2){
            answer.add(2);
        }
        
        if(realMax == cnt3){
            answer.add(3);
        }
        
        return answer.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
}