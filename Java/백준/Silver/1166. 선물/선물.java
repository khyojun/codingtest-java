import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.lang.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        double s = 0;
        double e = Math.min(Math.min(l, w), h);

        // 선물의 최대와 최소 범위는 제일 낮은 값 - 제일 높은 값

        for (int i = 0; i < 10000; i++) {
            double mid = (s + e) / 2;

            long counts = (long)(l / mid) * (long)(w / mid) * (long)(h / mid);

            if (counts < n) {
                e = mid;
            } else {
                s = mid;
            }
        }


        System.out.printf("%.9f", s);
    }
}