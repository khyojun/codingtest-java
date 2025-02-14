
def solution(n)
  answer=0
  is_prime = Array.new(n+1, true)
  is_prime[0]= false
  is_prime[1] = false

  for i in 2..Math.sqrt(n)
    if is_prime[i]
      j = i*i
      while j <=n
        is_prime[j] = false
        j+=i
      end
    end
  end

  for i in 2..n
    if is_prime[i]
      answer+=1
    end
  end
  answer

end



print solution(1000000)
