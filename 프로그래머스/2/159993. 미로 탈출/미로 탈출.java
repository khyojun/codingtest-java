import java.util.*;
import java.lang.*;

class Solution {
    public int solution(String[] maps) {
        int answer = 0;
         
        
        int length = maps[0].length(); // 길이
        int height = maps.length;
        
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        
        Pos start = null;
        
        for(int i=0; i<height; i++){
            for(int j=0; j<length; j++){
                if(maps[i].charAt(j)=='S'){
                    start = new Pos(i,j);
                    break;
                }
            }
        }
        
        
        
        int[][] toRevarMap= new int[height+1][length+1];
        boolean[][] visitedRevar = new boolean[height+1][length+1];
        int[][] toFinMap= new int[height+1][length+1];
        boolean[][] visitedFin = new boolean[height+1][length+1];

        
        for(int i=0; i<height; i++){
            for(int j=0; j<length; j++){
                toRevarMap[i][j] = Integer.MAX_VALUE;
                toFinMap[i][j] = Integer.MAX_VALUE;
            }
        }
        
        //처음엔 레버까지 거리
        Queue<Pos> q = new LinkedList<>();
        
        q.offer(start);
        toRevarMap[start.y][start.x]=0;
        
        int toRevarMinDist=-1;
        Pos revarPos=null;
        
        while(!q.isEmpty()){
            Pos nowPos = q.poll();
            int y = nowPos.y;
            int x = nowPos.x;
            
            if(visitedRevar[y][x]==true)
                continue;
            visitedRevar[y][x]=true;
        
            if(maps[y].charAt(x)=='L'){
                toRevarMinDist=toRevarMap[y][x];
                revarPos=new Pos(y,x);
                q.clear();
                break;
            }
        
            for(int i=0;i<4; i++){
                int nextX = x+dx[i];
                int nextY = y+dy[i];
                if((nextX>=0 && nextX<length) && (nextY>=0 && nextY<height)){
                    if(maps[nextY].charAt(nextX)=='X')
                        continue;
                    if(toRevarMap[nextY][nextX]>= toRevarMap[y][x]+1){
                        toRevarMap[nextY][nextX] = toRevarMap[y][x]+1;
                        q.offer(new Pos(nextY, nextX));
                    }
                }
            }
            
        }
        
        if(toRevarMinDist==-1)
            return -1;
    
        int toFinMinDist=-1;
        
        q.offer(revarPos);
        toFinMap[revarPos.y][revarPos.x]=0;
        
        
        while(!q.isEmpty()){
            Pos nowPos = q.poll();
            int y = nowPos.y;
            int x = nowPos.x;
            
            if(visitedFin[y][x]==true)
                continue;
            visitedFin[y][x]=true;
        
            if(maps[y].charAt(x)=='E'){
                toFinMinDist=toFinMap[y][x];
                q.clear();
                break;
            }
        
            for(int i=0;i<4; i++){
                int nextX = x+dx[i];
                int nextY = y+dy[i];
                if((nextX>=0 && nextX<length) && (nextY>=0 && nextY<height)){
                    if(maps[nextY].charAt(nextX)=='X')
                        continue;
                    if(toFinMap[nextY][nextX]>= toFinMap[y][x]+1){
                        toFinMap[nextY][nextX] = toFinMap[y][x]+1;
                        q.offer(new Pos(nextY, nextX));
                    }
                }
            }
            
        }
        
        if(toFinMinDist==-1)
            return -1;
        
        
        answer = toFinMinDist+toRevarMinDist;
        return answer;
    }
    
    
    static class Pos{
        int y;
        int x;
        
        
        public Pos(int y, int x){
            this.x=x;
            this.y=y;
        }
        
        public String toString(){
            return "x:" +x + "y: "+ y;
        }
    }
}