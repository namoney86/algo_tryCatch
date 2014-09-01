package tryCatch.codingInterview.recursive;

import java.util.HashMap;
import java.util.Map;

public class StairUp_9_1 {
	
	public static void main(String[] args) {

		int count = getStairUpWayCount2(5);

		System.out.println(count);

		int count2 = getStairUpWayCount3(4, new HashMap<Integer, Integer>());

		System.out.println(count2);
		
	}
	
	public static int getStairUpWayCount(int stairCount){
	
		if(stairCount == 0){
			return 1;
		}else if(stairCount < 0){
			return 0;
		}else{
			return getStairUpWayCount(stairCount - 1) + getStairUpWayCount(stairCount - 2) + getStairUpWayCount(stairCount - 3);
		}
	}
	
	public static int getStairUpWayCount2(int stairCount){
		
		if(stairCount == 0){
			return 1;
		}else if(stairCount < 0){
			return 0;
		}else{
			
			int[] c = new int[stairCount];			
			
			c[0] = 1;
			c[1] = 2;
			c[2] = 4;
			
			
			for (int i = 3; i < stairCount; i++) {
				c[i] = c[i - 1] + c[i - 2] + c[i - 3];
			}
			return c[stairCount - 1];
		}
	}
	
	public static int getStairUpWayCount3(int n, Map<Integer, Integer> map){
		
		if(map.containsKey(n)){
			return map.get(n).intValue();
		}
		
		if(n == 0){
			return 1;
		}else if(n < 0){
			return 0;
		}else{

			int cnt = getStairUpWayCount3(n - 1, map) + getStairUpWayCount3(n - 2, map) + getStairUpWayCount3(n - 3, map);
			
			map.put(n, cnt);
			
			return cnt;
		}
		
	}
}
