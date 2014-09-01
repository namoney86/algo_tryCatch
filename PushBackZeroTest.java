package tryCatch;

import java.util.Scanner;

public class PushBackZeroTest {
	
	public static void main(String[] args){
		
		/*Scanner scanner = new Scanner(System.in);
		
		String str = scanner.next();
		
		scanner.close();
		*/
		
		String str = "1203004";
		
		String result = pushBackZero2(str);
		
		System.out.println(result);
		
	}
	
	public static String pushBackZero(String str){
		
		if(str == null || str.length() == 0){
			return "";
		}
		
		int cnt = 0;
		
		StringBuffer buffer = new StringBuffer();
		
		for(int i = 0; i < str.length(); i++){
			
			if(str.charAt(i) == '0'){
				cnt++;
			}else{
				buffer.append(str.charAt(i));
			}
		}
		
		for(int i = 0; i < cnt; i++){
			buffer.append(0);
		}
		
		return buffer.toString();
	}	
	
	
	public static String pushBackZero2(String str){
		
		char[] charArr = str.toCharArray();
		
		for(int i = 0, len = charArr.length; i < len; i++){
			
			char thisCh = charArr[i];
			
			if(thisCh == '0'){
				
				int k = i;
				
				System.out.println("before k : " + k);
				
				while(str.charAt(k) == '0'){
					k++;
				}
				
				System.out.println("after k : " + k);
				System.out.println("i : " + i);
				
				
				char tmp = charArr[i];
				charArr[i] = charArr[k];
				charArr[k] = tmp;
				
				System.out.println( new String(charArr));
				System.out.println();
			}
			
		}
		
		return new String(charArr);
	}
}
	
	
	
	
	
