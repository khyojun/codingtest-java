import java.util.*;
import java.lang.*;
class Solution {
    
    static int maxSheep;
    static List<Boolean> visited = new ArrayList<>();
    static Map<Integer, List<Integer>> map = new HashMap<>();
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        
        for(int i=0; i<info.length; i++){
            map.put(i, new ArrayList<>());
            visited.add(false);
        }
        
        for(int i=0; i<edges.length; i++){
            map.get(edges[i][0]).add(edges[i][1]);
        }
        
        List<Integer> next = new ArrayList<>();
        next.add(0);
        dfs(0, info, next, 0,0);
        
        
        return maxSheep;
    }
    
    
    void dfs(int node, int[] info,List<Integer> next, int sheep, int wolf){
        
        if(info[node]==0)
            sheep++;
        else
            wolf++;
        
        //System.out.println("now node is : " + node);
        if(sheep>wolf){
            maxSheep=Math.max(maxSheep, sheep);
        }
        else{
            return;
        }
        
        List<Integer> nextRoute = new ArrayList<>(next);
        if(!map.get(node).isEmpty()){
            nextRoute.addAll(map.get(node));
        }
        nextRoute.remove(Integer.valueOf(node));
        
        for(int i=0; i<nextRoute.size(); i++){
            dfs(nextRoute.get(i), info, nextRoute, sheep, wolf);
        }
        
    }
    
  

    
}