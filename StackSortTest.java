package tryCatch;


public class StackSortTest {
	
	
	public static void main(String[] args) throws Exception{
		
		Stack stack = new MyStack();
		
		stack.put(1);
		stack.put(3);
		stack.put(2);
		stack.put(4);
		stack.put(8);
		stack.put(7);
		stack.put(6);
		stack.put(5);
		
		
		sortStack2(stack);
		
		System.out.println("After Sort");
		System.out.println();
		
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}
	
	public static void sortStack2(Stack stack) throws Exception{
		
		if(stack == null){
			return;
		}
		
		if(stack.isEmpty()){
			return;
		}
		
		Stack tmp = new MyStack();
		
		while(!stack.isEmpty()){
			
			if(tmp.isEmpty()){
				tmp.put(stack.pop());
			}else{
				
				if(stack.peek() > tmp.peek()){
					tmp.put(stack.pop());
				}else{
					
					int num = stack.pop();
					
					while(!tmp.isEmpty()&&tmp.peek() > num){
						stack.put(tmp.pop());
					}
					
					tmp.put(num);
				}
			}
		}
		
		while(!tmp.isEmpty()){
			stack.put(tmp.pop());
		}
	}
	
	public static void sortStack(Stack stack) throws Exception{
		
		if(stack == null){
			return;
		}
		
		if(stack.isEmpty()){
			return;
		}
		
		
		Stack sortedStack = new MyStack();
		
		while(!stack.isEmpty()){
			
			int data = stack.pop();
			
			if(sortedStack.isEmpty()){
				
				sortedStack.put(data);
			}else{
				
				int curSortedStackData = sortedStack.peek();
				
				if(data > curSortedStackData){
					sortedStack.put(data);
				}else{
					
					Stack tmp = new MyStack();
					
					while(!sortedStack.isEmpty() && data < sortedStack.peek()){
						tmp.put(sortedStack.pop());
					}
					
					sortedStack.put(data);
					
					while(!tmp.isEmpty()){
						sortedStack.put(tmp.pop());
					}
					
				}
				
			}
		}
		
		
		while(!sortedStack.isEmpty()){
			stack.put(sortedStack.pop());
		}
		
		
	}
	
	
	

}

interface Stack{
	
	public void put(int data);
	
	public int pop() throws Exception;
	
	public int peek() throws Exception;
	
	public boolean isEmpty();
	
}

class MyStack implements Stack{
	
	Node head;
	
	@Override
	public void put(int data) {
		
		Node node = new Node(data);
		
		node.next = head;
		head = node;
	}
	

	@Override
	public int pop() throws Exception{
		
		if(isEmpty()){
			throw new Exception("stack empty");
		}
		
		Node node = head;
		
		head = head.next;
		
		return node.data;
	}
	

	@Override
	public int peek() throws Exception {
		if(isEmpty()){
			throw new Exception("stack empty");
		}
		
		return head.data;
	}


	@Override
	public boolean isEmpty() {
		return head == null;
	}


	class Node{
		Node next;
		int data;
		
		public Node(int data){
			this.data = data;
		}
	}
	
	
}
