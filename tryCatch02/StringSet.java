package tryCatch.tryCatch02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringSet {
	
	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		
		String value = scanner.next();
		
		//List<String> result = makeStringSet(value.toCharArray());
		
		List<String> result = perm1(value);
		
		System.out.println(result);
		System.out.println(result.size());
		
	}
	
	
	
	public static List<String> perm1(String s) {

		List<String> result = new ArrayList<>();
		perm1("", s, result);
		
		return result;
	}

	public static void perm1(String prefix, String str, List<String> list){
		
		int len = str.length();
		
		if(len == 0){
			list.add(prefix);
			return;
		}
		
		for(int i = 0; i < len; i++){
			perm1(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1), list);
		}
	}
	
	
	
	
	/*public static void perm1(String s) {
		perm1("", s);
	}

	private static void perm1(String prefix, String s) {
		int N = s.length();
		if (N == 0)
			System.out.println(prefix);
		else {
			for (int i = 0; i < N; i++)
				perm1(prefix + s.charAt(i),
						s.substring(0, i) + s.substring(i + 1, N));
		}

	}
	
*/	public static void perm2(String str){
		
		perm2(str.toCharArray(), str.length());
		
		
	}
	
	private static void perm2(char[] list, int n){
		
		if(n == 1){
			for(int i = 0; i < list.length; i++){
				System.out.print(list[i]);
			}
			System.out.println();
			return;
		}
		
		for(int i = 0; i < n; i++){
			swap(list, i, n - 1);
			perm2(list, n - 1);
			swap(list, i, n - 1);
		}
		
		
	}
	
	private static void swap(char[] list, int i, int j){
		char tmp = list[i];
		list[i] = list[j];
		list[j] = tmp;
	}
	

	
	
	public static List<String> makeStringMultiSet(String value){
		
		List<String> list = new ArrayList<>();
		
		for(int i = 0; i < value.length(); i++){
			
			boolean[] bools = new boolean[value.length()];
			bools[i] = true;
			
			fillMultiStringToList(value, value.charAt(i) + "", list, bools);
			
		}
		
		return list;
	}
	
	
	
	public static void fillMultiStringToList(String original, String result, List<String> list, boolean[] bools){
		
		for(int i = 0; i < original.length(); i++){
			
			String newVal = result;
			
			String charAt = original.charAt(i) + "";
			
			if(!bools[i]){
				newVal += charAt;
				
				boolean[] newbools = new boolean[bools.length];
				
				System.arraycopy(bools, 0, newbools, 0, bools.length);
				
				newbools[i] = true;
				
				if(newVal.length() == original.length() && !list.contains(newVal)){
					list.add(newVal);
				}else{
					fillMultiStringToList(original, newVal, list, newbools);
				}
			}
		}
		
	}
	
}
