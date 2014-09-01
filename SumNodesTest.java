package tryCatch;

import java.util.Scanner;

public class SumNodesTest {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int num01 = scanner.nextInt();
		int num02 = scanner.nextInt();

		scanner.close();
		
		Node val01 = intToNode(num01);
		Node val02 = intToNode(num02);
		
		Node result = sumTwoNodes(val01 , val02);
		
		while(result != null){
			System.out.print(result.data + " ");
			result = result.next;
		}
		
	}
	
	public static Node sumTwoNodes(Node n1, Node n2){
		Node result = null;
		
		int orm = 0;
		
		while(n1 != null && n2 != null){
			
			int rest = (n1.data + n2.data)%10;
			int share = (n1.data + n2.data)/10;
			
			if(result == null){
				result = new Node(rest);
			}else{
				result.appendToTail(rest + orm);
				orm = 0;
			}
			
			if(share > 0){
				orm = share;
			}
			
			n1 = n1.next;
			n2 = n2.next;
		}
		
		while(n1 != null){
			result.appendToTail(n1.data + orm );
			n1 = n1.next;
		}
		
		while(n2 != null){
			result.appendToTail(n2.data + orm );
			n2 = n2.next;
		}
		
		
		return result;
	}
	
	public static Node intToNode(int num){
		
		Node node = null;
		
		int val = num;
		
		while(val > 0){
		
			int rest = val%10;
			
			val = val/10;
			
			if(node == null){
				node = new Node(rest);
			}else{
				node.appendToTail(rest);
			}
		
		}
	
		return node;
		
	}
	
}
