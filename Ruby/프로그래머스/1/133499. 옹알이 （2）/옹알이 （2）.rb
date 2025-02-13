def babbling_check(babbling, i,index, duplicate_hash)

  # print "babbling : #{babbling}\n"
  while index <= babbling.size
    # print "now index #{index} duplicate_hash : #{duplicate_hash}\n"
    if babbling[index] =='a'
      duplicate_hash.select{|k,v| k!= "aya"}
      .map{|k,v| duplicate_hash[k]=false}
      
      if duplicate_hash["aya"] == true
        break
      end

      if babbling[index..index+2] != "aya" 
        break
      end
      index += 3
      duplicate_hash["aya"]=true
    elsif babbling[index] =='y'
      duplicate_hash.select{|k,v| k!= "ye"}
      .map{|k,v| duplicate_hash[k]=false}
      if duplicate_hash["ye"] == true
        break
      end
      if babbling[index..index+1] != "ye" 
        break
      end
      index += 2
      duplicate_hash["ye"]=true
    elsif babbling[index] =='w'
      duplicate_hash.select{|k,v| k!= "woo"}
      .map{|k,v| duplicate_hash[k]=false}
      if duplicate_hash["woo"] == true
        break
      end
      if babbling[index..index+2] != "woo" 
        break
      end
      index += 3
      duplicate_hash["woo"]=true
    elsif babbling[index] =='m'
      duplicate_hash.select{|k,v| k!= "ma"}
      .map{|k,v| duplicate_hash[k]=false}
      if duplicate_hash["ma"] ==true
        break
      end
      if babbling[index..index+1] != "ma" 
        break
      end
      index += 2
      duplicate_hash["ma"]=true
    else
      break
    end
  end

  # print "final result  #{index}"
  return index
end

def solution(babbling)
  answer = 0
  # 옹알이 하는데 정해진 aya, ye, woo,ma
  # 위 단어가 연속해서 나오면은 안된다. 조합해서만 나올수 있다.
  
  # 연속나온거 검증할 친구
  # 지금 이 친구 
  babble = ["aya", "ye", "woo", "ma"]
  duplicate_hash = Hash.new(false)
  babble.each{
    |b|
    duplicate_hash[b] = false
  }
  babbling.each_with_index{
    |b, i|
    index =0

    # 중복된거 어떻게 제거할 건지 중요!
    duplicate_hash.map{
      |k,v|
      duplicate_hash[k]=false
    }
    index = babbling_check(b, i,0, duplicate_hash)
    if index >= b.size
      answer+=1
    end
    # print "answer #{answer}\n"

  }


 


  
  return answer
end


