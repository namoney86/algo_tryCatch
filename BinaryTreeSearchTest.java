package tryCatch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class BinaryTreeSearchTest {
	
	public static void main(String[] args) throws FileNotFoundException{
		
		Scanner scanner = new Scanner(System.in);
		
		int input = 0;
		
		BinaryTree binaryTree = new BinaryTreeImpl();
		
		while( input != 6 ){
			
			System.out.println("메뉴를 입력하세요.");
			System.out.println("1:단체삽입 2:삽입 3:전체조회 4:검색 5:삭제 6:종료): ");
			
			input = scanner.nextInt();
			
			
			
			switch (input) {
			case 1:
				insertAll(binaryTree);
				
				break;
			case 2:
				insertStudent(binaryTree);
				
				break;
			case 3:
				printAllStudent(binaryTree);
				break;
			case 4:
				searchScoreByStudentNum(binaryTree);
				break;
			case 5:
				deleteStudent(binaryTree);
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("메뉴를 확인하고 다시 입력해주세요.");;
			}
			
			
			
		}
		
		scanner.close();
		
		
	}
	
	public static void insertAll(BinaryTree binaryTree)throws FileNotFoundException{
		Scanner scanner = new Scanner(new File("hw5_1.txt"));
		int length = scanner.nextInt();
		
		for(int i = 0; i < length; i++){
			int studentNum = scanner.nextInt();
			int score = scanner.nextInt();
			
			binaryTree.treeInsert(studentNum, score);
			
			System.out.println(studentNum + " 삽입");
		}
		
	}
	
	public static void insertStudent(BinaryTree binaryTree){
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("학번 입력 : ");
		int studentNum = scanner.nextInt();
		
		System.out.print("성적 입력 : ");
		int score = scanner.nextInt();
		
		binaryTree.treeInsert(studentNum, score);
		
		System.out.println(studentNum + " 삽입");
	}

	public static void deleteStudent(BinaryTree binaryTree){
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("학번 입력 : ");
		int studentNum = scanner.nextInt();
		
		binaryTree.treeDelete(studentNum);
		
		System.out.println(studentNum + " 삭제");
	}
	
	public static void printAllStudent(BinaryTree binaryTree){
		binaryTree.printTree();
	}
	
	public static void searchScoreByStudentNum(BinaryTree binaryTree){
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("학번 입력: ");
		int studentNum = scanner.nextInt();
		
		/*int score = binaryTree.treeSearchScore(studentNum);
		*/
		
		int score = binaryTree.treeSearchNoRecursive(studentNum);
		
		if(score == -1){
			System.out.println("존재하지 않는 학번입니다.");
		}else{
			System.out.println("성적은 : " + score);
		}
	}
}

interface BinaryTree{
	
	public void treeInsert(int studentNum, int score);
	
	public void treeDelete(int studentNum);
	
	public void printTree();
	
	public int treeSearchScore(int studentNum);
	
	public int treeSearchNoRecursive(int studentNum);
}


class BinaryTreeImpl implements BinaryTree{
	
	private Node root;

	private Node treeSearch(Node t, int studentNum){
		if(t == null || t.value.studentNum == studentNum){
			return t;
		}
		
		if(studentNum < t.value.studentNum){
			return treeSearch(t.left, studentNum);
		}else{
			return treeSearch(t.right, studentNum);
		}
	}
	
	public int treeSearchNoRecursive(int studentNum){
		return treeSearchNoRecursive(this.root, studentNum).value.score;
	}
	
	
	private Node treeSearchNoRecursive(Node root, int studentNum){
		
		Node t = root;
		
		while(t != null){
			
			if(t.value.studentNum == studentNum){
				return t;
			}
			
			if(t.value.studentNum > studentNum){
				t = t.left;
			}else{
				t = t.right;
			}
		}
		
		return null;
	}
	
	
	private Node treeSearchParent(Node t, Node r){
		
		if(t == r){
			return null;
		}
		
		if(t.left == r || t.right == r){
			return t; 
		}else{
			if(r.value.studentNum > t.value.studentNum){
				return treeSearchParent(t.right, r);
			}else{
				return treeSearchParent(t.left, r);
			}
		}
	}
	
	@Override
	public int treeSearchScore(int studentNum) {
		Node result = treeSearch(root, studentNum);
		
		if(result == null){
			return -1;
		}
		return result.value.score;
	}

	/*@Override
	public void treeInsert(int studentNum, int score) {
		Student student = new Student(studentNum, score);
		this.root = treeInsert(this.root, student);
	}
	
	
	
	private Node treeInsert(Node t, Student student){
		
		if(t == null){
			return new Node(student);
		}
		
		if(student.studentNum < t.value.studentNum){
			t.left = treeInsert(t.left, student);		//타고 타고 올라가서 결국 기존의 루트 주소값을 리턴한다.
			return t;
		}else if(student.studentNum > t.value.studentNum){
			t.right = treeInsert(t.right, student);
			return t;
		}else{
			t.value.score = student.score;
			return t;
		}
	}
	*/
	
	public void treeInsert(int studentNum, int score) {
		Student student = new Student(studentNum, score);
		this.root = treeInsert(this.root, student);
	}
	
	
	private Node treeInsert(Node root, Student student){
		
		Node newNode = new Node(student);
		
		if(root == null){
			return newNode;
		}
		
		Node p = root;
		Node before = null;
		
		while(p != null){
			
			before = p;
			
			if(p.value.studentNum > student.studentNum){
				p = p.left;
			}else{
				p = p.right;
			}
			
		}
		
		if(before.value.studentNum > student.studentNum){
			before.left = newNode;
		}else{
			before.right = newNode;
		}
		
		return root;
	}
	
	@Override
	public void printTree() {
		treeInorderTraverse(this.root);
	}
	
	/*private void treeInorderTraverse(Node t){
		if(t != null){
			treeInorderTraverse(t.left);
			System.out.println(t.value.studentNum + " - " + t.value.score);
			treeInorderTraverse(t.right);
		}
	}*/
	
	
	private void treeInorderTraverse(Node root){
		
		if(root == null){
			return;
		}
		
		Stack<Node> stack = new Stack<>();
		Node p = root;
		
		while(!stack.isEmpty() || p != null){
			
			if(p != null){
				
				stack.push(p);
				p = p.left;
				
			}else{ 
				Node tmp = stack.pop();
				System.out.println(tmp.value.studentNum + " -- " + tmp.value.score);
				p = tmp.right;		
			}
		}
	}
	
	
	

	@Override
	public void treeDelete(int studentNum) {
		Node delNode = treeSearch(this.root, studentNum);
		
		if(delNode == null){
			System.out.println("존재하지 않는 학번입니다.");
		}else{
			Node parentNode = treeSearchParent(this.root , delNode);
			
			treeDelete(this.root, delNode, parentNode);
		}
	}
	
	private void treeDelete(Node t, Node r, Node p){
		if(r == t){
			this.root = deleteNode(t);
		}else if(r == p.left){
			p.left = deleteNode(r);
		}else{
			p.right = deleteNode(r);
		}
	}

	
	private Node deleteNode(Node r){
		
		if(r.left == r.right && r.left == null){
			return null;
		}else if(r.left == null && r.right != null){
			return r.right;
		}else if(r.left != null && r.right == null){
			return r.left;
		}else{
			Node s = r.right;
			
			Node parent = null;
			
			while(s.left != null){
				parent = s;
				s = s.left;
			}
			
			r.value = s.value;
			
			if(s == r.right){
				r.right = s.right;
			}else{
				parent.left = s.right;
			}
			
			return r;
		}
		
	}
	


	class Node{
		Node left;
		Student value;
		Node right;
		
		public Node(Student student){
			this.value = student;
		}
	}


	class Student{
		int studentNum;
		int score;
		
		public Student(int studentNum, int score){
			this.studentNum = studentNum;
			this.score = score;
		}
	}
}