import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        for(int i=0; i<record.length; i++){
            String[] splitRecord = record[i].split(" ");
            String cmd=splitRecord[0];
            String id = splitRecord[1];
            if(cmd.equals("Enter")){
                String nickname = splitRecord[2];
                result.add(cmd + " " + id);
                map.put(id, nickname);
            }
            else if(cmd.equals("Leave")){
                result.add(cmd + " " + id);
            }
            else if(cmd.equals("Change")){
                String nickname = splitRecord[2];
                map.put(id, nickname);
            } 
        }
        List<String> answer = new ArrayList<>();
        for(int i=0; i<result.size(); i++){
            String[] nowMsgSplitted = result.get(i).split(" ");
            String cmd=nowMsgSplitted[0];
            String name=map.get(nowMsgSplitted[1]);
            String msg=null;
            if(cmd.equals("Enter"))
                msg = "님이 들어왔습니다.";
            else if(cmd.equals("Leave"))
                msg = "님이 나갔습니다.";
            answer.add(name+msg);

        }
        
        
        return answer.toArray(String[]::new);
    }
}