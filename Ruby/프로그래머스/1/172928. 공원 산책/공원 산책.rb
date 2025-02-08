def solution(park, routes)
    answer = []
    
    startX=0
    startY=0
    # 하나로 묶을 수 있음 시작점 위치 찾기!
    for i in 0..park.length-1
        if park[i].include?("S")
            startY=park[i].index("S")
            startX=i
            break
        end
    end
    
    nowX=startX
    nowY=startY
    parkYLength = park[0].length
    parkXLength = park.length
    ## 탐색
    routes.each{
        |t|
        cmd=t.split(" ")
        moveCnt=cmd[1].to_i
        
        if cmd[0] == "E"
            if nowY+moveCnt < parkYLength
                hasMark = false
                testY=nowY
                moveCnt.times{
                    if park[nowX][testY+1] == "X"
                        hasMark = true
                        break
                    else
                        testY+=1
                    end
                }
                if !hasMark
                    nowY = nowY+moveCnt
                end
            end
    
        elsif cmd[0] == "W"
            if nowY-moveCnt >= 0
                hasMark = false
                testY=nowY
                moveCnt.times{
                    if park[nowX][testY-1] == "X"
                        hasMark = true
                        break
                    else
                        testY-=1
                    end    
                }
                if !hasMark
                    nowY = nowY-moveCnt
                end
            end
        
            
        elsif cmd[0] == "S"
            if nowX+moveCnt<parkXLength
                hasMark = false
                testX=nowX
                moveCnt.times{
                    if park[testX+1][nowY] == "X"
                        hasMark = true
                        break
                    else
                        testX+=1
                    end
                    
                }
                if !hasMark
                    nowX = nowX+moveCnt
                end
            end
        elsif cmd[0] =="N"
            if nowX-moveCnt >=0
                hasMark = false
                testX=nowX
                moveCnt.times{
                    if park[testX-1][nowY] == "X"
                        hasMark = true
                        break
                    else
                        testX-=1
                    end
                    
                }
                if !hasMark
                    nowX = nowX-moveCnt
                end
            end
        end       
        
    }    
    
    

    return [nowX, nowY]
end