class Solution {
    static int an=0;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        //모든 경우를 다 보면 되긴한다! 대신에 순서를 dfs로 할 수 있도록 진행
        dfs(numbers, target,0, 0);
        
        return an;
    }
    
    
    private void dfs(int[] numbers, int target, int nowResult, int idx){        
        if(idx>numbers.length){
            return;
        }
        if(nowResult == target && idx == numbers.length){
            an++;
            return;
        }
        else if(idx==numbers.length){
            return;
        }
        dfs(numbers, target, nowResult+numbers[idx], idx+1);
        dfs(numbers, target, nowResult-numbers[idx], idx+1);
        
    }
}