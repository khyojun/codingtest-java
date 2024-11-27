import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ')'){
                if(i==0){
                    return false;
                }
                if(stack.size()==0){
                    return false;
                }
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));            
        }
            
        if(stack.size()==0){
            return true;
        }
        return false;
    }
}