import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		List<Integer> arr = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		arr.add(0);
		for(int i=1; i<=n; i++){
			 arr.add(Integer.parseInt(st.nextToken()) + arr.get(i-1));
		}

		int m = Integer.parseInt(br.readLine());

		for(int i=0; i<m; i++){
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st2.nextToken());
			int end = Integer.parseInt(st2.nextToken());

			System.out.println(arr.get(end) - arr.get(start-1));
		}
		
	}
}