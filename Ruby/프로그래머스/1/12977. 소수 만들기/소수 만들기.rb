require 'prime'

def solution(nums)
    answer = 0

    # [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    # 3개의 수를 어떻게 뽑을지?
    # 반복문 이용?
    # 3중 for -> 50C3
    
    for i in 0..nums.length-3
        for j in i+1..nums.length-2
            for k in j+1..nums.length-1
                answer+= (nums[i] + nums[j] + nums[k]).prime? ? 1 : 0
            end
        end
    end
    
    return answer
end