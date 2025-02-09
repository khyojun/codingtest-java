def isBreadNow(ingre)
    if ingre == 1
        return 1
    end
    return 0
end




def solution(ingredient)
    answer = 0
    

    # cntStack 을 통해서 처리    
    
    stack = []
    cntStack = []
    reciepe = [1,2,3,1]
    cnt=0

    nowCheck = false

    ingredient.each_with_index{
        |ingre, index|
    
        if ingre == reciepe[cnt]
            cnt+=1
            cntStack << cnt
            if cnt == 4
                answer+=1
                4.times{
                    cntStack.pop()
                }
                if cntStack.last.nil?
                    cnt =0
                else
                    cnt = cntStack.last
                end
            end
        else
            cnt = isBreadNow(ingre)
            cntStack << cnt
        end

    }
    
    return answer
end