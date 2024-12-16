import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        // n/2 만 고를 수 있다.
        // 최대한 많은 종류의 포켓몬을 골라야한다!
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(answer == nums.length/2)
                break;
            if(map.get(nums[i])==null){
                answer++;
                map.put(nums[i], 1);
            }
            else
                map.put(nums[i], map.get(nums[i])+1);
        }
        
        
        
        return answer;
    }
}