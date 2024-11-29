import java.util.*;


class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
    
        
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<prices.length; i++){
            if(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                    answer[stack.peek()]=i-stack.peek();
                    stack.pop();
                }

            }
            stack.push(i);
        }
        
        
        for(int i=0; i<prices.length; i++){
            if(answer[i]!=0)
                continue;
            answer[i] = prices.length - (i+1); 
        }
        
        return answer;
    }
}