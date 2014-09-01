package tryCatch;

public class OnlyUniqueNumberTest {
	
	public static void main(String[] args) throws Exception {
		
		Node head = new Node(1);
		head.appendToTail(8);
		head.appendToTail(9);
		head.appendToTail(7);
		head.appendToTail(0);
		head.appendToTail(4);
		head.appendToTail(4);
		head.appendToTail(-1);
		head.appendToTail(2);
		head.appendToTail(-9);
		head.appendToTail(10);
		
		
		System.out.println("원본");
		DeletingNodeTest.printAllNodes(head);
		System.out.println();
		
		System.out.println();
		System.out.println("정렬");
		Node list = orderNodeNumber(head, 3);
		DeletingNodeTest.printAllNodes(list);
		
		/*System.out.println("중복 제거");
		removeOverlapNumber(head);
		DeletingNodeTest.printAllNodes(head);*/
		
		
		System.out.println(3200 << 4);
		
	}
	
	public static void removeOverlapNumber(Node head){
		
		if(head == null){
			return;
		}
		
		Node p1 = head;
		Node p2 = null;
		
		
		while(p1 != null){
			
			p2 = p1;
			
			while(p2.next != null){
				
				if(p1.data == p2.next.data){
					p2.next = p2.next.next;
				}else{
					p2 = p2.next;
				}
			}
			
			p1 = p1.next;
		}
		
	}
	
	public static Node orderNodeNumber(Node head, int k) throws Exception{
		
		if(head == null)
			return null;
		
		Node bigger = null;
		Node smaller = null;
		
		/*while(head.next != null){
			
			if(head.data >= k){
				
				if(bigger == null){
					bigger = new Node(head.data);
				}else{
					Node newNode = new Node(head.data);
					newNode.next = bigger;
					bigger = newNode;
				}
			}else{
				
				if(smaller == null){
					smaller = new Node(head.data);
				}else{
					Node newNode = new Node(head.data);
					newNode.next = smaller;
					smaller = newNode;
				}
			}
			
			head = head.next;
		}*/
		
		while(head != null){
			Node next = head.next;
			
			
			if(head.data < k){
				head.next = smaller;
				smaller = head;
			}else{
				head.next = bigger;
				bigger = head;
			}
			
			head = next;
		}
		
		
		Node list = smaller;
		
		while(smaller.next != null){
			smaller = smaller.next;
		}
		
		
		smaller.next = bigger;
			
		return list;
	}
	
	
}


