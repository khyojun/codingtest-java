import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int yLength=maps.length;
        int MAX_NUMBER = 10000000;
        int xLength = maps[0].length;
        int[][] disMaps = new int[yLength][xLength];
        boolean[][] visited = new boolean[yLength][xLength];
        
        for(int i=0; i<yLength; i++){
            disMaps[i]=maps[i].clone();
        }
        
        for(int i=0; i<yLength; i++){
            for(int j=0; j<xLength; j++){
                if(i==0 && j==0)
                    continue;
                if(disMaps[i][j]==1)
                    disMaps[i][j]=MAX_NUMBER;
            }
        }
        
       
        
        
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        
        // 상하좌우만 이동가능! 
        // 0인곳 못가고 1만 이동가능! bfs를 통해서 탐색진행!
        // stack 을 통해서 위치 변동 시키고 범위 탐색하고 다 진행할예정
        //1,1에서 시작! -> 0,0임
        
        Queue<LocInfo> locInfo = new LinkedList<>();
        
        locInfo.offer(new LocInfo(0,0));
        
        //offer 가 넣기, poll 이 뺴기, peek가 맨끝에, isEmpty로 확인가능
        
        while(!locInfo.isEmpty()){
            
            LocInfo nowLoc = locInfo.poll();
            int x= nowLoc.x;
            int y= nowLoc.y;
            //visited[y][x]=true;
            for(int i=0; i<4; i++){
                if((dx[i]+x >= 0 && dx[i]+x < xLength) && (dy[i]+y >= 0 && dy[i]+y < yLength)){
                    int nextX = dx[i]+x;
                    int nextY = dy[i]+y;
                   
                    if(maps[nextY][nextX]==0 || visited[nextY][nextX])
                        continue;
                   
                    visited[nextY][nextX]=true;

                    disMaps[nextY][nextX]=Math.min(disMaps[y][x]+1, disMaps[nextY][nextX]);
                    locInfo.offer(new LocInfo(nextX,nextY));
                }
            }
        }
        
//         for(int i=0; i<yLength; i++){
//             for(int j=0; j<xLength; j++){
//                 System.out.print(disMaps[i][j] + " ");
//                 System.out.print(visited[i][j] + " ");
//             }
//             System.out.println();
//         }
        
        
        
        
        
        return disMaps[yLength-1][xLength-1] == MAX_NUMBER ? -1 : disMaps[yLength-1][xLength-1];
    }
    
    
    static class LocInfo{
        int x;
        int y;
        
        
        public LocInfo(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}