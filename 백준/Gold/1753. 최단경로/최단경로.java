
import java.io.*;
import java.util.*;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int v, e;
        String[] split = br.readLine().split(" ");

        v = Integer.parseInt(split[0]);
        e = Integer.parseInt(split[1]);



        int startNode;

        startNode = Integer.parseInt(br.readLine());


        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        List<List<Node>> list = new ArrayList<>();

        int[] distance = new int[v + 1];
        for (int i = 1; i < v + 1; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        for(int i=1; i<v+2; i++){
            list.add(new ArrayList<>());
        }
        distance[startNode] = 0;


        for (int i = 0; i < e; i++) {
            int start, end, weight;
            String[] info = br.readLine().split(" ");

            start = Integer.parseInt(info[0]);
            end = Integer.parseInt(info[1]);
            weight = Integer.parseInt(info[2]);
            list.get(start).add(new Node(start, end, weight));
        }

        queue.offer(new Node(startNode, startNode, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if(distance[node.end]<node.weight)
                continue;
            for (Node connectNode : list.get(node.end)) {
              if (distance[connectNode.end] > distance[node.end] + connectNode.weight) {
                    distance[connectNode.end] = distance[node.end] + connectNode.weight;
                    queue.offer(new Node(connectNode.start, connectNode.end, distance[connectNode.end]));
                }
            }
        }


        for (int i = 1; i < v + 1; i++) {
            if (distance[i] == Integer.MAX_VALUE)
                bw.write("INF");
            else
                bw.write(String.valueOf(distance[i]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }


    static class Node {
        int start;
        int end;
        int weight;


        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

}