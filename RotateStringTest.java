package tryCatch;

import java.util.Scanner;

public class RotateStringTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String input = scanner.next();

		String input2 = scanner.next();

		System.out.println(isSubString(input, input2));

	}

	public static boolean isSubString(String s1, String s2) {
		

		char[] s1ChrArr = s1.toCharArray();
		char[] s2ChrArr = s2.toCharArray();

		char base = s1ChrArr[0];

		for (int i = 0; i < s2ChrArr.length; i++) {

			if (base == s2ChrArr[i]) {
				
				boolean isRight = true;
				
				for (int j = 0; j < s1ChrArr.length; j++) {
					
					if (s1ChrArr[j] != s2ChrArr[(i + j) % s2ChrArr.length]) {
						
						isRight = false;
						break;
					}
				}
				
				if(isRight == true){
					return isRight;
				}

			}

			

		}
		
		return false;
	}

}
