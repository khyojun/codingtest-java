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

		
		Map<Integer, Medal> scoreBoard = new HashMap<>();

		for(int i=0; i<n; i++){
			StringTokenizer stCountry = new StringTokenizer(br.readLine(), " ");

			int country = Integer.parseInt(stCountry.nextToken());
			int gold = Integer.parseInt(stCountry.nextToken());
			int silver = Integer.parseInt(stCountry.nextToken());
			int bronze  = Integer.parseInt(stCountry.nextToken());

			scoreBoard.put(country, new Medal(gold,silver,bronze));
		}

	
		int rank=n;
		Medal myMedal = scoreBoard.get(m);
		for(int key : scoreBoard.keySet()){
			if(key==m)
				continue;
			Medal nowMedal=scoreBoard.get(key);


			if(nowMedal.getGold() < myMedal.getGold())
				rank--;
			else if(nowMedal.getGold() == myMedal.getGold() && nowMedal.getSilver() < myMedal.getSilver())
				rank--;
			else if(nowMedal.getGold() == myMedal.getGold() && nowMedal.getSilver() == myMedal.getSilver() && nowMedal.getBronze() < myMedal.getBronze())
				rank--;
			else if(nowMedal.getGold() == myMedal.getGold() && nowMedal.getSilver() == myMedal.getSilver() && nowMedal.getBronze() == myMedal.getBronze())
				rank--;
		}

		System.out.println(rank);

	}

	static class Medal{
		int gold,silver,bronze;

		public Medal(int gold, int silver, int bronze){
			this.gold=gold;
			this.silver = silver;
			this.bronze = bronze;
		}

		public int getGold(){
			return gold;
		}

		public int getSilver(){
			return silver;
		}

		public int getBronze(){
			return bronze;
		}
	}
}