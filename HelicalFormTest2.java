package tryCatch;

import java.util.Scanner;

public class HelicalFormTest2 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int input = scanner.nextInt();
		
		int[][] matrix = makeHelicalFormMatrix(input);
		
		for(int[] row : matrix){
			for(int val : row){
				System.out.print(val + " ");
			}
			System.out.println();
		}
		
	}
	
	public static int[][] makeHelicalFormMatrix(int size){
		
		int[][] matrix = makeMatrix(size);
		
		fillHelicalForm(matrix);
		
		return matrix;
	}
	
	private static int[][] makeMatrix(int size){
		
		int[][] matrix = new int[size][size];
		
		return matrix;
	}
	
	private static void fillHelicalForm(int[][] matrix){
		
		int n = matrix.length , x = 1, y = 0, val = 0, size = 1;
		
		if(n%2 == 0){
			x = n/2;
			y = n/2 - 1;
		}else{
			x = n/2;
			y = n/2;
		}
		
		matrix[x][y] = val++;
		
		while(n*n > val){
		
			int sizeX = size;
			while (sizeX > 0 && n*n > val) {
				y = y + 1;
				matrix[x][y] = val++;
				sizeX--;
			}
			
			int sizeY = size;
			while (sizeY > 0  && n*n > val) {
				x = x - 1;
				matrix[x][y] = val++;
				sizeY--;
			}

			sizeX = ++size;
			while (sizeX > 0  && n*n > val) {
				y = y - 1;
				matrix[x][y] = val++;
				sizeX--;
			}

			sizeY = size;

			while (sizeY > 0  && n*n > val) {
				x = x + 1;
				matrix[x][y] = val++;
				sizeY--;
			}

			size++;

		}
		
		
	}
	
}
