package tryCatch;

import java.util.Scanner;

public class StringDecodeTest {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int input = scanner.nextInt();
		
		System.out.println(decodeString(input));
		
	}
	
	public static String decodeString(int number){
		
		String[] alphabets = {"", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p"
							, "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		
		String result = "";
		
		int cpNum = number;
		
		int period = 26;
		
		while(cpNum > 0){
			
			int rest = cpNum%period;
			
			cpNum = cpNum/period;
			
			if(rest == 0 && cpNum > 0){
				while(cpNum > 0){
					result += alphabets[period];
					cpNum--;
				}
				break;
			}
			
			result = alphabets[rest] + result;
		}
		
		
		return result;
	}

}

