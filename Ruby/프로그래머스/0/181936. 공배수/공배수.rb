
def gcd(n,m)
    r = 0
    while m!=0 do
        r = n%m
        n = m
        m = r
    end
    
    return n
end


def solution(number, n, m)
    # n의 배수이면서 m 의 배수?  최소 공배수
    minA = n*m / gcd(n,m)
    
    if number % minA==0
        return 1
    end
    return 0
end
    
    

