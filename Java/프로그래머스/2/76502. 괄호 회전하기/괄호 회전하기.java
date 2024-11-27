import java.util.Stack;
import java.lang.StringBuilder;
class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i=0; i<s.length(); i++){
            StringBuilder sb = new StringBuilder();
            for(int j=i; j<s.length(); j++){
                sb.append(s.charAt(j));
            }
            for(int j=0; j<i; j++){
                sb.append(s.charAt(j));
            }
            if(checkIsRight(sb.toString()))
                answer++;
            
        }
        
        return answer;
    }
    
    boolean checkIsRight(String s){
        Stack<Character> stackFirst = new Stack<>();
        Stack<Character> stackSecond = new Stack<>();
        Stack<Character> stackThird = new Stack<>();
        
        Stack<Character> stackFourth = new Stack<>();

        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==')'){
                if(stackFourth.isEmpty()){
                    return false;
                }
                if(stackFourth.pop() != '('){
                    return false;
                }
            }
            else if(s.charAt(i)=='}'){
                if(stackFourth.isEmpty()){
                    return false;
                }
                if(stackFourth.pop() != '{'){
                    return false;
                }
            }
            
            else if(s.charAt(i)==']'){
                if(stackFourth.isEmpty()){
                    return false;
                }
                if(stackFourth.pop() != '['){
                    return false;
                }
            }
            else{
                stackFourth.push(s.charAt(i));
            }
            
        }
        
       
        
//         for(int i=0; i<s.length(); i++){
//             if(s.charAt(i) == ')'){
//                 if(stackFirst.isEmpty()){
//                     return false;
//                 }
//                 stackFirst.pop();
//             }
//             else if(s.charAt(i) == '(')
//                 stackFirst.push(s.charAt(i));
//             if(s.charAt(i) == '}'){
//                 if(stackSecond.isEmpty() ){
//                     return false;
//                 }
//                 stackSecond.pop();
//             }
//             else if(s.charAt(i) == '{')
//                 stackSecond.push(s.charAt(i));
//             if(s.charAt(i) == ']'){
//                 if(stackThird.isEmpty()){
//                     return false;
//                 }
//                 stackThird.pop();
//             }
//             else if(s.charAt(i) == '[')
//                 stackThird.push(s.charAt(i));
//         }
        
        return stackFourth.isEmpty();
        
    }
}