import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        //1. 가장 많이 재생된 장르
        // 2. 장르 내 많이 재생된 노래 수록
        // 3. 장르 내 재생 횟수 같으면 고유 번호 낮은 노래 수록
        // 장르별 재생 횟수는 다름
        HashMap<GenreInfo, Integer> map = new HashMap<>();
        HashMap<String, Integer> sumMap = new HashMap<>();
        
        for(int i=0; i<genres.length; i++){
            map.put(new GenreInfo(genres[i],i),plays[i]);
            if(sumMap.get(genres[i])==null){
                sumMap.put(genres[i], plays[i]);    
                continue;
            }
            sumMap.put(genres[i], sumMap.get(genres[i])+plays[i]);
        }
        
        //System.out.println(map);
        
        List<String> key=sumMap.entrySet().stream()
            .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder())).map(Map.Entry::getKey).collect(Collectors.toList());
        
        
        //System.out.println(key);
        List<Integer> result = new ArrayList<>();
        
        for(int i=0; i<key.size(); i++){
            final int index = i;
            map.entrySet().stream()
            .filter(m -> m.getKey().getGenre().equals(key.get(index)))
            .sorted(Comparator.comparing(m -> m.getValue(), Comparator.reverseOrder()))
            .map(m->m.getKey().getIndex())
            .limit(2)
            .forEach((str) -> result.add(str));
        }
        
        //System.out.println(result);
        
        
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    static class GenreInfo{
        private String genre;
        private int index;
        
        
        public GenreInfo(String genre, int index){
            this.genre=genre;
            this.index = index;
        }
        
        public int getIndex(){
            return this.index;
        }
        public String getGenre(){
            return this.genre;
        }
        
    }
    
}