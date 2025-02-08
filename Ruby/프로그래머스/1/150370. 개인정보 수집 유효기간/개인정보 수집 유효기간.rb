def solution(today, terms, privacies)
    answer = []
    
    # 계약기간은 달 기준!
    # 년도, 월, 일 이 어떻게 되는지 확인하기
    
    date=today.split(".")
    t_year=date[0].to_i
    t_month = date[1].to_i
    t_day = date[2].to_i
    
    term_hash = Hash.new(0)
    terms.each{
        |t|
        term=t.split(" ")
        term_hash[term[0]]= term[1].to_i
    }
        
    privacies.each_with_index{
        |p, index|
        
        policy=p.split(" ")[1]
        date = p.split(" ")[0] 
        date=date.split(".")
        year=date[0].to_i
        month = date[1].to_i
        day = date[2].to_i
        addMonth = term_hash[policy] + month.to_i
        realMonth = 0
        if addMonth % 12==0
            realMonth = 12
            year+=addMonth/13
        else
            realMonth = addMonth % 12
            year+=addMonth /12
        end
        
        print "now year #{year} now month #{realMonth} now Day #{day}"
                
        if t_year > year
            answer << index+1
        elsif t_year==year && t_month > realMonth
            answer << index+1
        elsif t_year==year && t_month == realMonth && t_day >= day
            answer << index+1
        end 
    }
    # 2022.05.28 일이면!
    # 2022.06.01 2022.06.01 이었으면? 보통 2022.05
    
    
    return answer
end