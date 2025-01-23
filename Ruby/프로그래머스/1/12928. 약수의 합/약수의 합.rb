def solution(n)
    answer = 0
    
    # 반복문을 통해 처음터 끝까지!
    
    for i in 1..n
        if n%i==0
            answer+=i
        end
    end
    
    
    return answer
end