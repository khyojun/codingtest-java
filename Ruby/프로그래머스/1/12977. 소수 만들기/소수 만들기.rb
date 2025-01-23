def isPrime(num)
    cnt=0
    #puts num
    puts 
    for i in 2..Math.sqrt(num)
        if num%i==0
            return false
        end
    end
    
    return true
end

def solution(nums)
    answer = 0

    # [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    # 3개의 수를 어떻게 뽑을지?
    # 반복문 이용?
    # 3중 for -> 50C3
    # combination을 활용하면 쉽게 할 수 있다.

    return nums.combination(3).map{|t| t.sum}.select{|t| isPrime(t)}.count()
    
    
end