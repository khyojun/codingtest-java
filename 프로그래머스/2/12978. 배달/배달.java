import java.util.*;
import java.lang.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        // 최소 시작

        // 1번이랑 연결된 거리 -> k 이하의 시간까지 갈 수 있는 도시 갯수 -> 최소 거리
        // 양방향 노드임!
        //floyd 워셜로 해결 ! -> n 3승해도 괜춘
        
        
        int[][] dis = new int[N+1][N+1];
        
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i==j){
                    dis[i][j]=0;
                    continue;
                }
                dis[i][j]=250000000;
            }
        }
        
        for(int i=0; i<road.length; i++){
            for(int j=0; j<road[i].length; j++){
                int start = road[i][0];
                int fin = road[i][1];
                int cost = road[i][2];
                
                //경로 여러개라서 배제
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
        
        
        // k -> i, j 방식으로 돌려버리기~~
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
        
        
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i==1 && dis[i][j]<=K)
                    answer++;
            }
        }
        
        
        
        
        return answer;
    }
    
    
 
}
