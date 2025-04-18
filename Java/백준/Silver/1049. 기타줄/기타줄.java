import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int minPackagePrice = Integer.MAX_VALUE;
		int minSinglePrice = Integer.MAX_VALUE;

		for(int i=0; i<k; i++){
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			int packagePrice = Integer.parseInt(st2.nextToken());
			int singlePrice = Integer.parseInt(st2.nextToken());
			if(packagePrice < minPackagePrice)
				minPackagePrice = packagePrice;
			if(singlePrice < minSinglePrice)
				minSinglePrice =singlePrice;
		}

		List<Integer> dp = new ArrayList<>();

		dp.add(0);
		for(int i=1; i<=n+6; i++){
			if(i<6)
				dp.add(dp.get(i - 1) + minSinglePrice);
			else
				dp.add(Math.min(dp.get(i-1)+ minSinglePrice, dp.get(i-6)+ minPackagePrice));
		}

		int resultMin = Integer.MAX_VALUE;
		for(int i=n; i<n+6; i++){
			if(resultMin > dp.get(i)){
				resultMin = dp.get(i);
			}
		}

		System.out.println(resultMin);

	}
}