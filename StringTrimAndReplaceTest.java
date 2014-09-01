package tryCatch;

import java.util.Scanner;

public class StringTrimAndReplaceTest {
	
	public static void main(String[] args) {
		
		/*Scanner scanner = new Scanner(System.in);
		
		String inputStr = scanner.nextLine();*/
		
		String inputStr = "Mr John Smith    ";
		
		char[] chrArr = inputStr.toCharArray();
		
		trimAndReplaceString2(chrArr);
		
		for(char k : chrArr){
			System.out.print(k);
		}
		
	}
	
	public static void trimAndReplaceString2(char[] chrArr){
		
		int i = 0;
		
		while(i < chrArr.length){
			
			if(chrArr[i] == ' '){
				
				chrArr[i] = '%';
				
				int j = chrArr.length - 3;
				
				while(j > i){
					chrArr[j + 2] = chrArr[j];
			
					j--;
				}
				
				chrArr[i + 1] = '2';
				chrArr[i + 2] = '0';
				
				i = i + 3;
			}else{
				i++;
			}
		}
		
	}
	
	
	public static void trimAndReplaceString(String str){
		
		int spaceCnt = 0;
		
		char[] chrArr = str.toCharArray();
		
		for(int i = 0; i < chrArr.length; i++){
			if(chrArr[i] == ' ')
				spaceCnt++;
		}
		
		int newLength = chrArr.length - 1;
		
		for(int i = chrArr.length - 1; i >= 0; i--){
			
			if(chrArr[i] == ' '){
				chrArr[newLength - 1] = '0';
				chrArr[newLength - 2] = '2';
				chrArr[newLength - 3] = '%';
				newLength = newLength - 3;
			}else{
				chrArr[newLength - 1] = chrArr[i];
				newLength = newLength - 1;
			}
			
		}
		
	}

}
