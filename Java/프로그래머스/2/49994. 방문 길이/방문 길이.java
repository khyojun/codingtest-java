import java.util.List;
import java.util.ArrayList;


class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        int x=0;
        int y=0;
        List<Node> route = new ArrayList<>();
        int routeSize = 0;
        for(int i=0; i<dirs.length(); i++){
            char dir = dirs.charAt(i);
            if(dir == 'U'){
                if(x+1 >5)
                    continue;
                
                boolean isVisited = chkVisitedRoute(route,x,y, x+1, y);
            
                if(!isVisited){
                    routeSize++;
                    route.add(new Node(x, y, x+1, y));
                    route.add(new Node(x+1, y, x, y));
                }
                x++;
            }
            if(dir == 'D'){
               if(x-1<-5)
                    continue;
                boolean isVisited = chkVisitedRoute(route,x,y, x-1, y);
                if(!isVisited){
                    routeSize++;
                    route.add(new Node(x, y, x-1, y));
                    route.add(new Node(x-1,y, x,y));
                }
                x--;
            }
            if(dir == 'R'){
                if(y+1>5)
                    continue;
                boolean isVisited = chkVisitedRoute(route,x,y, x, y+1);
                if(!isVisited){
                    routeSize++;
                    route.add(new Node(x, y, x, y+1));
                    route.add(new Node(x, y+1, x, y));
                }
                y++;
            }
            if(dir == 'L'){
                if(y-1<-5)
                    continue;
                boolean isVisited = chkVisitedRoute(route,x,y, x, y-1);
                if(!isVisited){
                    routeSize++;
                    route.add(new Node(x, y,x, y-1));
                    route.add(new Node(x, y-1,x, y));
                }
                y--;
            }
            
            
        }       
        return routeSize;
    }
    
    private boolean chkVisitedRoute(List<Node> route, int x, int y, int expectedX, int expectedY){
        for(int i=0; i<route.size(); i++){
            if(route.get(i).fromX == x && route.get(i).fromY == y && route.get(i).toX==expectedX && route.get(i).toY==expectedY){
                return true;
            }
            
            if(route.get(i).toX == x && route.get(i).toY == y && route.get(i).fromX==expectedX && route.get(i).fromY==expectedY){
                return true;
            }
            
        }
       return false;
    }
    
    static class Node{
        int fromX;
        int fromY;
        int toX;
        int toY;
        
        public Node(int fromX, int fromY, int toX, int toY){
            this.fromX=fromX;
            this.fromY=fromY;
            this.toX=toX;
            this.toY=toY;
        }
    }
}