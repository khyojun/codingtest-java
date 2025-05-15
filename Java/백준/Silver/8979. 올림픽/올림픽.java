import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m =  Integer.parseInt(st.nextToken());

		// 금메달 수가 더 많은 나라
		// 금메달 수가 같으면, 은메달 수가 더 많은 나라
		// 금, 은메달 수가 모두 같으면, 동메달 수가 더 많은 나라

		Map<Integer, Integer> scoreBoard = new HashMap<>();

		for(int i=0; i<n; i++){
			StringTokenizer stCountry = new StringTokenizer(br.readLine(), " ");

			int country = Integer.parseInt(stCountry.nextToken());
			int gold = Integer.parseInt(stCountry.nextToken()) *5;
			int silver = Integer.parseInt(stCountry.nextToken()) *4;
			int bronze  = Integer.parseInt(stCountry.nextToken()) * 3;

			scoreBoard.put(country, gold+silver+bronze);
		}

		// 나라 점수 정렬해서 몇 등인지
		// 예외 케이스 공동

		int rank=n;
		for(int key : scoreBoard.keySet()){
			if(key==m)
				continue;
			if(scoreBoard.get(key) <= scoreBoard.get(m))
				rank--;
		}

		System.out.println(rank);

	}
}