/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
	
	class Ingredient{
		int protein;
		int fat;
		int carbohydrate;
		int vitamin;
		int cost;
		
		public Ingredient(int protein, int fat, int carbohydrate, int vitamin, int cost){
			this.protein = protein;
			this.fat = fat;
			this.carbohydrate = carbohydrate;
			this.vitamin = vitamin;
			this.cost = cost;
		}
	}
	
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, min[] = new int [4], res = Integer.MAX_VALUE;
	static Map<Integer, Ingredient> ingredients = new HashMap<Integer, Ingredient>();
	static List<Integer> currChoosed = new ArrayList<Integer>();
	static List<Integer> resIngredient = new ArrayList<Integer>();
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			min[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int protein = Integer.parseInt(st.nextToken());
			int fat = Integer.parseInt(st.nextToken());
			int carbohydrate = Integer.parseInt(st.nextToken());
			int vitamin = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			ingredients.put(i, new Ingredient(protein, fat, carbohydrate, vitamin, cost));
		}
		
		dfs(0, 0, 0, 0, 0, 0);
		
		if(res == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}

		System.out.println(res);
		for(int i=0; i<resIngredient.size(); i++) {
			System.out.print(resIngredient.get(i) + 1 + " " );
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private void dfs(int depth, int sumProtein, int sumFat, int sumCarbo, int sumVitamin, int sumCost) {
		if(sumCost > res) return;
		
		if(sumProtein >= min[0] && sumFat >= min[1] && sumCarbo >= min[2] && sumVitamin >= min[3]) {
			if(res > sumCost) {
				res = sumCost;
				resIngredient = new ArrayList<Integer>(currChoosed);
			}
			return;
		}
		
		if(depth >= N) return;
		
		currChoosed.add(depth);
		Ingredient ingredient = ingredients.get(depth);
		dfs(depth + 1,
			sumProtein + ingredient.protein,
			sumFat + ingredient.fat,
			sumCarbo + ingredient.carbohydrate,
			sumVitamin + ingredient.vitamin,
			sumCost + ingredient.cost);
		
		currChoosed.remove(Integer.valueOf(depth));
		
		dfs(depth +1, sumProtein, sumFat, sumCarbo, sumVitamin, sumCost);
	}
}