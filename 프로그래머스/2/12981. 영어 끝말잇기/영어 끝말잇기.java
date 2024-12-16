import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다. 
        // n 명의 사람끼리 끝말잇기 진행
        // 이전 단어, 현재 단어, 말하는 사람 순서대로 가면됨!, 그리고 이전 사람 번호만 기어 
        // 똑같은 말 하면 안된다.
        // 각자의 그 사람이 몇번재 불렀을 때 그 번째의 그 답을 해야한다.
        //System.out.println(words[0].length());
        
        Set<String> recordWords = new HashSet<>();
        
        String prevLastWord = null;
        for(int i=0; i<words.length; i++){
            
        
            int nowRound;
            int nowTurn = (i+1) % n;

            if(nowTurn == 0){
                nowTurn=n;
            }
            if((i+1)%n >0){
                nowRound = (i+1)/n + 1;
            }
            else{
                nowRound = (i+1)/n;
            }     
             
            
            if(prevLastWord == null){
                prevLastWord = String.valueOf(words[i].charAt(words[i].length()-1));
                recordWords.add(words[i]);
                // char -> String Character. toString 활용 혹은 String.valueOf()
                continue;
            }
            
            if(recordWords.contains(words[i]) || !words[i].startsWith(prevLastWord)){
                answer[0]=nowTurn;
                answer[1]=nowRound;

                break;
            }
            
            prevLastWord = String.valueOf(words[i].charAt(words[i].length()-1));
            recordWords.add(words[i]);

            
        }

        return answer;
    }
}