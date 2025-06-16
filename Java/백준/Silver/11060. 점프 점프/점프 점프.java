import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        
        int[] arr = new int[n+2];
        int[] dp = new int[n+2];
        
        for(int i=0; i<=n; i++){
            dp[i] = 1001;
        }
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        dp[1]=0;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=arr[i]; j++){
                if(i+j > n) break;
                dp[i+j] = Math.min(dp[i+j], dp[i]+1);

            }
        }

        if(dp[n]== 1001){
            System.out.println("-1");
            return;
        }

        System.out.println(dp[n]);
    }



}