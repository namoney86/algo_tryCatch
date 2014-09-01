package tryCatch.codingInterview.recursive;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Recursive9_2 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("m : ");
		int m = Integer.parseInt(scanner.next());
		
		System.out.print("n : ");
		int n = Integer.parseInt(scanner.next());
		
		int[][] matrix = new int[m][n];
		
		int count = getWayCount3(matrix);
		
		System.out.println(count);
		
	}
	
	public static int getWayCount(int[][] matrix){
		
		return getWayCount(matrix, matrix.length - 1, matrix[0].length - 1);
	}
	
	private static int getWayCount(int[][] matrix, int i, int j){
		
		if(i == 0 && j == 0){
			return 0;
		}else if(i == 0 && j != 0){
			return 1;
		}else if(i != 0 && j == 0){
			return 1;
		}else{
			return getWayCount(matrix, i - 1 , j) + getWayCount(matrix, i , j - 1);
		}
	}
	
	public static int getWayCount2(int[][] matrix){
		return getWayCount2(matrix, matrix.length - 1, matrix[0].length - 1, new HashMap<String, Integer>());	
	}
	
	private static int getWayCount2(int[][] matrix, int i, int j, Map<String, Integer> map){
		
		if(map.containsKey("" + i+j)){
			return map.get("" + i+j).intValue();
		}
		
		if(i == 0 && j == 0){
			return 0;
		}else if(i == 0 && j != 0){
			return 1;
		}else if(i != 0 && j == 0){
			return 1;
		}else{
			int count =  getWayCount2(matrix, i - 1 , j, map) + getWayCount2(matrix, i , j - 1, map);
			map.put("" + i + j, count);
			
			return count;
		
		}
	}
	
	
	public static int getWayCount3(int[][] matrix){
		return getWayCount3(matrix, matrix.length - 1, matrix[0].length - 1);	
	}
	
	private static int getWayCount3(int[][] matrix, int i, int j){
		
		int[][] c = new int[matrix.length][matrix[0].length];
		
		for(int k = 1, len = c.length; k < len; k++){
			c[0][k] = 1;
		}
		
		for(int k = 1, len = c[0].length; k < len; k++){
			c[k][0] = 1;
		}
		
		for(int k = 1, len = c.length; k < len; k++){
			for(int l = 1, len2 = c[k].length; l < len2; l++){
				c[k][l] = c[k - 1][l] + c[k][l - 1];
			}
		}
		
		return c[i][j];
	}

}
