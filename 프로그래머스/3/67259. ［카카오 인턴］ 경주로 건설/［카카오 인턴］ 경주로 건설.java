import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        
        // 지금 나까지 오는데 얼마나 걸렸는지 + 얼마나의 비용이 들었는지도 함께 고려해야함!
        // 일반적인 bfs 인 거 같지만 사실 + 다이나믹? 조금 들어감! 
        // bfs 도는데 만약에 거리가 같다! 라고 한다면 비용이 더 적게 드는 친구 방식을 택해서 건너가야함!
        // 추가 해법 -> 방향을 더해주자
        
        int length = board.length;
        
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        int[] dir = {1,1,2,2}; // 1 이면 좌우, 2이면 상하
        boolean[][][] visited = new boolean[length+1][length+1][3];
        
        int[][][] dis = new int[length+1][length+1][3];
        
        for(int i=0; i<length; i++){ // init
            for(int j=0; j<length; j++){
                dis[i][j][1] = 1000_0000;
                dis[i][j][2] = 1000_0000;
            }
        }
        
        // 가는 방향이 중요함! 직선이었다가 꺾으면! dir
        // 직진인지 커브인지 여부가 중요! 
        // q에는 좌표 정보가 들어가야하지 않음?
        Queue<Point> q = new LinkedList<>();
        
        dis[0][0][0]=0;
        q.offer(new Point(0,0,0));
        // dir 1 이면 좌우, 2이면 상하
        
        while(!q.isEmpty()){
            Point p=q.poll();
            int nowX = p.x;
            int nowY= p.y;
            int nowDir=p.dir;     

            // if(!visited[nowX][nowY][nowDir])
            //     visited[nowX][nowY][nowDir]=true;
            // else
            //     continue;
            // if(nowDir==0){
            //     visited[nowX][nowY][1]=true;
            //     visited[nowX][nowY][2]=true;
            // }
            
            for(int i=0; i<4; i++){
                int nextX = nowX+dx[i];
                int nextY = nowY+dy[i];
                if((nextX <length && nextX>=0) && (nextY <length && nextY>=0)){
                    int nextDir = dir[i];
                    int cost =100;
                    if(nextDir!=nowDir && nowDir!=0){
                        cost = 600;
                    }
                    // true 일지라도! 최소값이면 변경 하고 
                    // 문제 파악 방향따라 값이 다 다름

                    if(board[nextX][nextY]==1)
                        continue;
                    if(dis[nextX][nextY][nextDir] >= dis[nowX][nowY][nowDir]+ cost){
                        dis[nextX][nextY][nextDir] = dis[nowX][nowY][nowDir]+ cost;
                        q.offer(new Point(nextX,nextY, nextDir));
                        }
                    
                     
                            
                     }
                    }
                }
                return Math.min(dis[length-1][length-1][1], dis[length-1][length-1][2]);

            }

    
    static class Point{
        int x;
        int y;
        int dir;
        public Point(int x, int y, int dir){
            this.x=x;
            this.y=y;
            this.dir= dir;
        }
        
    }
    
}
    
    
    
