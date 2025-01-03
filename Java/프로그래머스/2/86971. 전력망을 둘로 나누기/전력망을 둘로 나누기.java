import java.util.*;
import java.lang.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = -1;
        // 무조건 1이 들어가므로 1기준으로 bfs 돌면서 연결된 노드 갯수랑 비교하면 되는 문제!
        
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
        
        List<Integer> sorted=result.stream().sorted().collect(Collectors.toList());
        
        return sorted.get(0);
    }
    
    private int bfs(int n, List<List<Integer>> map, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        int result=0;
        q.offer(1);
        while(!q.isEmpty()){
            int nowNode=q.poll();    
            if(visited[nowNode])
                continue;
            visited[nowNode]=true;
            result++;
            for(int j=0; j<map.get(nowNode).size(); j++){
                q.offer(map.get(nowNode).get(j));
            }
        }
        return result;
    }



}
    
