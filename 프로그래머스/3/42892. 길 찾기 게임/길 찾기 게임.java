import java.util.*;
import java.util.stream.Collectors;
import java.lang.*;
class Solution {
    
    static List<Integer> preArr = new ArrayList<>();
    static List<Integer> postArr = new ArrayList<>();
    
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};
        
        // node 정보 입력
        // 트리 그리기
        // 돌고 끝!
        
        //node 정보 입력
        List<NodeInfo> arr = new ArrayList<>();
        for(int i=0; i<nodeinfo.length; i++){
            arr.add(new NodeInfo(nodeinfo[i][0], nodeinfo[i][1], i+1));
        }
        
        List<NodeInfo> sortedArr=arr.stream().sorted(Comparator.comparing(NodeInfo::getY, Comparator.reverseOrder()).thenComparing(NodeInfo::getX)).collect(Collectors.toList());
        
        // 트리 만들기 -> x위치 보고 만들기
        
        NodeInfo rootInfo = sortedArr.get(0);
        Node root = new Node(rootInfo);
        for(int i=1; i<sortedArr.size(); i++){
            NodeInfo nowNodeInfo=sortedArr.get(i);
            Node newNode = new Node(nowNodeInfo);
            madeTree(root, newNode);
        }
        
        
        root.preOrder(root);
        root.postOrder(root);
        
        
        int[][] answers = new int[2][];
        answers[0] = preArr.stream().mapToInt(Integer::intValue).toArray();
        answers[1] = postArr.stream().mapToInt(Integer::intValue).toArray();
        
        
        return answers;
    }
    
    void madeTree(Node root, Node nowNode){
        if(root.nowNode().x > nowNode.nowNode().x){
            if(root.getLeft()==null){
                root.addLeftNode(nowNode);
            }
            else{
                madeTree(root.getLeft(), nowNode);
            }
        }else{
            if(root.getRight()==null){
                root.addRightNode(nowNode);
            }
            else{
                madeTree(root.getRight(), nowNode);
            }
        }
    }
    
    
    
    
    static class NodeInfo{
        int x;
        int y;
        int idx;
        
        
        public NodeInfo(int x, int y, int idx){
            this.x=x;
            this.y=y;
            this.idx=idx;
        }
        
        public int getX(){
            return this.x;
        }
        public int getY(){
            return this.y;
        }
        public int getIdx(){
            return this.idx;
        }
        
        
        
        
        @Override
        public String toString(){
            return "This x : " + this.x + " This y : " + this.y;
        }
        
        
    }

    
    
    static class Node{
        private NodeInfo idx;
        private Node left;
        private Node right;
        
        public Node(NodeInfo idx){
            this.idx=idx;
        }
        
        
        public void addLeftNode(Node left){
            this.left=left;
        }
        
        public void addRightNode(Node right){
            this.right=right;
        }
        
        
        public Node getLeft(){
            return this.left;
        }
        public Node getRight(){
            return this.right;
        }
        public NodeInfo nowNode(){
            return idx;
        }
        
        public void preOrder(Node root){
            if(root == null){
                return;
            }
            preArr.add(root.nowNode().getIdx());
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
        
        public void postOrder(Node root){
            if(root == null){
                return;
            }
            postOrder(root.getLeft());
            postOrder(root.getRight());
            postArr.add(root.nowNode().getIdx());
        }
        
        
        
    }
}