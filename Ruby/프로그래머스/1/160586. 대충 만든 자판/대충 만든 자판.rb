def solution(keymap, targets)
    answer = []
    
    # 하나씩 누를때마다 몇 번 누르는지 알 수 있다.
    # keymap 이 여러개 올 수 있다!
    # target을 만들때 총 몇 번 눌러야 하는지 결정!
    
    # 솔루션 : 최소로 이 알파벳을 찾는게 몇 번 있는지 발견해야함!
    # target : 별 결과물을 발견해야함! 만약에 하나도 안들어있다면 그때 -1
    
    # 다 도는것이 방법이 아닌거 같음! keymap 에 각각의 알파벳이 총 몇 번 누르는지가 중요함!
    # 이에 hash를 이용해서 몇번 눌러야지 도달할 수 있는지! 최솟값에 대해서 저장할 수 있는 부분을 만들어야 할 거 같음!
    
    hash_alp = Hash.new(-1)
    keymap.each{
        |key|
        key.chars.each_with_index{
            |k, index|
            if hash_alp[k]==-1
                hash_alp[k]=index+1
                next
            elsif hash_alp[k] > index+1
                hash_alp[k] = index+1
            end
        }
    }
    
    # target에서 찾기
    
    targets.each{
        |target|
        sum=0
        break_flag = false
        target.chars.each{
            |t|
            if hash_alp[t]== -1
                break_flag = true
                break
            end
            sum+=hash_alp[t]
        }
        if break_flag
            answer << -1
            next
        end
        answer << sum
    }
    
    
  
    
    return answer
end