package arvore;

public class Node<T extends Comparable<T>> {

	private T data;
	private Node left;
	private Node right;
	private Node predecessor;
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public boolean isEmpty() {
		return data == null;
	}

	@Override
	public String toString() {
		return "data: " + getData() + "\n" + "esquerda: " + getLeft().getData() + "\n" + "direita: " + getRight().getData() + "\n";
	}
	public Node getParent() {
		return this.predecessor;
	}
	public void setParent(Node predecessor) {
		this.predecessor = predecessor;
	}
	public boolean isLeaf() {
		return this.getLeft().getData() == null && this.getRight().getData() == null;
	}

}
