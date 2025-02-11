def solution(n, lost, reserve)
    answer = 0
    
    
    # n 은 학생의 전체 수
    # lost 잃어버린 체육복을 가진 학생 수
    # reserve 여벌 체육복 가지고 온 친구 바로 앞 뒤 친구에게 제공 간으 
    # lost 기준 앞 뒤 숫자가 존재하는지 reverse에서 찾고 찾은 경우 reserve에서 제거
    # lost 에 reserve에 들어있는 친구가 들어있을 수 있음!
    
    
    # 예외 케이스가 존재합니다.
    # 전체가 잃어버리고 전체가 예외 케이스를 만족한 경우
    # 중간 중간 잃어버린 사람들이 있고 그때 아래 사람한테 빌리게 하는 경우
    # 다른 학생에게 잃어버린 경우 
    
    deleted_list  = []
    
    lost=lost.sort
    reserve = reserve.sort
    same_size = []
    
    lost.each{
        |st|
        if reserve.include?(st)
            same_size << st
            reserve.delete(st)
            next
        end
    }
    
    same_size.each{
        |st|
        lost.delete(st)
    }
    
    
    lost.each{
        |st|

        if reserve.include?(st-1)
            deleted_list << st   
            reserve.delete(st-1)
        elsif reserve.include?(st+1) 
            deleted_list << st   
            reserve.delete(st+1)
        end            
    }
    
    
    answer = n - lost.size + deleted_list.size
    
    
    
    
    
    
    return answer
end