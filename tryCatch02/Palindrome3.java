package tryCatch.tryCatch02;


/*
 * 
 * 회문 판별
정수가 입력되었을때, 이 정수가 회문이면 TRUE, 회문이 아니면 FALSE를 출력하는 프로그램을 작성하라.(회문이란 거꾸로 읽어도 똑같은 단어를 말한다. 예를들면 madam, nurses run, lion oil, mad as adam과 같은 문자열들이 있다.)

정수 A (1≤A≤10000)
입력 샘플
12345 
24542 
12321

TRUE or FALSE 출력

출력 샘플
FALSE 
TRUE 
TRUE
 * 
 * 
 */

public class Palindrome3 {
	
	public static void main(String[] args) {
		
		
		int input = 12321;
		
		System.out.println(isPalindrome(input));
		
	}
	
	public static boolean isPalindrome(int number){
		
		int reverseNum = 0;
		
		int rest = number, share = 0;
		
		while(rest > 0){
			
			share = rest%10;

			reverseNum = reverseNum*10 + share;
			
			rest = rest/10;
		}
		
		return reverseNum == number;
	}
}
