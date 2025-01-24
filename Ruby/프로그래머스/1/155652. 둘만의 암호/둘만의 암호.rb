def getNextChar(s, skip, index)
    
    cnt=0
    skipCnt=0
    # index 만큼 카운트가 되면 탈출이고 계속 넘어가게 되는 경우는 없음 skip 이 10개이기 때문에 걱정 ㄴㄴ
    # 숫자를 더해야함! -> 어떤 숫자? 지금부터 지나간 index만큼을 기록하는 친구가 필요함!
    while 1==1 do
        
        if s.ord>'z'.ord
            s = 'a'
        end
        
        if cnt>=index
            return s
            break
        elsif skip.include?(s)
            s= (s.ord+1).chr
            skipCnt+=1
        else
            s= (s.ord+1).chr
            cnt+=1
        end
    end
end



def solution(s, skip, index)
    answer = ''
    result = Array.new
    
    # chars each string은 다음과 같이 변환을 해줘야함
    # skip을 했을 때! -> 일단 index를 더하고! 그 값이 어떻게 되냐에 따라서 변환하냐? 아니냐? 가 결정됨!
    # 이거에 대한 판단을 무한 루프를 통해 계속 갈때까지 봐야할 케이스도 있음!
    # 위 역할에 대한 함수 따로 분리해서 진행! 뭘 도대체 더할 수 있는지!
    
    return s.chars.map{ |t|
         plusIndex = getNextChar(t, skip, index)
    }.join
    
    
end