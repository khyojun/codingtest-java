
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		List<Integer> point = new ArrayList<>();
		for(int i=0; i<n; i++){
			point.add(Integer.parseInt(st.nextToken()));
		}

		List<Integer> sortedPointList = point.stream().sorted().collect(Collectors.toList());
		List<Integer> distance = new ArrayList<>();


		for(int i=1; i<sortedPointList.size(); i++){
			distance.add(sortedPointList.get(i) - sortedPointList.get(i-1));
		}

		List<Integer> sortedDistance = distance.stream().sorted().collect(Collectors.toList());

		int result =0;
		int realAddSize = sortedDistance.size()- (k-1);
		for(int i=0; i<realAddSize; i++) {
			result += sortedDistance.get(i);
		}
		System.out.println(result);





	}
}