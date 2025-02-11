def findCommonNumber(x_hs, y_hs)
    common_str = ""
    x_hs.each{
        |k_x, v_x|
        y_hs.each{
            |k_y, v_y|
            if k_x == k_y
                if v_x < v_y
                    common_str<< k_x * v_x
                else
                    common_str << k_x * v_y
                end
            end
        }
    }
    common_str
end
            
    

def solution(x, y)
    answer = ''
    # 300만 까진데 사실은 문자열의 길이가 제일 중요함!
    # 제일 큰 수는 공통된수들 중 제일 큰 수를 제일 앞으로 세우는 것이 중요함!
    # 찾은 지점에 대해서 넣고 y에서는 빼고 하는 방식으로 진행해야함!
    # hash로 몇개가 겹치는지 찾고 이를 정렬하면 될 문제인거 같음!
    
    x_hs=x.chars.tally
    y_hs=y.chars.tally
    
    
    answer = findCommonNumber(x_hs,y_hs)


    answer=answer.chars.sort.reverse.join
    
    
    if answer == ""
        return "-1"
    elsif answer.to_i == 0
        return "0"
    end
    

    return answer
end