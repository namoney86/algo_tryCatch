package tryCatch;

public class DeletingNodeTest {
	
	public static void main(String[] args) {
		
		Node head = new Node(1);
		
		head.appendToTail(2);
		head.appendToTail(3);
		head.appendToTail(4);
		head.appendToTail(5);
		head.appendToTail(6);
		head.appendToTail(7);
		head.appendToTail(8);
		head.appendToTail(9);
		
		
		printAllNodes(head);
		
		Node tt = printNode(head , 3);
		System.out.println(tt.data);
		
		nthToLast(head, 3);
		
		tt = printNthNode(head, 3);
		System.out.println(tt.data);
		
	}
	
	public static void printAllNodes(Node head){
		
		if(head == null){
			return;
		}
		
		Node tmp = head;
		
		while(tmp != null){
			System.out.println(tmp.data);
			tmp = tmp.next;
		}
		
	}
	
	public static int nthToLast(Node head, int k ){
		if(head == null){
			return 0;
		}
		
		int i = nthToLast(head.next, k) + 1;
		
		if(i == k ){
			System.out.println(head.data);
		}
		
		return i;
	}
	
	public static Node printNthNode(Node head, int k){
		
		if(head == null){
			return null;
		}
		
		Node p1 = head;
		Node p2 = head;
		
		for(int i = 0; i < k; i++){
			p2 = p2.next;
		}
		
		
		
		while(p2 != null){
			p2 = p2.next;
			p1 = p1.next;
		}
		
		return p1;
	}
	
	public static Node printNode(Node head , int k ){
		
		if(head == null){
			return null;
		}
		
		Node tmp = head;
		
		int cnt = 0;
		
		while(tmp != null){
			cnt++;
			tmp = tmp.next;
		}
		
		tmp = head;
		
		int idx = 0;
		
		Node result = null;
		
		while(tmp != null){
			
			if(idx == cnt - k){
				result = tmp;
				break;
			}
			
			idx++;
			tmp = tmp.next;
		}
		
		return result;
	}
	

}

class Node{
	
	Node next = null;
	int data;
	
	public Node(int d){
		this.data = d;
	}
	
	
	void appendToTail(int d){
		Node end = new Node(d);
		Node n = this;
		while(n.next != null){
			n = n.next;
		}
		
		n.next = end;
	}
}