import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.lang.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        int sum =0;
        for(int i=0; i<n; i++){
            list.add(Integer.parseInt(br.readLine()));
            sum += list.get(i);
        }

        int min = Collections.max(list);
        int max = sum;

        int s = min;
        int e = max;
        int result =0;

        // 5 3
        // 1 2 3 4 5
        // 5 15
        while(s<=e){
            int cnt=1;
            int mid = (s+e)/2; // 이게 돈
            int total =0;

            for(int i=0; i<n; i++){
                if(total + list.get(i) > mid){
                    total=list.get(i);
                    cnt++; // 한 번도 안 빼먹고 근야 나갈 때 번수 1번은 무조건 나가게 되어있음.
                }else{
                    total += list.get(i);
                }
            }
            // 나가긴 하지만 -> 최소 금액을 맞추기 위해 어떤 조건일 때 그렇게 하는게 좋을까?
            //

            if(cnt>m){
                s= mid+1;
            }else{
                result= e;
                e= mid-1;
            }
        }

        System.out.println(result);
    }
}