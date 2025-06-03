import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.lang.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            Stack<Character> stack = new Stack<>();
            String gwalo = br.readLine();
            int index=0;
            while(index< gwalo.length()){

                char nowVal = gwalo.charAt(index);
                if(nowVal == ')'){
                    if(stack.isEmpty()) {
                        System.out.println("NO");
                        break;
                    }
                    stack.pop();
                }else{
                    stack.push(nowVal);
                }

                index++;
            }
            if(!stack.isEmpty()){
                System.out.println("NO");
            }
            else if(index==gwalo.length())
                System.out.println("YES");
        }



    }
}