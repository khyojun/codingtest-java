def initHash()
    type_hash=Hash.new(0)
    
    type_hash["R"] =0
    type_hash["T"] =0
    type_hash["C"] =0
    type_hash["F"] =0
    type_hash["J"] =0
    type_hash["M"] =0
    type_hash["A"] =0
    type_hash["N"] =0
    return type_hash
end


def make_result(type, answer)
    if type["R"] >= type["T"]
        answer << "R"
    else
        answer << "T"
    end
    
    if type["C"] >= type["F"]
        answer << "C"
    else
        answer <<"F"
    end
    
    if type["J"] >= type["M"]
        answer << "J"
    else
        answer << "M"
    end
    
    if type["A"] >= type["N"]
        answer << "A"
    else
        answer << "N"
    end
    return answer     
end

def solution(survey, choices)
    answer = ''
    # 한쌍이 정해져있음!
    # 순서에 따라 누가 비동의 동의인지 달라짐!
    
    type=initHash
    
    survey.each_with_index{
        |t,index|
        first_type=t[0]
        second_type=t[1]
        
        scoring=choices[index]
        
        if scoring >4
            type[second_type]+=  scoring - 4
        else
            type[first_type] += 4-scoring
        end
    }

    
    # answer 에다가 뭐가 높았는지 넣어주는 역할!
    make_result(type, answer)  
    
    return answer
end