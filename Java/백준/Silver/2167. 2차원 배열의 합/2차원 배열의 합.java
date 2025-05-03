import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		

		int[][] arr = new int[n + 2][m + 2];
		int[][] sum = new int[n + 2][m + 2];

		for(int i=1; i<=n; i++){
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			int size = st2.countTokens();
			for(int j=1; j<=size; j++){
				arr[i][j] = Integer.parseInt(st2.nextToken());
			}
		}

		for(int i=1; i<=n; i++){
			for(int j=1; j<=m; j++){
				sum[i][j] = arr[i][j] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
			}
		}

		int k = Integer.parseInt(br.readLine());

		for(int i=1; i<=k; i++){
			StringTokenizer stPoint = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(stPoint.nextToken());
			int y = Integer.parseInt(stPoint.nextToken());
			int x2 = Integer.parseInt(stPoint.nextToken());
			int y2 = Integer.parseInt(stPoint.nextToken());

			System.out.println(sum[x2][y2] - sum[x2][y-1] - sum[x-1][y2] + sum[x-1][y-1]);
		}



	}
}