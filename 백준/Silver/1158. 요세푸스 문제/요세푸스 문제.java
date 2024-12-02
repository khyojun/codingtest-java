import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = bufferReader.readLine();
        String[] split = s.split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);
        List<Integer> list = new ArrayList<>();
        IntStream.rangeClosed(1, n).forEach(list::add);
        Queue<Integer> queue = new LinkedList<>();
        int listIdx = 0;
        int cnt = 1;
        while (!list.isEmpty()) {
            if (listIdx >= list.size()) {
                listIdx = 0;
            }
            if (cnt % k == 0) {
                queue.offer(list.get(listIdx));
                list.remove(list.get(listIdx));
                listIdx--;
            }
            cnt++;
            listIdx++;
        }
        String collect = queue.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "<", ">"));
        bw.write(collect);
        bw.flush();
    }
}