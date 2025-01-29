def solution(wallpaper)
    answer = []
    x = []
    y = []
    minX= 51
    minY = 51
    maxX = 0
    maxY = 0
    
    # 문제의 핵심 -> 파일이 처음 시작되는 x 좌표와 끝나는 x 좌표
    
    # 시작점과 끝점을 비교해야함!
    
    # y 좌표가 시작하는 점과 끝나는 점 을 찾으면 된다!
    cnt=0
    wallpaper.each{|line|
        for i in 0..line.length-1
            if line[i]=="#"
                x.push(i)
                x.push(i+1)
                y.push(cnt)
                y.push(cnt+1)
            end
        end
        cnt+=1
    }
    sorted_x=x.sort
    sorted_y=y.sort

    
    
    minX=sorted_x[0]
    maxX=sorted_x[sorted_x.length-1]
    minY=sorted_y[0]
    maxY=sorted_y[sorted_y.length-1]

    
    
    
    return [minY, minX, maxY, maxX]
end