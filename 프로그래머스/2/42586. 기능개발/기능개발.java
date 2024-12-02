import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        //int[] answer = {};
        // 큐에 넣고 100퍼센트가 됬는지 계속 확인하는게 필요! 니가 넣든 말든
        // queue.peek() 값이 100이 넘었을때 뒤에 다 확인하면서 진행!
        
        //100 100 이라 괜찮은거 같음!
        
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        
        for(int i=0; i<progresses.length; i++){
            queue.offer(progresses[i]);        
        }
        int startIdx=0;
        while(!queue.isEmpty()){
            for(int i=startIdx; i<progresses.length; i++){
                int tmp = queue.peek();
                queue.offer(queue.poll()+speeds[i]);
            }
            int cnt=0;
            while(!queue.isEmpty() && queue.peek()>=100){
                queue.poll();
                cnt++;
            }
            if(cnt!=0){
                answer.add(cnt);
                startIdx+=cnt;
            }
        }
        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}