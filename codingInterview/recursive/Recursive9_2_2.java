package tryCatch.codingInterview.recursive;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Recursive9_2_2 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("m : ");
		int m = Integer.parseInt(scanner.next());
		
		System.out.print("n : ");
		int n = Integer.parseInt(scanner.next());
		
		int[][] matrix = new int[m][n];
		matrix[1][0] = 1;
		matrix[2][1] = 1;
		
		for(int i = 0, len = matrix.length; i < len; i++){
			for(int j = 0, len2 = matrix[i].length; j < len2; j++){
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
		
		int count = getWayCount2(matrix);
		
		System.out.println(count);
		
	}
	
	
	public static int getWayCount2(int[][] matrix){
		return getWayCount2(matrix, matrix.length - 1, matrix[0].length - 1, new HashMap<String, Integer>());	
	}
	
	/*
	 * Top-Down
	 */
	private static int getWayCount2(int[][] matrix, int i, int j, Map<String, Integer> map){
		
		System.out.println(map);
		
		if(map.containsKey("" + i + j)){
			return map.get("" + i + j).intValue();
		}else{
			
			if(i == 0 && j ==0){
				return 1;
			}
			
			int cnt = 0;
			
			/*if((i > 0 && j == 0) && matrix[i - 1][j] != 1){
				cnt = getWayCount2(matrix, i - 1, j, map);
			}
			
			if((i ==0 && j > 0) && matrix[i][j - 1] != 1){
				cnt = getWayCount2(matrix, i, j - 1, map);
			}*/
			
			/*if((i >= 1 && j >= 1)){
				if(matrix[i - 1][j] != 1 && matrix[i][j - 1] == 1){
					cnt = getWayCount2(matrix, i - 1, j, map);
				}else if(matrix[i][j - 1] != 1 && matrix[i - 1][j] == 1){
					cnt = getWayCount2(matrix, i, j - 1, map);
				}else if(matrix[i][j - 1] != 1 && matrix[i - 1][j] != 1){
					cnt = getWayCount2(matrix, i - 1, j, map) + getWayCount2(matrix, i, j - 1, map);
				}
			}
			*/
			
			if(i >= 1 && matrix[i - 1][j] != 1){
				cnt += getWayCount2(matrix, i - 1, j, map);
			}
			
			if(j >= 1 && matrix[i][j - 1] != 1){
				cnt += getWayCount2(matrix, i, j - 1, map);
			}
			
			map.put("" + i + j, cnt);
			
			return cnt;
			
		}
	}
	
	
	public static int getWayCount3(int[][] matrix){
		return getWayCount3(matrix, matrix.length - 1, matrix[0].length - 1);	
	}
	
	/*
	 * Bottom-Up
	 */
	private static int getWayCount3(int[][] matrix, int i, int j){
		
		int[][] c = new int[matrix.length][matrix[0].length];
		
		boolean canStep = true;
		
		for(int k = 1, len = c[0].length; k < len; k++){
			
			if(matrix[0][k] == 1 || !canStep){
				c[0][k] = 0;
				canStep = false;
			}else{
				c[0][k] = 1;
			}
			
		}
		
		canStep = true;
		
		for(int k = 1, len = c.length; k < len; k++){
			
			if(matrix[k][0] == 1 || !canStep){
				c[k][0] = 0;
				canStep = false;
			}else{
				c[k][0] = 1;
			}
		}
		
		for(int k = 1, len = c.length; k < len; k++){
			for(int l = 1, len2 = c[k].length; l < len2; l++){
				if(matrix[k][l] != 1){
					c[k][l] = c[k - 1][l] + c[k][l - 1];
				}
				
				
			}
		}
		
		return c[i][j];
	}

}
