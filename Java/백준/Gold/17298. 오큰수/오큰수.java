import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.lang.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] result = new int[n+1];
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n+1];

        for(int i =0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
		}

        stack.push(0);
        for(int i=1; i<n; i++){
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                result[stack.pop()]=arr[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            result[stack.pop()]= -1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);


    }
}