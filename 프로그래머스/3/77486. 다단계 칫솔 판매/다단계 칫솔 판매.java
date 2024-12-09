import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        //int[] answer = {};
        
        // 돈 벌어도 부모님께 계속 가면서 10퍼센트씩 떼쭤야함!
        // 해당 키의 자식들 누군지 적기
        // 작대기는 center라고 침!
        // key 자식 value 어머니 통칭 -> 재귀적으로 계속 올라가서 전달 하는 과정 진행
        HashMap<String, UserInfo> map = new HashMap<>();
        
        for(int i=0; i<enroll.length; i++){
            map.put(enroll[i], new UserInfo(referral[i],0));
        }
        
        for(int i=0; i<seller.length; i++){
            int price = amount[i]*100;
            successMoney(seller[i],map,price);
        }
        
        List<Integer> answer = new ArrayList<>();
        for(int i=0; i<enroll.length; i++){
            answer.add(map.get(enroll[i]).getPrice());
        }        
        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    void successMoney(String nowPeople, Map<String, UserInfo> map, int price){
        if(nowPeople.equals("-"))
            return;
    
         int percentMoney= price / 10;
         int nowMoney= (int) price - percentMoney;
         UserInfo hello =map.get(nowPeople);
         hello.addPrice(nowMoney);
         if(hello.getParent().equals("-") || percentMoney==0)
             return;
         successMoney(hello.getParent(), map, percentMoney);
    }
    
    
    
    static class UserInfo{
        private String parent;
        private int price;
        
        public UserInfo(String parent, int price){
            this.parent = parent;
            this.price = price;
        }
        
        public void addPrice(int price){
            this.price += price;
        }
        
        public int getPrice(){
            return this.price;
        }
        
        public String getParent(){
            return this.parent;
        }
        
        
    }
}