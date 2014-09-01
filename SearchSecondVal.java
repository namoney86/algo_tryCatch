package tryCatch;

/*정수의 배열에서 두번째로 큰 숫자를 출력한다.
 정수의 배열에서 두번째로 큰 숫자를 출력하는 프로그램을 작성하라.
 Time Limit : 200ms, Memory Limit : 512kb
 10개 미만의 자연수로 이루어진 배열
 입력 샘플
 9 5 2 7 7 8
 입력된 자연수 배열 내에서 두번째로 큰 자연수를 출력한다. (두번째로 큰 자연수가 여러개 존재하더라도 1번만 출력한다.)
 출력 샘플
 8*/
public class SearchSecondVal {

	public static void main(String[] args) {

		/*int[] nums = { 9, 5, 2, 7, 7, 8 };

		try {

			int result = searchSecondNum(nums);

			System.out.println(result);

		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		
		int[] nums = { 20, 7, 11, 9, 12, 18, 10};
		
		int t = partition(nums, 0, nums.length - 1);

		System.out.println(t);
		
		int[] nums2 = { 20, 7, 11, 9, 12, 18, 10};
		
		t = partition2(nums2, 0, nums2.length - 1);

		System.out.println(t);
	}

	public static int searchSecondNum(int[] nums) throws Exception {

		if (nums == null || nums.length < 2){
			throw new Exception();
		}
			
		return searchSecondNum(nums, 0, nums.length - 1, nums.length - 1);
	}

	private static int searchSecondNum(int[] nums, int p, int r, int i) {

		if (p == r) {
			return nums[p];
		}

		int q = partition(nums, p, r);

		int k = q - p + 1;

		if (i < k) {
			return searchSecondNum(nums, p, q - 1, i);
		} else if (i == k) {
			return nums[q];
		} else {
			return searchSecondNum(nums, q + 1, r, i - k);
		}
	}

	private static int partition(int[] nums, int p, int r) {

		int pivot = nums[r];
		int i = p - 1;

		for (int j = p; j < r; j++) {
			if (nums[j] <= pivot) {
				swap(nums, ++i, j);
			}
		}

		swap(nums, i + 1, r);
		
		for(int t : nums){
			System.out.print(t + " ");
		}
		
		System.out.println();
		
		return i + 1;
	}
	
	private static int partition2(int[] nums, int left, int right){
		
		int pivot = nums[(left + right)/2];

		while(left <= right){
			
			while(nums[left] < pivot){
				left++;
			}
				
			
			while(nums[right] > pivot)
				right--;
				
				
			if(left <= right){
				swap(nums, left, right);
				left++;
				right--;
			}
		}
		
		for(int t : nums){
			System.out.print(t + " ");
		}
		
		return left;
	}
	
	private static void swap(int[] nums, int i, int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	
}