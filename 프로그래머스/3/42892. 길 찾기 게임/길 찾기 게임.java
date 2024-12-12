import java.util.*;
import java.util.stream.Collectors;
import java.lang.*;

class Solution {
    
    static List<Integer> recordPost = new ArrayList<>();
    static List<Integer> recordPre = new ArrayList<>();
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};
        
        List<NInfo> nInfos = new ArrayList<>();
        // 트리를 그리기 위한 정보를 정리해야함
        for(int i=0; i<nodeinfo.length; i++){
            nInfos.add(new NInfo(nodeinfo[i][0], nodeinfo[i][1], i+1));
        }

        List<NInfo> sortedNInfos = nInfos.stream().sorted(Comparator.comparing(NInfo::getY, Comparator.reverseOrder()).thenComparing(Comparator.comparing(NInfo::getX))).collect(Collectors.toList());
        
        
        
        // 트리를 그려야함!
        Node root = new Node(sortedNInfos.get(0));
        for(int i=1; i<sortedNInfos.size(); i++){
            root.drawTree(root, sortedNInfos.get(i));
        }
        
        // 전위 후위 순회를 돌 수 있도록 해야함!
        
        root.postOrder(root);
        root.preOrder(root);
        
        return new int[][] {recordPost.stream().mapToInt(Integer::intValue).toArray(), recordPre.stream().mapToInt(Integer::intValue).toArray()};
    }
    
    
    static class Node{
        NInfo node;
        Node left;
        Node right;
        
        public Node(NInfo node){
            this.node=node;
        }
        
        
        public void postOrder(Node root){
            if(root==null){
                return;
            }
            recordPost.add(root.node.getNumber());
            postOrder(root.left);
            postOrder(root.right);
        }
        
        public void preOrder(Node root){
            if(root==null){
                return;
            }
            preOrder(root.left);
            preOrder(root.right);
            recordPre.add(root.node.getNumber());
        }
        
        
        public void drawTree(Node root, NInfo now){
            Node nowNode=new Node(now);
            if(root.node.getX()<now.getX()){
                if(root.right==null){
                    addRight(root, nowNode);
                    return;
                }
                drawTree(root.right, now);
            }    
            else{
                if(root.left==null){
                    addLeft(root, nowNode);
                    return;
                }
                drawTree(root.left, now);
            }
        }
        
        public void addLeft(Node root, Node left){
            root.left=left;
        }
        
        public void addRight(Node root, Node right){
            root.right=right;
        }
        
        
        
    }
    
    
    static class NInfo{
        private int x;
        private int y;
        private int number;
        
        public NInfo(int x, int y, int number){
            this.x=x;
            this.y=y;
            this.number=number;
        }
        
        public int getX(){
            return this.x;
        }
        
        public int getY(){
            return this.y;
        }
        
        public int getNumber(){
            return this.number;
        }
        
        @Override
        public String toString(){
            return "x:" + this.x + " y:" + this.y + " node:" + this.number;
        }
        
    }
    
    
    
    
}