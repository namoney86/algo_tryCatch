package codingInterview.tripleSum;

import java.util.HashMap;
import java.util.Map;

public class TripleSum {
	
	public static void main(String[] args) {
		
		int[] vals = {5,2,7,-9,4,10,-8,0,-2,-1,8,1,4,11,-12,3, -7};
		
		
		printTripleSumUsingHashTable(vals);
		
	}
	
	
	public static void printTripleSumUsingHashTable(int[] vals){
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0, len = vals.length; i < len; i++){
			map.put(vals[i], vals[i]);
		}
		
		
		for(int i = 0, len = vals.length; i < len - 1; i++){
			
			for(int j = i + 1; j < len; j++){
				
				int somOfRest = vals[i] + vals[j];
				
				if(map.containsKey(-somOfRest)){
					
					int rest = map.get(-somOfRest);
					
					if((somOfRest + rest) == 0){
						System.out.println(vals[i] + " " + vals[j] + " " + rest);
					}
				}
			}
		}
	}
	
	
}
