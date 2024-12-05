import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        
        //신고 횟수 제한 k번
        // report 어떻게 신고했는지
        // id_list 어떤 id를 가지고 있는지
        
        HashMap<String, Set<String>> map = new HashMap<>();
        HashMap<String, Integer> reportInfo = new HashMap<>();
        HashMap<String, Boolean> isReportMember = new HashMap<>();
        for(int i=0; i<id_list.length; i++){
            map.put(id_list[i], new HashSet<>());
            reportInfo.put(id_list[i], 0);
            isReportMember.put(id_list[i], false);
        }
        
        Set<String> reports = new HashSet<>(Arrays.asList(report)); // 중복 제거
        
        
        for(String msg : reports){
            String sender = msg.split(" ")[0];
            String receiver = msg.split(" ")[1];
            Set<String> sets=map.get(sender);
            sets.add(receiver);
            map.put(sender, sets);
            reportInfo.put(receiver, reportInfo.get(receiver)+1);
        }
        
        reportInfo.entrySet().stream()
            .filter(m -> m.getValue()>=k)
            .map(Map.Entry::getKey)
            .forEach(key -> isReportMember.put(key, true));
        
        List<Integer> answers = new ArrayList();
        for(int i=0; i<id_list.length; i++){
            String id=id_list[i];
            Set<String> list=map.get(id);
            int cnt=0;
            for(String reportedMember : list){
                if(isReportMember.get(reportedMember).equals(true))
                    cnt++;
            }
            answers.add(cnt);
        }
        //System.out.println(answers);
        
        return answers.stream().mapToInt(Integer::intValue).toArray();
    }
}