def solution(d, budget)
    answer = 0
    
    # 조합으로 해결괼 것이 아닌 다른 방식으로! 약간 그리디! 
    # 오름차순 정렬 이후 해결하는 방식1
  
    sort_d=d.sort
    
    
    for i in 0..sort_d.length-1
        
        puts budget-sort_d[i]
        puts i
        if budget-sort_d[i]>=0
            budget-=sort_d[i]
        else
            return i
        end
    end
    
    
    return sort_d.length
end