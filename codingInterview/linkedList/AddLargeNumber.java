package tryCatch.codingInterview.linkedList;

import java.util.Stack;

public class AddLargeNumber {
	
	public static void main(String[] args) {
		
		
		CalcLargerNumber calcLargerNumber = new CalcLargerNumber();
		calcLargerNumber.addLargeNumber(10, 10);
		
		
		
	}
	
	

}

class CalcLargerNumber{
	
	
	public void addLargeNumber(int val, int val2){
		
		Node node = new Node(1);
		node.addNodeToTail(3);
		node.addNodeToTail(4);
		node.addNodeToTail(8);
		
		Node another = new Node(3);
		another.addNodeToTail(2);
		another.addNodeToTail(7);
		
		
		Node result = this.addLargeNumber(node, another);
		
		while(result != null){
			System.out.print(result);
			result = result.next;
		}
		
		
	}
	
	
	private Node addLargeNumber(Node numNode, Node anotherNode){
		
		if(numNode == null || anotherNode == null){
			return null;
		}
		
		Stack<Integer> numStack = new Stack<>();
		Stack<Integer> anotherStack = new Stack<>();
		
		Node r = numNode;
		Node anotherR = anotherNode;
		
		while(r != null || anotherR != null){
			
			if(r != null){
				numStack.add(r.value);
				r = r.next;
			}
			
			if(anotherR != null){
				anotherStack.add(anotherR.value);
				anotherR = anotherR.next;
			}
		}
		
		int sum = numStack.pop() + anotherStack.pop();
		
		int share = sum/10;
		int rest = sum%10;
		
		Node result = new Node(rest);
		
		while(!numStack.isEmpty() || !anotherStack.isEmpty()){
			
			sum = 0;
			
			if(!numStack.isEmpty()){
				sum += numStack.pop();
			}
			
			if(!anotherStack.isEmpty()){
				sum += anotherStack.pop();
			}
			
			if(share > 0){
				sum += share;
			}
			
			share = sum/10;
			rest = sum%10;

			result = result.addNodeToHead(rest);
		}
		
		return result;
	}
	
	
	
	private class Node{
		
		int value;
		Node next;
		
		public Node(int value){
			this.value = value;
			this.next = null;
		}
		
		public void addNodeToTail(int value){
			
			Node newNode = new Node(value);
			
			Node n = this;
			
			while(n.next != null){
				n = n.next;
			}
			
			n.next = newNode;
		}
		
		public Node addNodeToHead(int value){
			
			Node newNode = new Node(value);
			
			newNode.next = this;
			
			return newNode;
		}
		
		@Override
		public String toString() {
			return this.value + "";
		}
		
	}
	
}