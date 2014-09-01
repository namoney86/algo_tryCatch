package tryCatch;

import java.util.Scanner;

public class ZipStringTest {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String input = scanner.next();
		
		System.out.println(zipString(input) );
	}
	
	public static String zipString(String str){
		String result = "";
		
		char[] chrArr = str.toCharArray();
		
		int cnt = 0;
		
		char chr = chrArr[0];
		
		for(int i = 0; i < chrArr.length; i++){
			
			if(chr == chrArr[i]){
				cnt++;
			}else{
				
				result += cnt + (chrArr[i - 1] + "");
				
				cnt = 1;
				
				chr = chrArr[i];
			}
		}
		
		return result + cnt + chr;
		
	}

}
