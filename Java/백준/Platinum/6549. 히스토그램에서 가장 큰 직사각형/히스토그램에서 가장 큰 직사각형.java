import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.lang.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            if(n==0)
                break;
            long[] arr = new long[n+1];
            List<Long> result = new ArrayList<>();
            for(int i=0; i<n; i++){
                arr[i] = Long.parseLong(st.nextToken());
            }
            Stack<Integer> stack = new Stack<>();
            arr[n]=-1;
            stack.push(-1);
;            for(int i=0; i<=n; i++){
                    while(stack.size()>1 && arr[i] < arr[stack.peek()]){
                        int nowValue = stack.pop();
                        int left =stack.peek();
                        result.add(arr[nowValue]*(i-left-1));
                    }
                stack.add(i);
            }
            System.out.println(Collections.max(result));
        }

    }
}