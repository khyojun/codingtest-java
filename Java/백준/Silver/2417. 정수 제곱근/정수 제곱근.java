import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.lang.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        long s = 0;
        long e = n;

        while(s<=e){
            long mid = (s+e)/2;
            if(Math.pow(mid,2)< n){
                s = mid+1;
            }
            else{
                e=mid-1;
            }
        }
        System.out.println(s);
    }
}