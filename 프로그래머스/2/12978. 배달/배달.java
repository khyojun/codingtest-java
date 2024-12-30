import java.util.*;
import java.lang.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        // 최소 시작

        // 1번이랑 연결된 거리 -> k 이하의 시간까지 갈 수 있는 도시 갯수 -> 최소 거리
        // 양방향 노드임!
        
        //아니면 다익스트라 돌리고! -> 그 다음 비용 다 계산하면 되긴함!
        
        Queue<Route> q = new LinkedList<>();
        
        int[][] dis = new int[N+1][N+1];
        
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i==j){
                    dis[i][j]=0;
                    continue;
                }
                //dis[i][j]=Integer.MAX_VALUE;
                dis[i][j]=250000000;
            
            }
        }
        
        for(int i=0; i<road.length; i++){
            for(int j=0; j<road[i].length; j++){
                int start = road[i][0];
                int fin = road[i][1];
                int cost = road[i][2];
                
                q.offer(new Route(start,fin, cost));
                q.offer(new Route(fin,start, cost));
                if(dis[start][fin]!=250000000){
                    if(dis[start][fin] >= cost){
                        dis[start][fin] = cost;
                        dis[fin][start]= cost;
                    }
                    continue;
                }
                
                dis[start][fin]=cost;
                dis[fin][start]=cost;
            }
        }
        
//          for(int i=1; i<=N; i++){
//             for(int j=1; j<=N; j++){
     
//                 System.out.print(dis[i][j] + " ");
//             }
//             System.out.println();
//         }
        
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(i==j)
                        dis[i][j]=0;
                    if(dis[i][j] >= dis[i][k] + dis[k][j])
                        dis[i][j]=dis[i][k]+dis[k][j];
                }
            }
        }
        
        
        //경로가 여러개인 경우들이 있음! ㅠㅠㅠ
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i==1 && dis[i][j]<=K)
                    answer++;
                //System.out.print(dis[i][j] + " ");
            }
            //System.out.println();
        }
        
        
        
        
        return answer;
    }
    
    
    static class Route{
        int start;
        int fin;
        int cost;
        
        
        public Route(int start, int fin, int cost){
            this.start=start;
            this.fin=fin;
            this.cost=cost;
        }
        
    }
}