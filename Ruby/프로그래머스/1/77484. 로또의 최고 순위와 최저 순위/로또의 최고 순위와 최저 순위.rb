def solution(lottos, win_nums)
    answer = []
    # 로또 맞추는 방식인데 알 수 없는 번호가 0으로 매겨져있음!
    # 이때 가장 많이 맞춰서 받을 수 있는 번호 등수, 최저 등수 구하기
    
    
    # sol : 일단 각 번호들이 중복되지는 않음!
    # sol : 있는 숫자 중에서 몇개가 일치하는지 찾는게 제일 중요! 사실 0의 갯수에 따라서 제일 많이 맞출 수 있거나 아닐 수가 있는것임!
    
    
    win_match_cnt=0
    zero_cnt=0
    lottos.each{
        |n|
        if n==0
            zero_cnt+=1
            next
        elsif win_nums.include?(n)
            win_match_cnt+=1
        end
    }
    
    print "#{zero_cnt} zero and win match cnt #{win_match_cnt}"
    
    max_cnt = zero_cnt+win_match_cnt
    min_cnt = win_match_cnt
    
    if min_cnt ==0 || min_cnt == 1
        min_cnt = 1
    end
    
    if max_cnt == 0 || max_cnt ==1
        max_cnt =1 
    end
    
    return [7-max_cnt, 7-min_cnt]
end