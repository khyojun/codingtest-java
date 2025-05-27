import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.lang.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        boolean[] isPrime = new boolean[100000000];
        Arrays.fill(isPrime, true);

        for(int i=2; i<=Math.sqrt(1299709); i++){
            if(isPrime[i]){
                for(long j=i*i; j<= 1299709; j+=i){
                    isPrime[(int)j] = false;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();

        for(int i=2; i<=1299709; i++){
            if(isPrime[i]){
                primes.add(i);
            }
        }

        // 0~ 10 사이의 소수 1개 그 중 제일 큰거 이분탐색  제일 큰 소수 찾기
        // 10~ 최대크기 소수
        int testCase = Integer.parseInt(br.readLine());

        for(int i=0; i<testCase; i++){
            int now = Integer.parseInt(br.readLine());

            if(isPrime[now]) {
                System.out.println(0);
                continue;
            }

            int s = 0;
            int e = primes.size()-1;
            while(s<=e){
                int mid = (s+e)/2;

                if(primes.get(mid) < now){
                    s=mid+1;
                }
                else{
                    e = mid-1;
                }
            }
            int beforeNow = primes.get(s-1);

            //나보다 큰 최소의 수
            int s2 = s;
            int e2 = primes.size()-1;
            while(s2<=e2){
                int mid = (s2+e2)/2;
                if(primes.get(mid) > now){
                    e2=mid-1;
                }
                else{
                    s2 = mid+1;
                }
            }
            int afterNow = primes.get(e2+1);
            System.out.println(afterNow-beforeNow);
        }


    }
}