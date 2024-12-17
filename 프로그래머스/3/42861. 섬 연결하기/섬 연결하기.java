import java.util.*;
import java.util.stream.Collectors;
import java.lang.*;

class Solution {
    

    public int solution(int n, int[][] costs) {
        int answer = 0;
        // 작은 경로부터 우선 연결! 하지만 그 경로가 막 겹치거나 했다? 그러면 빼고
        // 경로를 정렬하는 과정이 필요!
        // union find해서 같은 부모를 향하도록 하면 됨! 그러면 모두가 통행되는거임!
        // 정렬하고 제일 처음에 있는 양반이 부모이도록 진행!
        //매번 그 visited확인하면서 탐색
        int[] parent = new int[n];
        List<ConnectInfo> info = new ArrayList<>();
        for(int i=0; i<n; i++){
            parent[i]=i;
        }//parent init
        
        for(int i=0; i<costs.length; i++){
            int start=costs[i][0];
            int finish = costs[i][1];
            int cost = costs[i][2];
            
            info.add(new ConnectInfo(start, finish, cost));
        }
        
        System.out.println(info);
        
        List<ConnectInfo> sortedList = info.stream().sorted(Comparator.comparing(ConnectInfo::getCost)).collect(Collectors.toList());

        

        
        int root = -1;
        for(int i=0; i<sortedList.size(); i++){
            if(i==0)
                root=sortedList.get(i).start;
            ConnectInfo nowInfo=sortedList.get(i);
            
            int parent1= find(nowInfo.start, parent);
            int parent2 = find(nowInfo.finish, parent);
            
            if(parent1==parent2)
                continue;
            if(parent1<parent2){
                parent[parent2]=parent1; 
            }
            else
                parent[parent1]=parent2;
        
            answer+=nowInfo.cost;            
        }

        
        
        return answer;
    }
    
    
    private int find(int child, int[] parent){
        if(parent[child] == child)
            return child;
        return find(parent[child], parent);
    }
    
    
    static class ConnectInfo{
        
        int start;
        int finish;
        int cost;
        
        public ConnectInfo(int start, int finish, int cost){
            this.start=start;
            this.finish=finish;
            this.cost=cost;
        }
        
        
        public int getCost(){
            return this.cost;
        }
        
        
        
        
    }
}