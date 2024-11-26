import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Comparator;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        int [] stageUserCount = new int[N+2];
        for(int i=0; i<stages.length; i++){
            stageUserCount[stages[i]]++; // 해당 스테이지 사용자 수 측정
        }
        
        HashMap<Integer, Double> failRate = new HashMap<>();
        int total=stages.length;
        for(int i=1; i<=N; i++){
            if(stageUserCount[i]==0){
                failRate.put(i,0.0);
                continue;
            }
            failRate.put(i, (double)stageUserCount[i] / (double) total);
            total-=stageUserCount[i];
        }
        
        
         return failRate.entrySet().stream()
            .sorted(Comparator.comparing(Entry::getValue, Comparator.reverseOrder()))
            .mapToInt(Entry::getKey)
            .toArray();
                
    }
}