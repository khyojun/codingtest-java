import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        int[] stack = new int[ingredient.length];
        int index = 0;
        
        for (int ing : ingredient) {
            // 현재 재료를 스택에 추가
            stack[index++] = ing;
            
            // 스택에 4개 이상의 재료가 있는 경우 확인
            if (index >= 4) {
                // 마지막 4개가 햄버거 패턴인지 확인
                if (stack[index - 4] == 1 && 
                    stack[index - 3] == 2 && 
                    stack[index - 2] == 3 && 
                    stack[index - 1] == 1) {
                    
                    // 햄버거가 완성되면 포인터를 4 감소시킴 (4개 요소 제거 효과)
                    index -= 4;
                    answer++;
                }
            }
        }
        
        return answer;
    }
}