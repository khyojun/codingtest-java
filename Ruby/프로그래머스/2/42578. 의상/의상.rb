def solution(clothes)
    answer = 1
    
    hash=clothes.to_h
    tal=hash.map{|k,v| v}.tally
    puts tal

    #abc + ab+ ac+ bc + a+ b+ c
    
    
    # 이거 공식으로 하면 조합론의 공식이 되어진다! 그래서 
    
    
    
    
    # (a+1)(b+1)(c+1) 이 되어서 이렇게 된다.
    
    
    tal.each{
        |k,v|
        answer*=(v+1)
    }
    
    
    
    
    
    return answer-1
end