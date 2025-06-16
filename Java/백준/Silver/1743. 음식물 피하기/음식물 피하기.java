import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
import java.util.*;


public class Main {


    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int cnt=0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());
        int k= Integer.parseInt(st.nextToken());

        char[][] arr = new char[n+1][m+1];
        boolean[][] visited = new boolean[n+1][m+1];

        List<Point> points = new ArrayList<>();
        for(int i=0; i<k; i++ ){
            StringTokenizer pointSt = new StringTokenizer(br.readLine(), " ");
            int x  = Integer.parseInt(pointSt.nextToken());
            int y  = Integer.parseInt(pointSt.nextToken());

            points.add(new Point(x,y));
            arr[x][y] = '*';
        }

        int result =0;
        for(int i=0; i<k; i++){
            cnt=0;
            int x= points.get(i).x;
            int y= points.get(i).y;
            dfs(x,y,n,m,arr, visited);
            result =Math.max(cnt, result) ;
        }

        System.out.println(result);
    }


    private static void dfs(int x, int y, int maxX, int maxY, char[][] arr, boolean[][] visited){

        if(!isRightRang(x, y, maxX, maxY)) return;
        if(visited[x][y]) return;
        if(arr[x][y]!='*') return;
        visited[x][y] = true;
        cnt++;

        for(int i=0; i<4; i++){
            dfs(x + dx[i], y + dy[i], maxX, maxY, arr, visited);
        }
    }

    private static boolean isRightRang(int x, int y, int maxX, int maxY){
        return x>=1 && x<=maxX && y>=1 && y<=maxY;
    }


    static class Point{
        int x;
        int y;
        
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

    }
}