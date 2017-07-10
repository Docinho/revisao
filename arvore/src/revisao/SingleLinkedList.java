package revisao;

public class SingleLinkedList {

	private Node head;

	public SingleLinkedList() {
		this.head = new Node();
	}

	public void insert(int element) {
		this.head.insert(element);
	}

	public int remove(int element) {
		int back = this.getHead().getData();

		if (back == element)
			this.setHead(this.getHead().getNext());
		else
			back = this.head.remove(element);

		return back;
	}

	private void setHead(Node head) {
		this.head = head;
	}

	public Node getHead() {
		return head;
	}

	public Node search(int element) {
		return this.getHead().search(element);
	}

	public int size() {
		return this.getHead().size();

	}

}

class Node {

	private int data;
	private Node next;

	public int getData() {
		return data;
	}

	public int size() {
		if (this.isEmpty())
			return 0;
		return 1 + this.getNext().size();
	}

	public Node search(int element) {
		if (this.getData() == element)
			return this;
		if (this.getNext() == null || this.getNext().isEmpty())
			return new Node();
		return this.getNext().search(element);
	}

	public int remove(int element) {
		int back = 0;
		if (!this.isEmpty()) {

			back = this.getNext().getData();
			if (back == element) {
				this.setNext(this.getNext().getNext());
				return back;
			} else
				return this.getNext().remove(element);
		}
			return back;
		
		
	}

	public void insert(int element) {
		if (this.isEmpty()) {
			this.data = element;
			this.setNext(new Node());
		} else
		
		this.getNext().insert(element);
	}

	public boolean isEmpty() {
		return data == 0;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}
