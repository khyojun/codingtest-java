def solution(a, b)
    answer = 0
    aCase=[a,b].join.to_i
    bCase=[b,a].join.to_i
    
    if aCase<=bCase
        return bCase
    end
    
    return aCase
end