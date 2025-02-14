def solution(k, m, score)
    answer = 0
    
    score=score.sort.reverse
    #print score
    waste = 0
    if score.length%m!=0
        waste = score.length%m
    end
        
    # 최저 사과 점수 * 한 상자에 담긴 사과 갯수 * 상자 갯수
    # 최저 사과 점수
    # 한 상자에 담긴 사과 갯수
    
    
    i=0
    while i<= score.length-1
        min=10
        
        # print "i : #{i}\n"
        if i+m-1 > score.length-1
            break
        end
        
        for j in i..i+m-1
            # print "score[j] : #{score[j]}\n"
            if score[j] < min
                min=score[j]
            end
        end
        i+=m
        # print "min : #{min}\n"
        answer += min*m
            
    end
        
    
    
    return answer
end