import java.lang.*;
class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        
        // 계속 나누다가 그냥 끝나면 됨!
        
        while(n>0){
            answer++;
            if(a%2==1){
                a++;
            }
            if(b%2==1){
                b++;
            }
            
            if(a==b){
                break;
            }
            // if(a%2==1){
            //     a++;
            // }
            // if(b%2==1){
            //     b++;
            // }
            a/=2;
            b/=2;
            System.out.println("a : " + a + "b : " + b);

        }
        
        System.out.println("answer : " + answer);

        return answer;
    }
}