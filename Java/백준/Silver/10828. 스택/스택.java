import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.lang.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String cmd = st.nextToken();
            switch(cmd){
                case "push":
                    int value = Integer.parseInt(st.nextToken());
                    stack.push(value);
                    break;

                case "pop":
                    if(stack.isEmpty())
                        System.out.println("-1");
                    else
                        System.out.println(stack.pop());
                    break;
                case "top":
                    if(stack.isEmpty())
                        System.out.println("-1");
                    else
                        System.out.println(stack.peek());
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    if(stack.isEmpty())
                        System.out.println("1");
                    else
                        System.out.println("0");
                    break;
            }
        }

    }
}