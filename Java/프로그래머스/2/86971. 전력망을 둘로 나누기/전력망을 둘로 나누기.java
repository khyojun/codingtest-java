import java.util.*;
import java.lang.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = -1;
        // 낮은 번호를 부모로 하고 자식의 갯수를 세는 것이 제일 좋을 거 같음!
        // n 100개이기에 엄청 많지 않음!
        // brute force 로 진행해야함!
        // union find로 생각해도 될 거 같음!
        // parent에서 뻗어나가는 친구에 대한 값들을 계속 넣기
        
        // 길이 n-1
        // v1 < v2 <=n
        
        
        // 하나씩 끊어봤을때 길 어떻게 되는지 확인해봐야함!
        
        
        
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<n-1; i++){
            List<List<Integer>> map = new ArrayList<>();
            boolean[] visited = new boolean[n+1];                    
            for(int j=0; j<=n; j++){
                map.add(new ArrayList<>()); // init
            }
            for(int j=0; j<n-1; j++){
                if(i==j)
                    continue;
                map.get(wires[j][0]).add(wires[j][1]);
                map.get(wires[j][1]).add(wires[j][0]);
            }
                
                int resultConnect = bfs(n,map, visited);
                
                int remainConnect = n-resultConnect;
                result.add(Math.abs(resultConnect-remainConnect));
   
            }   
        
        //System.out.println(result);
        
        
        List<Integer> sorted=result.stream().sorted().collect(Collectors.toList());
        //System.out.println(sorted);
        
        return sorted.get(0);
    }
    
    private int bfs(int n, List<List<Integer>> map, boolean[] visited){
       
        Queue<Integer> q = new LinkedList<>();
        int result=0;
       
        q.offer(1);
        while(!q.isEmpty()){
            int nowNode=q.poll();    
            //System.out.println(nowNode);
            if(visited[nowNode])
                continue;
            visited[nowNode]=true;
            result++;
            //System.out.println(map.get(nowNode));
            for(int j=0; j<map.get(nowNode).size(); j++){
                q.offer(map.get(nowNode).get(j));
            }
        }
        
            
        //System.out.println("turn finish");
        return result;
    }



}
    