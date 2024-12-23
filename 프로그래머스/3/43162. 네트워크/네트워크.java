import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        // 입력이해 -> computers[1][2] = 1 -> i 랑 j 랑 연결
        // 1 1 i i 같은 형태는 무조건 1임! 자기 자신이니까
        
        // 문제 풀이
        // 네트워크 갯수? -> 유니온 파인드 했을때 최종 다른 값 갯수임! 부모가 다르면 아예 트리가 연결이 되어있지 않는다는 뜻!
        
        
        Queue<NodeInfo> q = new LinkedList<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j)
                    continue;
                if(computers[i][j]==1)
                    q.offer(new NodeInfo(i+1,j+1));
                }
            }
        // union-find를 통하여서 같은 부모인 경우 못 가도록 막아야함!
        
        int[] parent = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i]=i; // 부모 배열 초기화
        }

        while(!q.isEmpty()){
            NodeInfo nowNode=q.poll();    
            
            int parentStart = findParent(nowNode.start, parent);
            int parentEnd = findParent(nowNode.end, parent);
            
            System.out.println(parentStart + " " + parentEnd);
            if(parentStart==parentEnd)
                continue;
            if(parentStart<parentEnd) // 너 포함 자식들도 다 바꿔야함!
                parent[parentEnd] = parentStart;
            else
                parent[parentStart] = parentEnd;
        }
        
       
    
        int nowValue = 0;
        List<Integer> aa = new ArrayList<>();
        for(int i=1; i<=n; i++){
            aa.add(findParent(parent[i], parent));
        }
        Set<Integer> duplicateNum = new HashSet<>(aa);
        

        return duplicateNum.size();
    }

    private void refresh(int n, int updateParent,int updateValue, int[] parent){
        for(int i=1; i<=n; i++){
            if(parent[i]==updateParent){
                parent[i]=updateValue;
            }
        }
    }
    
    
    private int findParent(int x, int[] parent){
        if(parent[x]==x){
            return x;
        }
        return findParent(parent[x], parent);
    }
    
    
    static class NodeInfo{
        int start;
        int end;
        
        
        public NodeInfo(int start, int end){
            this.start=start;
            this.end=end;
        }
        
        
        public String toString(){
            return this.start + " " + this.end;
        }
        
        
    }
}