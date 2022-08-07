import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		Tree<String> tree = new Tree(null);
		int N = Integer.parseInt(in.readLine());
		for (int i = 1; i <= N; i++) {
			String[] split = in.readLine().split(" ");
			
			if (split[0].equals("A")) {
				tree.setRoot(new Node<String>(split[0]));
				if (!split[1].equals(".")) {
					tree.getRoot().setLeft(new Node<String>(split[1]));
				}
				if (!split[2].equals(".")) {
					tree.getRoot().setRight(new Node<String>(split[2]));
				}
				continue;
			}			
			Node<String> getNode = tree.search(tree.getRoot(), split[0]);
			if (!split[1].equals(".")) {
				getNode.setLeft(new Node<String>(split[1]));
			}
			if (!split[2].equals(".")) {
				getNode.setRight(new Node<String>(split[2]));
			}
		}

		tree.preorder(tree.getRoot());
		System.out.println();
		tree.inorder(tree.getRoot());
		System.out.println();
		tree.postorder(tree.getRoot());
		System.out.println();

	}
}

class Node<T>{
	private T element;
	private Node<T> paraent;
	private Node<T> left;
	private Node<T> right;
	
	// 생성자
	Node(T element){
		this.element = element;
		this.paraent = null;
		this.left = null;
		this.right = null;
	}
	
	Node(T element, Node<T> left, Node<T> right){
		this.element = element;
		this.paraent = null;
		this.left = left;
		this.right = right;
	}
	public T getEelement() {
		return this.element;
	}
	public void setEelement(T element) {
		this.element = element;
	}
	public Node<T> getParaent() {
		return paraent;
	}

	public void setParaent(Node<T> paraent) {
		this.paraent = paraent;
	}

	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}

	public void setElement(T element) {
		this.element = element;
	}
}

class Tree<T>{
	private Node<T> root;
	private int size;
	public Tree(Node<T> root) {
		super();
		this.root = root;
		if (root != null) {
			size = 1;
		}
	}
	public Node<T> getRoot() {
		return root;
	}
	public void setRoot(Node<T> root) {
		if (root != null) {
			size = 1;
		}
		this.root = root;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public void addLeft(Node<T> parent, Node<T> child) {
		if (parent.getLeft() == null) {
			size++;
			parent.setLeft(child);
		}
	}
	public void addRight(Node<T> parent, Node<T> child) {
		if (parent.getRight() == null) {
			size++;
			parent.setRight(child);
		}
	}
	
	public Node<T> search(Node<T> node, T element){
		Node<T> getNode = null;
		
		if (node != null) {
			if (node.getEelement().equals(element)) {
				return node;
			}
			else {
				if(node.getLeft() != null) {
					getNode = search(node.getLeft(), element);
				}
				if(getNode == null && node.getRight() !=null) {
					getNode =search(node.getRight(), element);					
				}
			}
		}
		return getNode;
	}
	
	public void preorder(Node<T> node) {
		System.out.print(node.getEelement());
		if(node.getLeft() != null) {
			preorder(node.getLeft());
		}
		if(node.getRight() !=null) {
			preorder(node.getRight());
		}
	}
	
	public void inorder(Node<T> node) {
		if (node == null) {
			return;
		}
		
		inorder(node.getLeft());
		System.out.print(node.getEelement());			
		inorder(node.getRight());
	}
	
	public void postorder(Node<T> node) {
		if(node.getLeft() != null) {
			postorder(node.getLeft());
		}
		if(node.getRight() !=null) {
			postorder(node.getRight());
		}
		System.out.print(node.getEelement());			
	}
}