package tryCatch;

public class ThreeStackByOneArrayTest {
	
	public static void main(String[] args) {
		
		ThreeStack threeStack = new ThreeStackImpl(5);
		
		threeStack.put(0, 5);
		threeStack.put(0, 4);
		threeStack.put(0, 3);
		threeStack.put(0, 2);
		
		threeStack.put(1, 11);
		threeStack.put(1, 22);
		threeStack.put(1, 33);
		threeStack.put(1, 44);
		
		threeStack.put(2, 111);
		threeStack.put(2, 222);
		
		
		threeStack.print();
		System.out.println();
		threeStack.printTops();
		
		
		threeStack.pop(0);
		threeStack.pop(1);
		threeStack.pop(2);
		
		System.out.println();
		System.out.println();
		threeStack.print();
		System.out.println();
		threeStack.printTops();
		
		System.out.println();
		
		threeStack.pop(0);
		threeStack.pop(1);
		threeStack.pop(2);
		
		System.out.println();
		System.out.println();
		threeStack.print();
		System.out.println();
		threeStack.printTops();
		
		threeStack.pop(0);
		threeStack.pop(1);
		threeStack.pop(2);
		
		System.out.println();
		System.out.println();
		threeStack.print();
		System.out.println();
		threeStack.printTops();
		
		threeStack.put(0, 3);
		threeStack.put(1, 33);
		threeStack.put(2, 111);
		
		System.out.println();
		System.out.println();
		threeStack.print();
		System.out.println();
		threeStack.printTops();
		
		threeStack.pop(0);
		threeStack.pop(1);
		threeStack.pop(2);
		
		System.out.println();
		System.out.println();
		threeStack.print();
		System.out.println();
		threeStack.printTops();
		
		threeStack.pop(0);
		threeStack.pop(1);
		threeStack.pop(2);
		
		System.out.println();
		System.out.println();
		threeStack.print();
		System.out.println();
		threeStack.printTops();
		
		threeStack.pop(0);
		threeStack.pop(1);
		threeStack.pop(2);
		
		System.out.println();
		System.out.println();
		threeStack.print();
		System.out.println();
		threeStack.printTops();
		
	}
 
}
 
interface ThreeStack{
	
	public void put(int stackNum, int value);
	
	public int pop(int stackNum);
	
	public void print();
	
	public void printTops();
	
}
 
class ThreeStackImpl implements ThreeStack{
 
	private int size;
	private int[] stacks;
	private int[] tops;
	
	public ThreeStackImpl(int size){
		this.size = size;
		this.stacks = new int[size*3];
		this.tops = new int[]{-1, -1, -1 };
	}
	
	public ThreeStackImpl(){
		this(100);
	}
	
	
	@Override
	public void put(int stackNum, int value) {
		
		if(tops[stackNum] >= this.size){
			System.out.println(stackNum + " 번째 스택이 꽉 찼습니다.");
			return;
		}
		
		tops[stackNum]++;
		
		int top = tops[stackNum] + this.size*stackNum;
		stacks[top] = value;
	}
 
	@Override
	public int pop(int stackNum) {
		
		if(tops[stackNum] <= -1){
			return 0;
		}
		
		int top = tops[stackNum] + stackNum*this.size; 
		
		tops[stackNum]--;
		
		int value = stacks[top];
		
		stacks[top] = 0;
		
		return value;
	}
 
	@Override
	public void print() {
		
		for(int k : stacks){
			System.out.print(k + " ");
		}
		
	}
	
	@Override
	public void printTops() {
		
		for(int k : tops){
			System.out.print(k + " ");
		}
		
	}
 
}