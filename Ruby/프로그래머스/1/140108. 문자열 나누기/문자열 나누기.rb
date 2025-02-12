def solution(s)
    answer = 0
    
    # aaabbaccccabba
    # aaabbacc
    # ccab
    # ba
    
    # 지금 x 문자를 기준으로 다른 문자가 몇개인지 매번 비교하면서 진행해야하는 문제!
    
    x=s[0]
    x_key=0
    str_answer = []

    s.chars.each_with_index{
        |str, index|
        if index == 0
            x=s[0]
            x_key=0
            next
        end
        
        str_hash=s[x_key..index].chars.tally

        
        diff_cnt=str_hash.select{
            |k,v|
            k != x
        }.sum{
            |k,v|
            v
        }

        if diff_cnt == str_hash[x]
            str_answer << s[x_key..index]
            x=s[index+1]
            x_key=index+1
        end
                
    }
    
    if str_answer.join.size < s.size
        str_answer << s[str_answer.join.size..s.size]
    end
    
    
    
    
    
    return str_answer.size
end